package com.nipun.saveo_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_show_detail.*

class ShowDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        setData()
       /* arrow.setOnClickListener {
            finish()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }*/
        toolbar_top.setNavigationOnClickListener { onBackPressed() }
    }

    /**
     * This function i used to set the data in a activity which is getting from MainActivity via intent
     */
    fun setData() {
        val name = intent.getStringExtra("name")
        val photo = intent.getStringExtra("image")
        val hour = intent.getStringExtra("hour")
        val date = intent.getStringExtra("date")
        val review = intent.getStringExtra("review")
        val summary = intent.getStringExtra("summary")
        Glide.with(ivAvatar).load(photo).into(ivAvatar)
        movie_name.text = name.toString()
        movie_hour.text = hour.toString()
        movie_year.text = date.toString()
        movie_rating.text = review.toString()
        movie_description.text = summary.toString()
    }

}