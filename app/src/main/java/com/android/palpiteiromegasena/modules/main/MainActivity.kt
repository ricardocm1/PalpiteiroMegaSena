package com.android.palpiteiromegasena.modules.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import com.android.palpiteiromegasena.R
import com.android.palpiteiromegasena.models.NumbersGenerator
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.circle_view.view.*


class MainActivity : AppCompatActivity() {
    private var adRequest: AdRequest? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, resources.getString(R.string.admob_app_id))
        this.adRequest = AdRequest.Builder().build()

        spinnerGameNumbers.setItems(6, 7, 8, 9, 10, 11, 12, 13, 14, 15)

        buttonGenerateNumbers.setOnClickListener {
            textViewNumbersMessage.visibility = View.VISIBLE
            numbersContainer.removeAllViews()

            val gameNumbers = Integer.parseInt(spinnerGameNumbers.text.toString())
            val numbersGenerated = NumbersGenerator(gameNumbers).generate()

            numbersGenerated.forEach {
                val viewNumber = layoutInflater.run { inflate(R.layout.circle_view, numbersContainer, false) }
                viewNumber.textViewNumber.text = it.toString()

                numbersContainer.addView(viewNumber)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        if (this.adRequest != null)
            adView.loadAd(adRequest)
    }
}