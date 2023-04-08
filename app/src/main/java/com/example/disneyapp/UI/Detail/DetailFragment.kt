package com.example.disneyapp.UI.Detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.disneyapp.Data.remote.Model.DisneyData
import com.example.disneyapp.R
import com.example.disneyapp.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    private val viewModel by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(DetailViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDisneyData(getID())
        getDisneyData()
    }

    private fun getDisneyData(){
        viewModel.disneyData.observe(viewLifecycleOwner, {
            item->
            if (item != null){
                binding.progressBar.visibility = View.GONE
                binding.detailFragment.visibility = View.VISIBLE
                createDisneyCharacter(item)
            }else{
                binding.progressBar.visibility = View.VISIBLE
                binding.detailFragment.visibility = View.GONE
            }
        })
    }

    private fun createDisneyCharacter(disneyData: DisneyData) {

        Glide.with(requireContext())
            .load(disneyData.imageUrl)
            .error(R.drawable.disney_img)
            .into(binding.imageView2)

        binding.textView2.setText(disneyData.name)
    }

    private fun getID(): Int{
        val bundle = arguments
        val args = DetailFragmentArgs.fromBundle(bundle!!)
        return args.id
    }
}