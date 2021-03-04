package br.com.isomano.mycalendar.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.isomano.mycalendar.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyCalendarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mycalendar)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}