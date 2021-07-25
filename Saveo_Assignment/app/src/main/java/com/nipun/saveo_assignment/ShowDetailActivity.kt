package com.nipun.saveo_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.bumptech.glide.Glide
import com.nipun.nobroker.ApiCall.Network
import com.nipun.saveo_assignment.model.db.MyDataEntity
import com.nipun.saveo_assignment.model.network.ApiClient
import com.nipun.saveo_assignment.model.response.ResponseModelItem
import kotlinx.android.synthetic.main.activity_show_detail.*

class ShowDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_detail)
        setData()
    }

    fun setData() {
        val name = intent.getStringExtra("name")
        val photo = intent.getStringExtra("image")
        val hour = intent.getStringExtra("hour")
        val date = intent.getStringExtra("date")
        val review = intent.getStringExtra("review")
        val summery = intent.getStringExtra("summary")
        Glide.with(ivAvatar).load(photo).into(ivAvatar)
        movie_name.text = name.toString()
        movie_hour.text = hour.toString()
        movie_year.text = date.toString()
        movie_rating.text = review.toString()
        movie_description.text = summery.toString()


    }
}