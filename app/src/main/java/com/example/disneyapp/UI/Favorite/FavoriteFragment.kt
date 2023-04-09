package com.example.disneyapp.UI.Favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.disneyapp.UI.Adapter.FragmentAdapter
import com.example.disneyapp.Util.OnItemClick
import com.example.disneyapp.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    private lateinit var viewModel: FavoriteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this, defaultViewModelProviderFactory).get(FavoriteViewModel::class.java)

        viewModel.getDataList(requireContext())

        getDataList()
    }

    private fun getDataList(){
        viewModel.dataList.observe(viewLifecycleOwner, {
            item->
            if (item.size > 0){
                binding.progressBar2.visibility = View.GONE
                binding.recyclerView2.visibility = View.VISIBLE
                binding.recyclerView2.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerView2.adapter = FragmentAdapter(null, item,
                    object : OnItemClick{
                        override fun clickListener(id: Int) {
                            val direction = FavoriteFragmentDirections.actionFavoriteFragmentToFavoriteDetailFragment(id)
                            Navigation.findNavController(requireView()).navigate(direction)
                        }
                    })
            }else{
                binding.progressBar2.visibility = View.VISIBLE
                binding.recyclerView2.visibility = View.GONE
            }
        })
    }
}