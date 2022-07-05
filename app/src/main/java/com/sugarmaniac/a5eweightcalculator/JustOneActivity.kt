package com.sugarmaniac.a5eweightcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.sugarmaniac.a5eweightcalculator.ui.characterselect.CharacterSelect

class JustOneActivity : AppCompatActivity() {

    private val viewModel : GeneralViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_just_one)

        initAds()
    }

    private fun initAds() {
        MobileAds.initialize(applicationContext)

        val adView = AdView(this)
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-6071325621384231/3940168212"
    }

}