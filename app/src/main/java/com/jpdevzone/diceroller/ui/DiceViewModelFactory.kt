package com.jpdevzone.diceroller.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DiceViewModelFactory() : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiceViewModel::class.java)) {
            return DiceViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}