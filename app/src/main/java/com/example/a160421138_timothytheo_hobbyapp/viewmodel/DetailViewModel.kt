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
    val detailBeritaLD = MutableLiveData<Berita>()
    val beritaLoadErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    val TAG = "volleyTag"
    private var queue: RequestQueue? = null


    fun refresh(id:Int) {
        loadingLD.value = true
        beritaLoadErrorLD.value = false

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ws_timi/detail_berita_all.php"

        val stringRequest = object: StringRequest(
            Request.Method.POST, url,
            {
                val sType = object: TypeToken<Berita>(){ }.type
                val result = Gson().fromJson<Berita>(it, sType)
                detailBeritaLD.value = result as Berita
                Log.d("showvolleydetail", result.toString())
            },{
                Log.d("showvolleyg", it.toString())
            }
        ){
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["id"] = id.toString()
                return params
            }
        }
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}