package com.jpdevzone.diceroller.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jpdevzone.diceroller.model.Dice

class DiceViewModel: ViewModel() {
    private val _diceOnScreen = MutableLiveData<Int>()
    val diceOnScreen: LiveData<Int> = _diceOnScreen


    private val _diceOne = MutableLiveData<Dice>()
    val diceOne: LiveData<Dice> = _diceOne

    private val _diceTwo = MutableLiveData<Dice>()
    val diceTwo: LiveData<Dice> = _diceTwo

    private val _diceThree = MutableLiveData<Dice>()
    val diceThree: LiveData<Dice> = _diceThree

    private val _diceFour = MutableLiveData<Dice>()
    val diceFour: LiveData<Dice> = _diceFour

    private val _diceFive = MutableLiveData<Dice>()
    val diceFive: LiveData<Dice> = _diceFive

    private val _diceSix = MutableLiveData<Dice>()
    val diceSix: LiveData<Dice> = _diceSix

    private val _diceSeven = MutableLiveData<Dice>()
    val diceSeven: LiveData<Dice> = _diceSeven

    private val _diceEight = MutableLiveData<Dice>()
    val diceEight: LiveData<Dice> = _diceEight

    private val _diceNine = MutableLiveData<Dice>()
    val diceNine: LiveData<Dice> = _diceNine

    init {

    }
}