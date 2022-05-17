package com.jpdevzone.diceroller.util

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.jpdevzone.diceroller.R

@BindingAdapter("setDiceOne")
fun setDiceOne(view: ImageView, diceOnScreen: Int) {
    when (diceOnScreen) {
        1 -> view.visibility = View.INVISIBLE
        2 -> view.visibility = View.INVISIBLE
        3 -> view.visibility = View.VISIBLE
        4 -> view.visibility = View.VISIBLE
        5 -> view.visibility = View.VISIBLE
        6 -> view.visibility = View.VISIBLE
        7 -> view.visibility = View.VISIBLE
        8 -> view.visibility = View.VISIBLE
        9 -> view.visibility = View.VISIBLE
    }
}

@BindingAdapter("setDiceTwo")
fun setDiceTwo(view: ImageView, diceOnScreen: Int) {
    when (diceOnScreen) {
        1 -> view.visibility = View.INVISIBLE
        2 -> view.visibility = View.INVISIBLE
        3 -> view.visibility = View.INVISIBLE
        4 -> view.visibility = View.INVISIBLE
        5 -> view.visibility = View.INVISIBLE
        6 -> view.visibility = View.INVISIBLE
        7 -> view.visibility = View.INVISIBLE
        8 -> view.visibility = View.VISIBLE
        9 -> view.visibility = View.VISIBLE
    }
}

@BindingAdapter("setDiceThree")
fun setDiceThree(view: ImageView, diceOnScreen: Int) {
    when (diceOnScreen) {
        1 -> view.visibility = View.INVISIBLE
        2 -> view.visibility = View.INVISIBLE
        3 -> view.visibility = View.INVISIBLE
        4 -> view.visibility = View.VISIBLE
        5 -> view.visibility = View.VISIBLE
        6 -> view.visibility = View.VISIBLE
        7 -> view.visibility = View.VISIBLE
        8 -> view.visibility = View.VISIBLE
        9 -> view.visibility = View.VISIBLE
    }
}

@BindingAdapter("setDiceFour")
fun setDiceFour(view: ImageView, diceOnScreen: Int) {
    when (diceOnScreen) {
        1 -> view.visibility = View.INVISIBLE
        2 -> view.visibility = View.VISIBLE
        3 -> view.visibility = View.INVISIBLE
        4 -> view.visibility = View.INVISIBLE
        5 -> view.visibility = View.INVISIBLE
        6 -> view.visibility = View.VISIBLE
        7 -> view.visibility = View.VISIBLE
        8 -> view.visibility = View.VISIBLE
        9 -> view.visibility = View.VISIBLE
    }
}

@BindingAdapter("setDiceFive")
fun setDiceFive(view: ImageView, diceOnScreen: Int) {
    when (diceOnScreen) {
        1 -> view.visibility = View.VISIBLE
        2 -> view.visibility = View.INVISIBLE
        3 -> view.visibility = View.VISIBLE
        4 -> view.visibility = View.INVISIBLE
        5 -> view.visibility = View.VISIBLE
        6 -> view.visibility = View.INVISIBLE
        7 -> view.visibility = View.VISIBLE
        8 -> view.visibility = View.INVISIBLE
        9 -> view.visibility = View.VISIBLE
    }
}

@BindingAdapter("setDiceSix")
fun setDiceSix(view: ImageView, diceOnScreen: Int) {
    when (diceOnScreen) {
        1 -> view.visibility = View.INVISIBLE
        2 -> view.visibility = View.VISIBLE
        3 -> view.visibility = View.INVISIBLE
        4 -> view.visibility = View.INVISIBLE
        5 -> view.visibility = View.INVISIBLE
        6 -> view.visibility = View.VISIBLE
        7 -> view.visibility = View.VISIBLE
        8 -> view.visibility = View.VISIBLE
        9 -> view.visibility = View.VISIBLE
    }
}

@BindingAdapter("setDiceSeven")
fun setDiceSeven(view: ImageView, diceOnScreen: Int) {
    when (diceOnScreen) {
        1 -> view.visibility = View.INVISIBLE
        2 -> view.visibility = View.INVISIBLE
        3 -> view.visibility = View.INVISIBLE
        4 -> view.visibility = View.VISIBLE
        5 -> view.visibility = View.VISIBLE
        6 -> view.visibility = View.VISIBLE
        7 -> view.visibility = View.VISIBLE
        8 -> view.visibility = View.VISIBLE
        9 -> view.visibility = View.VISIBLE
    }
}

@BindingAdapter("setDiceEight")
fun setDiceEight(view: ImageView, diceOnScreen: Int) {
    when (diceOnScreen) {
        1 -> view.visibility = View.INVISIBLE
        2 -> view.visibility = View.INVISIBLE
        3 -> view.visibility = View.INVISIBLE
        4 -> view.visibility = View.INVISIBLE
        5 -> view.visibility = View.INVISIBLE
        6 -> view.visibility = View.INVISIBLE
        7 -> view.visibility = View.INVISIBLE
        8 -> view.visibility = View.VISIBLE
        9 -> view.visibility = View.VISIBLE
    }
}

@BindingAdapter("setDiceNine")
fun setDiceNine(view: ImageView, diceOnScreen: Int) {
    when (diceOnScreen) {
        1 -> view.visibility = View.INVISIBLE
        2 -> view.visibility = View.INVISIBLE
        3 -> view.visibility = View.VISIBLE
        4 -> view.visibility = View.VISIBLE
        5 -> view.visibility = View.VISIBLE
        6 -> view.visibility = View.VISIBLE
        7 -> view.visibility = View.VISIBLE
        8 -> view.visibility = View.VISIBLE
        9 -> view.visibility = View.VISIBLE
    }
}

@BindingAdapter("setImage")
fun setImage(view: ImageView, result: Int?) {
        when (result) {
            1 -> view.setImageResource(R.drawable.dice1)
            2 -> view.setImageResource(arrayOf(R.drawable.dice2_1, R.drawable.dice2_2).random())
            3 -> view.setImageResource(arrayOf(R.drawable.dice3_1, R.drawable.dice3_2).random())
            4 -> view.setImageResource(R.drawable.dice4)
            5 -> view.setImageResource(R.drawable.dice5)
            6 -> view.setImageResource(arrayOf(R.drawable.dice6_1, R.drawable.dice6_2).random())
            else -> view.setImageResource(
                listOf(
                    R.drawable.dice1,
                    R.drawable.dice2_1,
                    R.drawable.dice2_2,
                    R.drawable.dice3_1,
                    R.drawable.dice3_2,
                    R.drawable.dice4,
                    R.drawable.dice5,
                    R.drawable.dice6_1,
                    R.drawable.dice6_2).shuffled()[0]
            )
    }
}
