package br.com.tiagomnunes.taller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(private val list: List<Item>) : RecyclerView.Adapter<Adapter.MyViewHolder>() {

    var listener: OnItemClickListener? = null


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.description.text = list[position].description

        holder.itemView.setOnClickListener {
            listener?.onItemClickListener(it, position, list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.title)
        val description = itemView.findViewById<TextView>(R.id.description)
    }

    interface OnItemClickListener {
        fun onItemClickListener(v: View, pos: Int, item: Item)
    }
}