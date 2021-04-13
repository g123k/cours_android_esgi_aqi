package com.esgi.aqi.ui.screens.main.tabs.travel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.esgi.aqi.R
import com.esgi.aqi.data.network.AQIAPI
import kotlinx.coroutines.*

class TravelTab : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_travel, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handler = CoroutineExceptionHandler { _, exception ->
            // TODO Une erreur est survenue
            exception.printStackTrace()
        }

        GlobalScope.launch(handler) {
            val countries = AQIAPI.getInstance().listCountries().await()

            // TODO Afficher le résultat
        }
    }
}