package com.esgi.aqi.ui.screens.main.tabs.travel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esgi.aqi.R
import com.esgi.aqi.data.network.model.ranking.RankingsCountry
import java.lang.Exception

class CountriesAdapter(private val dataSet: List<RankingsCountry>) : RecyclerView.Adapter<CountriesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberView: TextView = view.findViewById(R.id.number)
        val cityView: TextView = view.findViewById(R.id.city)
        val countryView: TextView = view.findViewById(R.id.country)
        val score: TextView = view.findViewById(R.id.score)
        val img: ImageView = view.findViewById(R.id.img)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.country_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val country = dataSet[position]
        val context = viewHolder.itemView.context

        viewHolder.numberView.text = position.toString()
        viewHolder.cityView.text = country.city

        try {
            viewHolder.countryView.text = context.getString(
                context.resources.getIdentifier(
                    "country_${country.countryCode}_name",
                    "string",
                    context.packageName
                )
            )
        } catch (err: Exception) {
            print(country.countryCode)
        }

        try {
            viewHolder.img.setImageResource(
                context.resources.getIdentifier(
                    "ic_flag_country_${country.countryCode.toLowerCase()}",
                    "drawable",
                    context.packageName
                )
            )
        } catch (err: Exception) {
            print(country.countryCode)
        }

        viewHolder.score.text = country.aqi.toString()

    }

    override fun getItemCount() = dataSet.size

}