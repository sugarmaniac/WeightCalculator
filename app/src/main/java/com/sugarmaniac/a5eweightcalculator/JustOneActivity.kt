package com.sugarmaniac.a5eweightcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sugarmaniac.a5eweightcalculator.ui.characterselect.CharacterSelect

class JustOneActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_just_one)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CharacterSelect.newInstance())
                .commitNow()
        }
    }
}