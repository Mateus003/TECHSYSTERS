package com.example.test.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.test.R
import com.example.test.model.Mentor

class MentorAdapter(private val listMentor: List<Mentor>, private val mentorClickListener: MentorClickListener): RecyclerView.Adapter<MentorAdapter.MyViewHolder>() {
    inner class MyViewHolder(itemView: View): ViewHolder(itemView){
        fun bind(mentor: Mentor){
            val nameMentor:TextView = itemView.findViewById(R.id.name_mentor)
            val office: TextView = itemView.findViewById(R.id.office)
            val image: ImageView = itemView.findViewById(R.id.image_mentor)

            image.setImageResource(mentor.pictureMentor)
            nameMentor.text = mentor.name
            office.text = mentor.office


            itemView.setOnClickListener {
                mentorClickListener.onMentorClicked(mentor)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.mentor_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listMentor.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val name = listMentor[position]
        val office = listMentor[position]
        val pictureMentor = listMentor[position]
        holder.bind(name)
        holder.bind(office)
        holder.bind(pictureMentor)
    }

    interface MentorClickListener {
        fun onMentorClicked(mentor: Mentor)
    }
}