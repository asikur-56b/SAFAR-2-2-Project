package com.example.safar.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.example.safar.Models.User
import com.example.safar.R


@GlideModule
class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){


    private val userList = ArrayList<User>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(

            R.layout.user_item,
            parent,false


        )

        return MyViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.firstName.text = currentitem.Place
        holder.lastName.text = currentitem.Tourtype
        holder.age.text = currentitem.Cost
        Glide.with(holder.itemView.context).load(currentitem.img).into(holder.oree)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Confirm For Booked", Toast.LENGTH_SHORT).show()
            //userList[position].toString()

            val context=holder.itemView.context
            // val intent = Intent(holder.itemView.context, com.example.bottomnavigation.ProductDetails::class.java)
           // context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {


        return  userList.size

    }

    fun updateUserList(userList: List<User>){

        this.userList.clear()
        this.userList.addAll(userList)
        notifyDataSetChanged()

    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val firstName : TextView = itemView.findViewById(R.id.tvfirstName)
        val lastName : TextView = itemView.findViewById(R.id.tvlastName)
        val age : TextView = itemView.findViewById(R.id.tvage)
        val oree : ImageView = itemView.findViewById(R.id.images)

    }






}