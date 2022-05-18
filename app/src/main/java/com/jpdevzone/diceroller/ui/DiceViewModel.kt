package com.jpdevzone.diceroller.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jpdevzone.diceroller.util.AdCounter

class DiceViewModel(app: Application): AndroidViewModel(app) {
    private val _diceOnScreen = MutableLiveData<Int>()
    val diceOnScreen: LiveData<Int> = _diceOnScreen

    fun increaseDice() {
        _diceOnScreen.value = (_diceOnScreen.value?.plus(1))?.coerceAtMost(9)
        _resultOnScreen.value = 0
        increaseAdCounter()
    }

    fun decreaseDice() {
        _diceOnScreen.value = (_diceOnScreen.value?.minus(1))?.coerceAtLeast(1)
        _resultOnScreen.value = 0
        increaseAdCounter()
    }


    private val _diceOne = MutableLiveData<Int>()
    val diceOne: LiveData<Int> = _diceOne

    private val _diceTwo = MutableLiveData<Int>()
    val diceTwo: LiveData<Int> = _diceTwo

    private val _diceThree = MutableLiveData<Int>()
    val diceThree: LiveData<Int> = _diceThree

    private val _diceFour = MutableLiveData<Int>()
    val diceFour: LiveData<Int> = _diceFour

    private val _diceFive = MutableLiveData<Int>()
    val diceFive: LiveData<Int> = _diceFive

    private val _diceSix = MutableLiveData<Int>()
    val diceSix: LiveData<Int> = _diceSix

    private val _diceSeven = MutableLiveData<Int>()
    val diceSeven: LiveData<Int> = _diceSeven

    private val _diceEight = MutableLiveData<Int>()
    val diceEight: LiveData<Int> = _diceEight

    private val _diceNine = MutableLiveData<Int>()
    val diceNine: LiveData<Int> = _diceNine

    private fun roll(): Int {
        return (1..6).random()
    }

    private val _resultOnScreen = MutableLiveData<Int?>()
    val resultOnScreen: LiveData<Int?> = _resultOnScreen

    fun rollDices() {
        when (diceOnScreen.value) {
            1 -> {
                _resultOnScreen.value = null
                _diceFive.value = roll()
                _resultOnScreen.value = _diceFive.value
                Log.i("TESTING", _resultOnScreen.value.toString())
            }
            2 -> {
                _resultOnScreen.value = null
                _diceFour.value = roll()
                _diceSix.value = roll()
                _resultOnScreen.value = _diceFour.value!! + _diceSix.value!!
                Log.i("TESTING", _resultOnScreen.value.toString())
            }
            3 -> {
                _resultOnScreen.value = null
                _diceOne.value = roll()
                _diceFive.value = roll()
                _diceNine.value = roll()
                _resultOnScreen.value = _diceOne.value!! + _diceFive.value!! + _diceNine.value!!
                Log.i("TESTING", _resultOnScreen.value.toString())
            }
            4 -> {
                _resultOnScreen.value = null
                _diceOne.value = roll()
                _diceThree.value = roll()
                _diceSeven.value = roll()
                _diceNine.value = roll()
                _resultOnScreen.value = _diceOne.value!! + _diceThree.value!! + _diceSeven.value!! + _diceNine.value!!
            }
            5 -> {
                _resultOnScreen.value = null
                _diceOne.value = roll()
                _diceThree.value = roll()
                _diceFive.value = roll()
                _diceSeven.value = roll()
                _diceNine.value = roll()
                _resultOnScreen.value = _diceOne.value!! + _diceThree.value!! + _diceFive.value!! +
                        _diceSeven.value!! + _diceNine.value!!
            }
            6 -> {
                _resultOnScreen.value = null
                _diceOne.value = roll()
                _diceThree.value = roll()
                _diceFour.value = roll()
                _diceSix.value = roll()
                _diceSeven.value = roll()
                _diceNine.value = roll()
                _resultOnScreen.value = _diceOne.value!! + _diceThree.value!! + _diceFour.value!! +
                        _diceSix.value!! + _diceSeven.value!! + _diceNine.value!!
            }
            7 -> {
                _resultOnScreen.value = null
                _diceOne.value = roll()
                _diceThree.value = roll()
                _diceFour.value = roll()
                _diceFive.value = roll()
                _diceSix.value = roll()
                _diceSeven.value = roll()
                _diceNine.value = roll()
                _resultOnScreen.value = _diceOne.value!! + _diceThree.value!! + _diceFour.value!! +
                        _diceFive.value!! + _diceSix.value!! + _diceSeven.value!! + _diceNine.value!!
            }
            8 -> {
                _resultOnScreen.value = null
                _diceOne.value = roll()
                _diceTwo.value = roll()
                _diceThree.value = roll()
                _diceFour.value = roll()
                _diceSix.value = roll()
                _diceSeven.value = roll()
                _diceEight.value = roll()
                _diceNine.value = roll()
                _resultOnScreen.value = _diceOne.value!! + _diceTwo.value!! + _diceThree.value!! + _diceFour.value!! +
                        _diceSix.value!! + _diceSeven.value!! + _diceEight.value!! + _diceNine.value!!
            }
            9 -> {
                _resultOnScreen.value = null
                _diceOne.value = roll()
                _diceTwo.value = roll()
                _diceThree.value = roll()
                _diceFour.value = roll()
                _diceFive.value = roll()
                _diceSix.value = roll()
                _diceSeven.value = roll()
                _diceEight.value = roll()
                _diceNine.value = roll()
                _resultOnScreen.value = _diceOne.value!! + _diceTwo.value!! + _diceThree.value!! + _diceFour.value!! +
                        _diceFive.value!! + _diceSix.value!! + _diceSeven.value!! + _diceEight.value!! + _diceNine.value!!
            }
        }
    }

    private val _adCounter = MutableLiveData<Int>()
    val adCounter: LiveData<Int>
    get() = _adCounter

    private fun increaseAdCounter() {
        _adCounter.value = _adCounter.value?.plus(1)
        Log.d("Counter", _adCounter.value.toString())
    }

    init {
        initialValues()
        _adCounter.value = AdCounter.getAdCounter(app)
    }

    private fun initialValues() {
        _diceOnScreen.value = 1
        _resultOnScreen.value = 0
        _diceOne.value = roll()
        _diceTwo.value = roll()
        _diceThree.value = roll()
        _diceFour.value = roll()
        _diceFive.value = roll()
        _diceSix.value = roll()
        _diceSeven.value = roll()
        _diceEight.value = roll()
        _diceNine.value = roll()
    }
}