package com.jpdevzone.diceroller.model

class Dice() {
    fun roll(): Int {
        return (1..6).random()
    }
}