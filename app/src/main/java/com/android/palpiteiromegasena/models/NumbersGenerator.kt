package com.android.palpiteiromegasena.models

import kotlin.random.Random

class NumbersGenerator(private var numbersNeeded: Int) {
    private var max = 60

    fun generate(): MutableList<Int> {
        val generated = mutableListOf<Int>()
        for (i in 0 until numbersNeeded) {
            while (true) {
                val next = Random.nextInt(max) + 1
                if (!generated.contains(next)) {
                    generated.add(next)
                    break
                }
            }
        }

        generated.sort()
        return generated
    }
}