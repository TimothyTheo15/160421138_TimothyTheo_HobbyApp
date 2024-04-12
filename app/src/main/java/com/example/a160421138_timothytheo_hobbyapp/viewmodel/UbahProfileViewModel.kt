package com.example.a160421138_timothytheo_hobbyapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160421138_timothytheo_hobbyapp.model.User
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class UbahProfileViewModel(application: Application): AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    var userLD = MutableLiveData<JSONObject>()

    fun ubah(id:String, namaDepan:String, namaBelakang:String, password:String) {

        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ws_timi/update_profile.php"
        Log.d("arsss", namaDepan.toString())
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            {
                var obj = JSONObject(it)
                userLD.value = obj

            },{
                Log.d("arianag", it.toString())
            }
        )
        {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["nama_depan"] = namaDepan.toString()
                params["nama_belakang"] = namaBelakang.toString()
                params["password"] = password.toString()
                params["id"] = id.toString()
                return params
            }
        }
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}