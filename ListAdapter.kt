package com.ian.myvan.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ian.myvan.R
import com.ian.myvan.model.Students
import com.ian.myvan.uitel.loadImage
import com.ian.myvan.view.DetailsActivity

class ListAdapter (var mContext:Context,var studentsList:List<Students>):
    RecyclerView.Adapter<ListAdapter.ListViewHolder>()
{
    inner class ListViewHolder(var v:View): RecyclerView.ViewHolder(v){
        var imgT = v.findViewById<ImageView>(R.id.studentImageView)
        var nameT = v.findViewById<TextView>(R.id.sNameTv)
        var descriT = v.findViewById<TextView>(R.id.descriptionTextView)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        var infalter = LayoutInflater.from(parent.context)
        var v = infalter.inflate(R.layout.row_item,parent,false)
        return ListViewHolder(v)
    }

    override fun getItemCount(): Int =studentsList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var newList = studentsList[position]
        holder.nameT.text = newList.name
        holder.descriT.text = newList.description

        holder.imgT.loadImage(newList.imageUrl)
        holder.v.setOnClickListener {

            val name = newList.name
            val descrip = newList.description
            val imgUri = newList.imageUrl



            val mIntent = Intent(mContext,DetailsActivity::class.java)
            mIntent.putExtra("NAMET",name)
            mIntent.putExtra("DESCRIT",descrip)
            mIntent.putExtra("IMGURI",imgUri)

            mContext.startActivity(mIntent)
        }
    }
}