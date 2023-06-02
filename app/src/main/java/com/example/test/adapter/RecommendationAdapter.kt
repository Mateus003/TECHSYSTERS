package com.example.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.test.R
import com.example.test.model.Recommendation

class RecommendationAdapter(private val listRecommendation: List<Recommendation>): RecyclerView.Adapter<RecommendationAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View): ViewHolder(itemView){
        fun bind(recommendation: Recommendation){
            val nameTech: TextView = itemView.findViewById(R.id.name_tech)
            val image: ImageView = itemView.findViewById(R.id.image_icon_tech)
            image.setImageResource(recommendation.imageTech)
            nameTech.text = recommendation.nameTech
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recommendation_item, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return listRecommendation.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val nameTech = listRecommendation[position]
        holder.bind(nameTech)
    }
}