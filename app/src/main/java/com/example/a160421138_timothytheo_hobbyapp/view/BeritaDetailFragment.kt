package com.example.a160421138_timothytheo_hobbyapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a160421138_timothytheo_hobbyapp.R
import com.example.a160421138_timothytheo_hobbyapp.databinding.FragmentBeritaDetailItemBinding
import com.example.a160421138_timothytheo_hobbyapp.databinding.FragmentHomeBinding
import com.example.a160421138_timothytheo_hobbyapp.model.Article
import com.example.a160421138_timothytheo_hobbyapp.util.loadImage
import com.example.a160421138_timothytheo_hobbyapp.viewmodel.DetailViewModel
import com.example.a160421138_timothytheo_hobbyapp.viewmodel.ListViewModel

class BeritaDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentBeritaDetailItemBinding
    private var id : Int = 0
    private var index : Int = 0
    private lateinit var arrayArticle : List<Article>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBeritaDetailItemBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        if(arguments != null) {
            id = BeritaDetailFragmentArgs.fromBundle(requireArguments()).beritaId
            viewModel.refresh(id)
        }
        binding.btnBacaBeritaPrevious.isEnabled = false

        binding.btnBacaBeritaNext.setOnClickListener {
            index = index + 1
            binding.txtSubtitle.text = arrayArticle[index].subtitle.toString()
            binding.txtPragraph.text = arrayArticle[index].paragraph.toString()
            binding.btnBacaBeritaPrevious.isEnabled = true

            if (index == arrayArticle.size - 1){
                binding.btnBacaBeritaNext.isEnabled = false
            }
        }

        binding.btnBacaBeritaPrevious.setOnClickListener {
            index = index - 1
            binding.txtSubtitle.text = arrayArticle[index].subtitle.toString()
            binding.txtPragraph.text = arrayArticle[index].paragraph.toString()
            binding.btnBacaBeritaNext.isEnabled = true
            if (index == 0){
                binding.btnBacaBeritaPrevious.isEnabled = false
            }
        }

        observeViewModel(view)
    }

    fun observeViewModel(view: View){
        viewModel.detailBeritaLD.observe(viewLifecycleOwner, Observer {
            binding.imgBeritaDetail.loadImage(it.photo_url, binding.progressBarImageBeritaDetail)
            binding.txtJudulBerita.text = it.title.toString()
            binding.txtUsernamePembuat.text = it.username.toString()
            Log.d("article", it.articles.toString())
            binding.txtSubtitle.text = it.articles?.get(0)?.subtitle.toString()
            binding.txtPragraph.text = it.articles?.get(0)?.paragraph.toString()
            arrayArticle = it.articles!!
        })
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            BeritaDetailFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}