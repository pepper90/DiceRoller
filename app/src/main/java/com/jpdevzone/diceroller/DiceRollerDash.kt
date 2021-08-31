package com.jpdevzone.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.jpdevzone.diceroller.databinding.DiceRollerDashBinding
import kotlin.random.Random

class DiceRollerDash : AppCompatActivity() {
    private lateinit var binding: DiceRollerDashBinding
    private lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DiceRollerDashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rollButton = binding.rollButton
        rollButton.setOnClickListener {
            rollTwoDices()
        }
    }

    private fun rollOneDice() {
        val score = binding.tvScore
        val randomInt = Random.nextInt(6) + 1
        score.text = randomInt.toString()

        when (randomInt) {
            1 -> {
                binding.diceFiveDotOne.visibility = View.INVISIBLE
                binding.diceFiveDotTwo.visibility = View.INVISIBLE
                binding.diceFiveDotThree.visibility = View.INVISIBLE
                binding.diceFiveDotFour.visibility = View.VISIBLE
                binding.diceFiveDotFive.visibility = View.INVISIBLE
                binding.diceFiveDotSix.visibility = View.INVISIBLE
                binding.diceFiveDotSeven.visibility = View.INVISIBLE
            }
            2 -> {
                binding.diceFiveDotOne.visibility = View.VISIBLE
                binding.diceFiveDotTwo.visibility = View.INVISIBLE
                binding.diceFiveDotThree.visibility = View.INVISIBLE
                binding.diceFiveDotFour.visibility = View.INVISIBLE
                binding.diceFiveDotFive.visibility = View.INVISIBLE
                binding.diceFiveDotSix.visibility = View.INVISIBLE
                binding.diceFiveDotSeven.visibility = View.VISIBLE
            }
            3 -> {
                binding.diceFiveDotOne.visibility = View.VISIBLE
                binding.diceFiveDotTwo.visibility = View.INVISIBLE
                binding.diceFiveDotThree.visibility = View.INVISIBLE
                binding.diceFiveDotFour.visibility = View.VISIBLE
                binding.diceFiveDotFive.visibility = View.INVISIBLE
                binding.diceFiveDotSix.visibility = View.INVISIBLE
                binding.diceFiveDotSeven.visibility = View.VISIBLE
            }
            4 -> {
                binding.diceFiveDotOne.visibility = View.VISIBLE
                binding.diceFiveDotTwo.visibility = View.VISIBLE
                binding.diceFiveDotThree.visibility = View.INVISIBLE
                binding.diceFiveDotFour.visibility = View.INVISIBLE
                binding.diceFiveDotFive.visibility = View.INVISIBLE
                binding.diceFiveDotSix.visibility = View.VISIBLE
                binding.diceFiveDotSeven.visibility = View.VISIBLE
            }
            5 -> {
                binding.diceFiveDotOne.visibility = View.VISIBLE
                binding.diceFiveDotTwo.visibility = View.VISIBLE
                binding.diceFiveDotThree.visibility = View.INVISIBLE
                binding.diceFiveDotFour.visibility = View.VISIBLE
                binding.diceFiveDotFive.visibility = View.INVISIBLE
                binding.diceFiveDotSix.visibility = View.VISIBLE
                binding.diceFiveDotSeven.visibility = View.VISIBLE
            }
            6 -> {
                binding.diceFiveDotOne.visibility = View.VISIBLE
                binding.diceFiveDotTwo.visibility = View.VISIBLE
                binding.diceFiveDotThree.visibility = View.VISIBLE
                binding.diceFiveDotFour.visibility = View.INVISIBLE
                binding.diceFiveDotFive.visibility = View.VISIBLE
                binding.diceFiveDotSix.visibility = View.VISIBLE
                binding.diceFiveDotSeven.visibility = View.VISIBLE
            }
        }
    }

    private fun rollTwoDices() {
        val score = binding.tvScore
        val randomIntDiceFour = Random.nextInt(6) + 1
        val randomIntDiceSix = Random.nextInt(6) + 1
        score.text = (randomIntDiceFour + randomIntDiceSix).toString()

        when (randomIntDiceFour) {
            1 -> {
                binding.diceFourDotOne.visibility = View.INVISIBLE
                binding.diceFourDotTwo.visibility = View.INVISIBLE
                binding.diceFourDotThree.visibility = View.INVISIBLE
                binding.diceFourDotFour.visibility = View.VISIBLE
                binding.diceFourDotFive.visibility = View.INVISIBLE
                binding.diceFourDotSix.visibility = View.INVISIBLE
                binding.diceFourDotSeven.visibility = View.INVISIBLE
            }
            2 -> {
                binding.diceFourDotOne.visibility = View.VISIBLE
                binding.diceFourDotTwo.visibility = View.INVISIBLE
                binding.diceFourDotThree.visibility = View.INVISIBLE
                binding.diceFourDotFour.visibility = View.INVISIBLE
                binding.diceFourDotFive.visibility = View.INVISIBLE
                binding.diceFourDotSix.visibility = View.INVISIBLE
                binding.diceFourDotSeven.visibility = View.VISIBLE
            }
            3 -> {
                binding.diceFourDotOne.visibility = View.VISIBLE
                binding.diceFourDotTwo.visibility = View.INVISIBLE
                binding.diceFourDotThree.visibility = View.INVISIBLE
                binding.diceFourDotFour.visibility = View.VISIBLE
                binding.diceFourDotFive.visibility = View.INVISIBLE
                binding.diceFourDotSix.visibility = View.INVISIBLE
                binding.diceFourDotSeven.visibility = View.VISIBLE
            }
            4 -> {
                binding.diceFourDotOne.visibility = View.VISIBLE
                binding.diceFourDotTwo.visibility = View.VISIBLE
                binding.diceFourDotThree.visibility = View.INVISIBLE
                binding.diceFourDotFour.visibility = View.INVISIBLE
                binding.diceFourDotFive.visibility = View.INVISIBLE
                binding.diceFourDotSix.visibility = View.VISIBLE
                binding.diceFourDotSeven.visibility = View.VISIBLE
            }
            5 -> {
                binding.diceFourDotOne.visibility = View.VISIBLE
                binding.diceFourDotTwo.visibility = View.VISIBLE
                binding.diceFourDotThree.visibility = View.INVISIBLE
                binding.diceFourDotFour.visibility = View.VISIBLE
                binding.diceFourDotFive.visibility = View.INVISIBLE
                binding.diceFiveDotSix.visibility = View.VISIBLE
                binding.diceFiveDotSeven.visibility = View.VISIBLE
            }
            6 -> {
                binding.diceFourDotOne.visibility = View.VISIBLE
                binding.diceFourDotTwo.visibility = View.VISIBLE
                binding.diceFourDotThree.visibility = View.VISIBLE
                binding.diceFourDotFour.visibility = View.INVISIBLE
                binding.diceFourDotFive.visibility = View.VISIBLE
                binding.diceFourDotSix.visibility = View.VISIBLE
                binding.diceFourDotSeven.visibility = View.VISIBLE
            }
        }

        when (randomIntDiceSix) {
            1 -> {
                binding.diceSixDotOne.visibility = View.INVISIBLE
                binding.diceSixDotTwo.visibility = View.INVISIBLE
                binding.diceSixDotThree.visibility = View.INVISIBLE
                binding.diceSixDotFour.visibility = View.VISIBLE
                binding.diceSixDotFive.visibility = View.INVISIBLE
                binding.diceSixDotSix.visibility = View.INVISIBLE
                binding.diceSixDotSeven.visibility = View.INVISIBLE
            }
            2 -> {
                binding.diceSixDotOne.visibility = View.VISIBLE
                binding.diceSixDotTwo.visibility = View.INVISIBLE
                binding.diceSixDotThree.visibility = View.INVISIBLE
                binding.diceSixDotFour.visibility = View.INVISIBLE
                binding.diceSixDotFive.visibility = View.INVISIBLE
                binding.diceSixDotSix.visibility = View.INVISIBLE
                binding.diceSixDotSeven.visibility = View.VISIBLE
            }
            3 -> {
                binding.diceSixDotOne.visibility = View.VISIBLE
                binding.diceSixDotTwo.visibility = View.INVISIBLE
                binding.diceSixDotThree.visibility = View.INVISIBLE
                binding.diceSixDotFour.visibility = View.VISIBLE
                binding.diceSixDotFive.visibility = View.INVISIBLE
                binding.diceSixDotSix.visibility = View.INVISIBLE
                binding.diceSixDotSeven.visibility = View.VISIBLE
            }
            4 -> {
                binding.diceSixDotOne.visibility = View.VISIBLE
                binding.diceSixDotTwo.visibility = View.VISIBLE
                binding.diceSixDotThree.visibility = View.INVISIBLE
                binding.diceSixDotFour.visibility = View.INVISIBLE
                binding.diceSixDotFive.visibility = View.INVISIBLE
                binding.diceSixDotSix.visibility = View.VISIBLE
                binding.diceSixDotSeven.visibility = View.VISIBLE
            }
            5 -> {
                binding.diceSixDotOne.visibility = View.VISIBLE
                binding.diceSixDotTwo.visibility = View.VISIBLE
                binding.diceSixDotThree.visibility = View.INVISIBLE
                binding.diceSixDotFour.visibility = View.VISIBLE
                binding.diceSixDotFive.visibility = View.INVISIBLE
                binding.diceSixDotSix.visibility = View.VISIBLE
                binding.diceSixDotSeven.visibility = View.VISIBLE
            }
            6 -> {
                binding.diceSixDotOne.visibility = View.VISIBLE
                binding.diceSixDotTwo.visibility = View.VISIBLE
                binding.diceSixDotThree.visibility = View.VISIBLE
                binding.diceSixDotFour.visibility = View.INVISIBLE
                binding.diceSixDotFive.visibility = View.VISIBLE
                binding.diceSixDotSix.visibility = View.VISIBLE
                binding.diceSixDotSeven.visibility = View.VISIBLE
            }
        }
    }

    private fun rollThreeDices() {
        val score = binding.tvScore
        val randomInt = Random.nextInt(6) + 1
        score.text = randomInt.toString()

        when (score.text.toString()) {
            "1" -> {
                binding.diceOneDotOne.visibility = View.INVISIBLE
                binding.diceOneDotTwo.visibility = View.INVISIBLE
                binding.diceOneDotThree.visibility = View.INVISIBLE
                binding.diceOneDotFour.visibility = View.VISIBLE
                binding.diceOneDotFive.visibility = View.INVISIBLE
                binding.diceOneDotSix.visibility = View.INVISIBLE
                binding.diceOneDotSeven.visibility = View.INVISIBLE
            }
            "2" -> {
                binding.diceOneDotOne.visibility = View.VISIBLE
                binding.diceOneDotTwo.visibility = View.INVISIBLE
                binding.diceOneDotThree.visibility = View.INVISIBLE
                binding.diceOneDotFour.visibility = View.INVISIBLE
                binding.diceOneDotFive.visibility = View.INVISIBLE
                binding.diceOneDotSix.visibility = View.INVISIBLE
                binding.diceOneDotSeven.visibility = View.VISIBLE
            }
            "3" -> {
                binding.diceOneDotOne.visibility = View.VISIBLE
                binding.diceOneDotTwo.visibility = View.INVISIBLE
                binding.diceOneDotThree.visibility = View.INVISIBLE
                binding.diceOneDotFour.visibility = View.VISIBLE
                binding.diceOneDotFive.visibility = View.INVISIBLE
                binding.diceOneDotSix.visibility = View.INVISIBLE
                binding.diceOneDotSeven.visibility = View.VISIBLE
            }
            "4" -> {
                binding.diceOneDotOne.visibility = View.VISIBLE
                binding.diceOneDotTwo.visibility = View.VISIBLE
                binding.diceOneDotThree.visibility = View.INVISIBLE
                binding.diceOneDotFour.visibility = View.INVISIBLE
                binding.diceOneDotFive.visibility = View.INVISIBLE
                binding.diceOneDotSix.visibility = View.VISIBLE
                binding.diceOneDotSeven.visibility = View.VISIBLE
            }
            "5" -> {
                binding.diceOneDotOne.visibility = View.VISIBLE
                binding.diceOneDotTwo.visibility = View.VISIBLE
                binding.diceOneDotThree.visibility = View.INVISIBLE
                binding.diceOneDotFour.visibility = View.VISIBLE
                binding.diceOneDotFive.visibility = View.INVISIBLE
                binding.diceOneDotSix.visibility = View.VISIBLE
                binding.diceOneDotSeven.visibility = View.VISIBLE
            }
            "6" -> {
                binding.diceOneDotOne.visibility = View.VISIBLE
                binding.diceOneDotTwo.visibility = View.VISIBLE
                binding.diceOneDotThree.visibility = View.VISIBLE
                binding.diceOneDotFour.visibility = View.INVISIBLE
                binding.diceOneDotFive.visibility = View.VISIBLE
                binding.diceOneDotSix.visibility = View.VISIBLE
                binding.diceOneDotSeven.visibility = View.VISIBLE
            }
        }
    }
}