package com.nipun.saveo_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_show_detail.*

class showDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        setData()
    }

    private fun setData() {
        val photo = intent.getStringExtra("image")
        Glide.with(ivDetails).load(photo).into(ivDetails)

    }
}