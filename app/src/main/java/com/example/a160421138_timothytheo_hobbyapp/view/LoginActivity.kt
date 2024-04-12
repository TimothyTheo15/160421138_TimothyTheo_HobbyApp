package com.example.a160421138_timothytheo_hobbyapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160421138_timothytheo_hobbyapp.R
import com.example.a160421138_timothytheo_hobbyapp.databinding.ActivityLoginBinding
import com.example.a160421138_timothytheo_hobbyapp.databinding.FragmentHomeBinding
import com.example.a160421138_timothytheo_hobbyapp.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    companion object{
        val USERNAME = "USERNAME"
        val ID = "ID"
        val NAMA_DEPAN = "NAMA_DEPAN"
        val NAMA_BELAKANG = "NAMA_BELAKANG"
    }
    private lateinit var dataBinding:ActivityLoginBinding
    private lateinit var viewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        var sharedFile = "com.example.a160421138_timothytheo_hobbyapp"
        var shared: SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        var username = shared.getString(LoginActivity.USERNAME, "")
        if(username!="")
        {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            this.finish()
        }

        dataBinding.btnRegister.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        dataBinding.btnLogin.setOnClickListener {
            Log.d("ariana3", dataBinding.txtUsername.text.toString())
            viewModel.login(dataBinding.txtUsername.text.toString(), dataBinding.txtPassword.text.toString())
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.userLD.observe(this, Observer {
            if (it == null){
                Toast.makeText(this, "Username atau Password Salah!", Toast.LENGTH_SHORT).show()
            }else{
                var sharedFile = "com.example.a160421138_timothytheo_hobbyapp"
                var shared: SharedPreferences = getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
                var editor:SharedPreferences.Editor = shared.edit()
                editor.putString(ID, it.id.toString())
                editor.putString(USERNAME, it.username)
                editor.putString(NAMA_DEPAN, it.nama_depan)
                editor.putString(NAMA_BELAKANG, it.nama_belakang)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                Toast.makeText(this, "Berhasil Login", Toast.LENGTH_SHORT).show()
                startActivity(intent)
                this.finish()
            }

        })
    }
}