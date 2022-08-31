package com.example.picker

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import com.example.picker.adapters.CountrySpinnerAdapter
import com.example.picker.databinding.ActivityMainBinding
import com.kursat.countrycodepicker.repostories.CountryRepo


class MainActivity : AppCompatActivity() {
    private lateinit var bind : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val countries = CountryRepo().allCountries()

        val adapter = CountrySpinnerAdapter(countries,this)
        bind.spinner.adapter = adapter

        bind.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                val uri = "@drawable/${countries[p2].flagImg}"

                val imageResource: Int = resources.getIdentifier(uri, null, getPackageName())
                val res: Drawable = resources.getDrawable(imageResource, theme)
                bind.ivFlag.setImageDrawable(res)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
    }
}