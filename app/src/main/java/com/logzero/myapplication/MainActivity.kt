package com.logzero.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        val number = model.checkRandomNumber()
        if (number != null) {
            number.observe(this,
                Observer { s -> text.setText(s) })
        }


        button.setOnClickListener(View.OnClickListener { model.generateRandomNumber() })
    }
}


