package com.example.androidlab2.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.androidlab2.adapter.CatAdapter
import com.example.androidlab2.databinding.FragmentCatListBinding
import com.example.androidlab2.model.Cat
import com.example.androidlab2.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNREACHABLE_CODE")
class CatListFragment : Fragment() {
    companion object {
        fun newInstance() = CatListFragment()
    }

    private var _binding: FragmentCatListBinding? = null
    private val binding get() = _binding!!
    private lateinit var searchView: SearchView

    private val adapter by lazy { CatAdapter() }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatListBinding.inflate(inflater, container, false)
        return binding.root
        searchView = binding.search

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText.isNullOrBlank()) {
                    ApiClient.instance.fetchCats()
                } else {
                    fetchCatsByName(newText)

                }
                return true
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        ApiClient.instance.fetchCats().enqueue(object : Callback<List<Cat>> {
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                val data = response.body()
                data?.let {
                    adapter.submitList(it)
                }

            }

            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
            }
        })

    }


    private fun setupUI() {
        with(binding){
            catList.adapter = this@CatListFragment.adapter
        }
    }
    private fun fetchCatsByName(query: String) {
        ApiClient.instance.catByName(query).enqueue(object : Callback<List<Cat>> {
            override fun onResponse(call: Call<List<Cat>>, response: Response<List<Cat>>) {
                val data = response.body()
                data?.let {
                    adapter.submitList(it)
                }

            }

            override fun onFailure(call: Call<List<Cat>>, t: Throwable) {
            }
        })
    }






}
