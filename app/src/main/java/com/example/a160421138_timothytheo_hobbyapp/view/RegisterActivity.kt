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
import com.example.a160421138_timothytheo_hobbyapp.databinding.ActivityRegisterBinding
import com.example.a160421138_timothytheo_hobbyapp.viewmodel.LoginViewModel
import com.example.a160421138_timothytheo_hobbyapp.viewmodel.RegisterViewModel

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var viewModel: RegisterViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)

        binding.btnLoginRegister.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnSimpanProfileRegister.setOnClickListener {
            if(binding.txtPassword.text.toString() != ""){
                if(binding.txtPassword.text.toString() == binding.txtKonfirmasiPassword.text.toString()){
                    viewModel.register(binding.txtNamaDepan.text.toString(), binding.txtNamaBelakang.text.toString(), binding.txtEmailRegister.text.toString(),binding.txtUsernameRegister.text.toString(),binding.txtPassword.text.toString())
                }else{
                    Toast.makeText(this, "Konfirmasi Password Salah!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Password Tidak Boleh Kosong!", Toast.LENGTH_SHORT).show()
            }

        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.userLD.observe(this, Observer {
            if (it.getString("result") == "error") {
                Toast.makeText(this, it.getString("message"), Toast.LENGTH_SHORT).show()

                binding.txtPassword.setText("")
                binding.txtKonfirmasiPassword.setText("")
            } else {
                Toast.makeText(this, it.getString("message"), Toast.LENGTH_SHORT).show()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        })
    }
}