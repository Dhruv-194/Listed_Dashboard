package com.dhruv194.listed_dashboard.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.dhruv194.listed_dashboard.databinding.FragmentTopLinksBinding
import com.dhruv194.listed_dashboard.repository.Repository
import com.dhruv194.listed_dashboard.repository.api.RetrofitInstance
import com.dhruv194.listed_dashboard.ui.MainViewModel
import com.dhruv194.listed_dashboard.ui.MainViewModelFactory
import com.dhruv194.listed_dashboard.ui.adapters.TopLinksRvAdapter
import retrofit2.HttpException
import java.io.IOException


class TopLinksFragment : Fragment() {

    private lateinit var binding : FragmentTopLinksBinding
    private lateinit var topLinksRvAdapter: TopLinksRvAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =FragmentTopLinksBinding.inflate(inflater, container,false)

        topLinksRvAdapter = TopLinksRvAdapter(requireContext())

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getTopLink()
        viewModel.topLinkResponse.observe(viewLifecycleOwner){ topLinks->
            setupRecyclerView()
            topLinksRvAdapter.topLinks = topLinks

        }

        /*lifecycleScope.launchWhenCreated {
            binding.toplinksRvPb.isVisible = true
            val response = try {
                RetrofitInstance.api.getDashboard()
            }catch (e : IOException){
                binding.toplinksRvPb.isVisible = false
                Log.d("Error", "IO EXCEPTION"+e)
                return@launchWhenCreated
            }catch (e: HttpException){
                binding.toplinksRvPb.isVisible = false
                Log.d("Error", "Http Exception"+ e)
                return@launchWhenCreated
            }


            if(response.isSuccessful && response.body()!=null){
              topLinksRvAdapter.topLinks = response.body()!!.data.top_links
                setupRecyclerView()
                Log.d("Success", response.body()!!.data.top_links.toString())

            }else {
                Log.d("Error", "Response not successful")
            }

            binding.toplinksRvPb.isVisible = false
        }*/
    }

    private fun setupRecyclerView() = binding.toplinksRv.apply {
        adapter = topLinksRvAdapter
        layoutManager = LinearLayoutManager(context)
    }
}