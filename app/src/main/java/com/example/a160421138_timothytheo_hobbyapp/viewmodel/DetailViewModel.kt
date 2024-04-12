package com.example.a160421138_timothytheo_hobbyapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160421138_timothytheo_hobbyapp.model.Berita
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DetailViewModel(application: Application): AndroidViewModel(application)  {
    val beritaLD = MutableLiveData<Berita>()
    val beritaLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null


    fun refresh() {
        loadingLD.value = true
        beritaLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ws_timi/detail_berita_all.php"

        val stringRequest = StringRequest(
            Request.Method.POST, url,
            {
                val sType = object: TypeToken<List<Berita>>(){ }.type
                val result = Gson().fromJson<List<Berita>>(it, sType)
                beritaLD.value = result as Berita
                Log.d("showvolley", result.toString())
            },{
                Log.d("showvolleyg", it.toString())
            }
        )

        stringRequest.tag = TAG
        queue?.add(stringRequest)

        beritaLoadErrorLD.value = false
        loadingLD.value = false
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}