package com.example.disneyapp.UI.FavoriteDetail

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.disneyapp.Data.local.Entity.DisneyEntity
import com.example.disneyapp.R
import com.example.disneyapp.UI.Detail.DetailFragmentArgs
import com.example.disneyapp.Util.Extension.Companion.toast
import com.example.disneyapp.databinding.FragmentFavoriteDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteDetailFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteDetailBinding

    private val viewModel by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(FavoriteDetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData(getID())

        getDisneyData()

        binding.deleteBtn.setOnClickListener {
            delete()
        }
    }

    private fun delete(){
        val alertDialog = AlertDialog.Builder(requireContext()).apply {
            this.setMessage("Do you want delete")
            this.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                viewModel.delete(getID())
                requireContext().toast("Delete")
            }).show()
        }
    }

    private fun getDisneyData(){
        viewModel
            .disneyEntity
            .observe(viewLifecycleOwner, {
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

    private fun createDisneyCharacter(disneyEntity: DisneyEntity) {
        Glide.with(requireContext())
            .load(disneyEntity.imageUrl)
            .error(R.drawable.disney_img)
            .into(binding.imageView2)

        binding.textName.setText(disneyEntity.name)
    }

    private fun getID(): Int{
        val bundle = arguments
        val args = DetailFragmentArgs.fromBundle(bundle!!)
        return args.id
    }
}