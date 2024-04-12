package com.example.a160421138_timothytheo_hobbyapp.viewmodel

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.a160421138_timothytheo_hobbyapp.model.Berita
import com.example.a160421138_timothytheo_hobbyapp.model.User
import com.example.a160421138_timothytheo_hobbyapp.view.LoginActivity
import com.example.a160421138_timothytheo_hobbyapp.view.MainActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class LoginViewModel(application: Application): AndroidViewModel(application) {
    val TAG = "volleyTag"
    private var queue: RequestQueue? = null
    var userLD = MutableLiveData<User?>()

    fun login(username:String, password:String) {
        queue = Volley.newRequestQueue(getApplication())
        val url = "http://10.0.2.2/ws_timi/login.php"
        Log.d("ariana2", username.toString())
        val stringRequest = object : StringRequest(
            Request.Method.POST, url,
            {
                val sType = object:TypeToken<User>(){ }.type
                Log.d("arianait", it.toString())
                if(it.toString() != "null"){
                    Log.d("arianaaaa", "masuk")
                    val result = Gson().fromJson<User>(it, sType)
                    Log.d("arianas", result.toString())
                    userLD.value = result as User
                    Log.d("ariana", result.toString())
                }else{
                    Log.d("arianaaaag", "masuk")
                    userLD.value = null
                }

            },{
                Log.d("arianag", it.toString())
            }
        )
        {
            override fun getParams(): MutableMap<String, String> {
                val params = HashMap<String, String>()
                params["username"] = username.toString()
                params["password"] = password.toString()
                return params
            }
        }
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}