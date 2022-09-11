package com.jpdevzone.diceroller.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.play.core.review.ReviewManagerFactory
import com.jpdevzone.diceroller.R
import com.jpdevzone.diceroller.databinding.DiceRollerBinding
import com.jpdevzone.diceroller.util.AdCounter


class DiceRoller : AppCompatActivity() {
    private lateinit var binding: DiceRollerBinding
    private lateinit var viewModel: DiceViewModel

    private var mInterstitialAd: InterstitialAd? = null

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

        inAppReview()
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

    private fun inAppReview() {
        val reviewManager = ReviewManagerFactory.create(this)
        val requestReviewFlow = reviewManager.requestReviewFlow()
        requestReviewFlow.addOnCompleteListener { request ->
            if (request.isSuccessful) {
                val reviewInfo = request.result
                val flow = reviewManager.launchReviewFlow(this, reviewInfo)
                flow.addOnCompleteListener {}
            }
        }
    }

    override fun onPause() {
        super.onPause()
        saveData()
    }
}