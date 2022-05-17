package com.jpdevzone.diceroller.ui

import android.content.Context
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.jpdevzone.diceroller.util.Constants
import com.jpdevzone.diceroller.R
import com.jpdevzone.diceroller.databinding.DiceRollerBinding
import es.dmoral.toasty.Toasty


class DiceRoller : AppCompatActivity() {
    private lateinit var binding: DiceRollerBinding
    private lateinit var viewModel: DiceViewModel



    private lateinit var muteButton: ImageView
    private lateinit var themePicker: ImageView
    private var clickCounter: Int = 1


    private lateinit var soundPool: SoundPool
    private var rollSound: Int? = null

    private var mInterstitialAd: InterstitialAd? = null
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.dice_roller)

        viewModel = ViewModelProvider(this, DiceViewModelFactory())[DiceViewModel::class.java]
        binding.vm = viewModel
        binding.lifecycleOwner = this

        //Load shared prefs
        loadData()

        //Controls
        muteButton = binding.btnMute
        themePicker = binding.btnTheme

        //Dices


        //Roll button
//        rollButton = binding.btnRoll

        //Click mute button
        muteUnmuteSound()

        //Click minus button
//        minusButton.setOnClickListener {
//            if (diceSum.text != "0") {
//                diceSum.text = "0"
//            }
////            decreaseDices()
//            showAd()
//        }

        //Click plus button
//        plusButton.setOnClickListener {
//            if (diceSum.text != "0") {
//                diceSum.text = "0"
//            }
////            increaseDices()
//            showAd()
//        }

        //Select theme
        themePicker.setOnClickListener {
//            val intent = Intent(this, DiceRollerDashDark::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
//            overridePendingTransition(0, 0)
//            startActivity(intent)
//            finish()
        }

        //Roll dices on click
//        rollButton.setOnClickListener {
//            rollDices()
//        }

        MobileAds.initialize(this) {}
        createPersonalizedAdd()
    }

    @Suppress("DEPRECATION")
    private fun muteUnmuteSound() {
        soundPool = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build()
            SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build()
        } else {
            SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        }

        rollSound = soundPool.load(this, R.raw.roll_sound, 1)
        Constants.isClicked = false

        muteButton.setOnClickListener {
            when (Constants.isClicked) {
                false -> {
                    muteButton.setImageResource(R.drawable.bg_btn_mute)
                    Constants.isClicked = true
                    rollSound = null
                }
                true -> {
                    muteButton.setImageResource(R.drawable.bg_btn_unmute)
                    Constants.isClicked = false
                    rollSound = soundPool.load(this, R.raw.roll_sound, 1)
                }
            }
        }
    }

    private fun showAd() {
        Constants.adCounter++
        when (Constants.adCounter % 5 == 0) {
            true -> {
                if (mInterstitialAd != null) {
                    mInterstitialAd?.show(this)
                    createPersonalizedAdd()
                } else {
                    createPersonalizedAdd()
                }
            }
        }
    }

    private fun createPersonalizedAdd() {
        val adRequest = AdRequest.Builder().build()
        createInterstitialAdd(adRequest)
    }

    private fun createInterstitialAdd(adRequest: AdRequest) {
        InterstitialAd.load(this,"ca-app-pub-7588987461083278/9903474518", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                mInterstitialAd = interstitialAd
            }
        })
    }



    private fun rollDices() {
        rollSound?.let { soundPool.play(it, 1f, 1f, 0, 0, 1f) }
    }

    private fun animate(view: ImageView) {
        val anim = RotateAnimation(
            0f, 359f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)
        anim.duration = 150
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
//                rollButton.isClickable = false
            }

            override fun onAnimationEnd(animation: Animation) {
//                rollButton.isClickable = true
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
        view.animation = anim
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt(Constants.AD_COUNTER, Constants.adCounter)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences(Constants.SHARED_PREFERENCES, Context.MODE_PRIVATE)
        Constants.adCounter = sharedPreferences.getInt(Constants.AD_COUNTER, 0)
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    override fun onBackPressed() {
        counter++
        if (counter==1) {
            saveData()
            Toasty.custom(this, R.string.toast, R.drawable.ic_exit, R.color.toast,
                Toast.LENGTH_LONG,true, true).show()
        } else {
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool.release()
    }
}