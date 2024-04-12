package com.example.a160421138_timothytheo_hobbyapp.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a160421138_timothytheo_hobbyapp.R
import com.example.a160421138_timothytheo_hobbyapp.databinding.FragmentBeritaDetailItemBinding
import com.example.a160421138_timothytheo_hobbyapp.databinding.FragmentProfileBinding
import com.example.a160421138_timothytheo_hobbyapp.viewmodel.DetailViewModel
import com.example.a160421138_timothytheo_hobbyapp.viewmodel.ListViewModel
import com.example.a160421138_timothytheo_hobbyapp.viewmodel.LoginViewModel
import com.example.a160421138_timothytheo_hobbyapp.viewmodel.UbahProfileViewModel

class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: UbahProfileViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedFile = "com.example.a160421138_timothytheo_hobbyapp"
        val shared: SharedPreferences = requireContext().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
        val username = shared.getString(LoginActivity.USERNAME, "")
        val nama_depan = shared.getString(LoginActivity.NAMA_DEPAN, "")
        val nama_belakang = shared.getString(LoginActivity.NAMA_BELAKANG, "")
        val email = shared.getString(LoginActivity.EMAIL, "")
        val id = shared.getString(LoginActivity.ID, "")

        viewModel = ViewModelProvider(this).get(UbahProfileViewModel::class.java)

        binding.txtNamaDepan.setText(nama_depan)
        binding.txtNamaBelakang.setText(nama_belakang)
        binding.txtUsernameProfile.setText(username)
        binding.txtEmailProfile.setText(email)

        binding.btnSimpanProfile.setOnClickListener {
            if(binding.txtPassword.text.toString() != binding.txtKonfirmasiPassword.text.toString()){
                Toast.makeText(this.context, "Konfirmasi Password Salah", Toast.LENGTH_SHORT).show()
            }else{
                viewModel.ubah(id.toString(), binding.txtNamaDepan.text.toString(), binding.txtNamaBelakang.text.toString(), binding.txtPassword.text.toString())
            }
//            else{
//                if (binding.txtPassword.text.toString() == ""){
//                    Toast.makeText(this.context, "Password tidak boleh kosong", Toast.LENGTH_SHORT).show()
//                }else{
//                    viewModel.ubah(id.toString(), binding.txtNamaDepan.text.toString(), binding.txtNamaBelakang.text.toString(), binding.txtPassword.text.toString())
//                    observeViewModel()
//                }
//            }
        }


        binding.btnSignout.setOnClickListener {
            val sharedFile = "com.example.a160421138_timothytheo_hobbyapp"
            val shared: SharedPreferences = requireActivity().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
            var editor:SharedPreferences.Editor = shared.edit()
            editor.putString(LoginActivity.ID, "")
            editor.putString(LoginActivity.USERNAME, "")
            editor.putString(LoginActivity.NAMA_DEPAN, "")
            editor.putString(LoginActivity.NAMA_BELAKANG, "")
            editor.putString(LoginActivity.EMAIL, "")
            editor.apply()

            val intent = Intent(this.context, LoginActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
        observeViewModel()
    }

//    fun observeViewModel(){
//        viewModel.userLD.observe(this.requireActivity(), Observer {
//            if (it.getString("result") == "error"){
//                Toast.makeText(this.context, it.getString("message"), Toast.LENGTH_SHORT).show()
//            }else{
//                var sharedFile = "com.example.a160421138_timothytheo_hobbyapp"
//                var shared: SharedPreferences = requireContext().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
//                var editor:SharedPreferences.Editor = shared.edit()
//                editor.putString(LoginActivity.NAMA_DEPAN, binding.txtNamaDepan.text.toString())
//                editor.putString(LoginActivity.NAMA_BELAKANG, binding.txtNamaBelakang.text.toString())
//                editor.apply()
//                Toast.makeText(this.context, it.getString("message"), Toast.LENGTH_SHORT).show()
//            }
//        })
//    }

    fun observeViewModel() {
        viewModel.userLD.observe(requireActivity(), Observer {
            if (it.getString("result") == "error") {
                Toast.makeText(requireContext(), it.getString("message"), Toast.LENGTH_SHORT).show()
            } else {
                val sharedFile = "com.example.a160421138_timothytheo_hobbyapp"
                val shared: SharedPreferences = requireContext().getSharedPreferences(sharedFile, Context.MODE_PRIVATE)
                val editor: SharedPreferences.Editor = shared.edit()
                editor.putString(LoginActivity.NAMA_DEPAN, binding.txtNamaDepan.text.toString())
                editor.putString(LoginActivity.NAMA_BELAKANG, binding.txtNamaBelakang.text.toString())
                editor.apply()
                Toast.makeText(this.context, it.getString("message"), Toast.LENGTH_SHORT).show()

                binding.txtPassword.setText("")
                binding.txtKonfirmasiPassword.setText("")
            }
        })
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}