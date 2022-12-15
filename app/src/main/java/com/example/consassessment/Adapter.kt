package com.example.consassessment

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Adapter(private var listner:setonitemclclick) : RecyclerView.Adapter<Adapter.Myviewholder>() {
        private val items = ArrayList<RecordedVideo>()



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
            val itemview =
                LayoutInflater.from(parent.context).inflate(R.layout.itemlist, parent, false)
            val holder = Myviewholder(itemview)
            itemview.setOnClickListener {
                listner.onitemclicks(items[holder.adapterPosition])
            }
            return holder

        }

        override fun onBindViewHolder(holder: Myviewholder, position: Int) {

            val currentitem = items[position]
            holder.Name.text = currentitem.name
            holder.Duration.text = currentitem.duration.toString()
            holder.coordinates.text = currentitem.coordinates.toString()
            holder.thumbnailimage.setImageResource(currentitem.image)



        }

        override fun getItemCount(): Int {
            return items.size

        }

        @SuppressLint("NotifyDataSetChanged")
        fun updateddata(updateddata: ArrayList<RecordedVideo>) {
            items.clear()
            items.addAll(updateddata)
            notifyDataSetChanged()
        }


        class Myviewholder(itemView: View) :
            RecyclerView.ViewHolder(itemView) {
            var thumbnailimage:ShapeableImageView = itemView.findViewById(R.id.Thumbnailimage)
            var Name: TextView = itemView.findViewById(R.id.Name)
            var Duration: TextView = itemView.findViewById(R.id.Duration)
            var coordinates:TextView  = itemView.findViewById(R.id.Coordinates)



        }

        interface setonitemclclick {
            fun onitemclicks(items: RecordedVideo)


        }
    }

