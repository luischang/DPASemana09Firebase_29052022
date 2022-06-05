package dev.lchang.dpasemana09firebase.ui.fragments.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.lchang.dpasemana09firebase.R
import dev.lchang.dpasemana09firebase.ui.fragments.model.CourseModel

class CourseAdapter(private var lstCourse: List<CourseModel>)
    : RecyclerView.Adapter<CourseAdapter.ViewHolder>()
{
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvCourse: TextView = itemView.findViewById(R.id.tvCourse)
        val tvScore: TextView = itemView.findViewById(R.id.tvScore)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_course,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = lstCourse[position]
        holder.tvCourse.text = item.description
        holder.tvScore.text = item.score
    }

    override fun getItemCount(): Int {
        return lstCourse.size
    }


}