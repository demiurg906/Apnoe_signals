package com.medical.signals.signalsapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_parameters.*

class ParametersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_parameters)
//        setSupportActionBar(toolbar)

        toGraphButton.setOnClickListener { view ->
            val intent = Intent(this, GraphsActivity::class.java)
            startActivity(intent)
        }
    }

}
