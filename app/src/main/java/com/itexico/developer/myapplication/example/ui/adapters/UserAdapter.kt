package com.itexico.developer.myapplication.example.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.itexico.developer.myapplication.databinding.UserItemBinding
import com.itexico.developer.myapplication.example.data.entities.User

/**
 * Created by rdelgado on 5/3/2018.
 */
class UserAdapter(private var users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = UserItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.binding.user = users[position]
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun setUsers(users: List<User>) {
        this.users = users
        notifyDataSetChanged()
    }

    class UserViewHolder(var binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)
}

