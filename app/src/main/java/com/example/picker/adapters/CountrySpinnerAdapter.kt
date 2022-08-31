package com.example.picker.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.kursat.countrycodepicker.models.Country
import android.graphics.drawable.Drawable
import android.util.Log
import com.example.picker.databinding.ItemRowBinding


class CountrySpinnerAdapter (private val countries:ArrayList<Country>, val context: Context) : BaseAdapter(){
    override fun getCount(): Int {
        return countries.size
    }

    override fun getItem(p0: Int): Any {
        return countries[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val bind = ItemRowBinding.inflate(LayoutInflater.from(context),p2,false)
        val item = countries.get(p0)
        bind.tvCountryName.text = item.name
        bind.tvNameCode.text = "(${item.nameCode})"
        bind.tvPhoneCode.text = "+${item.phoneCode}"

        val uri = "@drawable/${item.flagImg}" // where myresource (without the extension) is the file
        Log.d("ERROR URI : ", uri)
        val imageResource: Int = context.resources.getIdentifier(uri, null, context.getPackageName())
        val res: Drawable = context.resources.getDrawable(imageResource, context.theme)
        bind.ivFlag.setImageDrawable(res)

        return bind.root
    }
}
