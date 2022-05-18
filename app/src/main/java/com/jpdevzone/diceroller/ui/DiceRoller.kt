package com.jpdevzone.diceroller.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.jpdevzone.diceroller.R
import com.jpdevzone.diceroller.databinding.DiceRollerBinding
import com.jpdevzone.diceroller.util.AdCounter
import es.dmoral.toasty.Toasty


class DiceRoller : AppCompatActivity() {
    private lateinit var binding: DiceRollerBinding
    private lateinit var viewModel: DiceViewModel

    private var mInterstitialAd: InterstitialAd? = null
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.dice_roller)

        viewModel = ViewModelProvider(this, DiceViewModelFactory(this.application))[DiceViewModel::class.java]
        binding.vm = viewModel
        binding.lifecycleOwner = this

        viewModel.adCounter.observe(this) {
            if (it % 5 == 0) {
                showAd()
            }
        }

        MobileAds.initialize(this)
        loadAd()
    }

    private fun showAd() {
        if (mInterstitialAd != null) {
            mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdDismissedFullScreenContent() {
                    Log.d("AdMob", "Ad was dismissed.")
                    mInterstitialAd = null
                    loadAd()
                }

                override fun onAdFailedToShowFullScreenContent(adError: AdError) {
                    Log.d("AdMob", "Ad failed to show.")
                    mInterstitialAd = null
                }

                override fun onAdShowedFullScreenContent() {
                    Log.d("AdMob", "Ad showed fullscreen content.")
                    mInterstitialAd = null
                }
            }
            mInterstitialAd?.show(this)
        }
    }

    private fun loadAd() {
        val adRequest = AdRequest.Builder().build()

        InterstitialAd.load(this,"ca-app-pub-7588987461083278/5376328415", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("AdMob", adError.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d("AdMob", "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })
    }

    private fun saveData() {
        AdCounter.setAdCounter(this, viewModel.adCounter.value!!)
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
}