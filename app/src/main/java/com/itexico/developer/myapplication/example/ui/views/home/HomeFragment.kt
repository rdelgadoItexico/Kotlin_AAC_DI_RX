package com.itexico.developer.myapplication.example.ui.views.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itexico.developer.myapplication.R
import com.itexico.developer.myapplication.common.ui.views.FragmentBase
import com.itexico.developer.myapplication.databinding.FragmentHomeBinding
import com.itexico.developer.myapplication.example.ui.adapters.UserAdapter
import com.itexico.developer.myapplication.example.ui.viewmodels.HomeViewModel
import javax.inject.Inject

class HomeFragment : FragmentBase() {

    @Inject
    lateinit var mFactory : ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding : FragmentHomeBinding = DataBindingUtil.inflate(inflater,
                R.layout.fragment_home,
                container,
                false)

        val vm : HomeViewModel = ViewModelProviders
                .of(this, mFactory)
                .get(HomeViewModel::class.java)

        val adapter = UserAdapter(ArrayList())
        val layoutManager = LinearLayoutManager(activity)

        binding.allUsersRecyclerView.layoutManager = layoutManager
        binding.allUsersRecyclerView.adapter = adapter

        //vm.getUsersLiveData().observe(this, userAdapter::setUsers)

        vm.getUsersLiveData().observe(this, Observer { adapter.setUsers(it!!) } )

        binding.context = vm

        return binding.root
    }
}
