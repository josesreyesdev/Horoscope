package com.jsrdev.horoscope.ui.providers

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class RandomCardProviderTest {

    @Test
    fun `getRandomCard should return a random card`() {
        val randomCard = RandomCardProvider()

        val card = randomCard.getLucky()

        assertNotNull(card)
    }
}