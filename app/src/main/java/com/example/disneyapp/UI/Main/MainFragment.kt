package com.example.disneyapp.UI.Main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.disneyapp.UI.Adapter.FragmentAdapter
import com.example.disneyapp.Util.OnItemClick
import com.example.disneyapp.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private lateinit var binding : FragmentMainBinding

    private lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, defaultViewModelProviderFactory).get(MainViewModel::class.java)
        getCharacter()

        binding.floatingActionButton.setOnClickListener {
            val directon = MainFragmentDirections.actionMainFragment2ToFavoriteFragment()
            Navigation.findNavController(it).navigate(directon)
        }
    }

    private fun getCharacter(){
        viewModel.disneyData.observe(viewLifecycleOwner, {
            item->
            if (item.size > 0){
                binding.progressBar.visibility = View.GONE
                binding.recyclerView.visibility = View.VISIBLE

                binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

                binding.recyclerView.adapter = FragmentAdapter(item, null,
                object : OnItemClick{
                    override fun clickListener(id: Int) {
                        val direction = MainFragmentDirections.actionMainFragment2ToDetailFragment(id)
                        Navigation.findNavController(requireView()).navigate(direction)
                    }
                })
            }else{
                binding.progressBar.visibility = View.VISIBLE
                binding.recyclerView.visibility = View.GONE
            }
        })
    }
}