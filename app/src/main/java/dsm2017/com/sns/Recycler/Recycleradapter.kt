package dsm2017.com.sns.Recycler

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import dsm2017.com.sns.R
import dsm2017.com.sns.ShowDetailActivity
import kotlinx.android.synthetic.main.item_recycler.view.*

class Recycleradapter(val items: ArrayList<Recycleitem>, val context: Context) : RecyclerView.Adapter<Recycleradapter.CustomViewHolder>() {
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.name.text = items[position].nick_name
        holder.like.text = items[position].like
        holder.date.text = items[position].date
        holder.itemView.setOnClickListener {
            val intent = Intent(context,ShowDetailActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder{
        val v = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false)
        return CustomViewHolder(v)
    }


    override fun getItemCount(): Int {
        return items.size
    }


    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.list_recycler_title)
        val name = itemView.findViewById<TextView>(R.id.list_recycler_name)
        val like = itemView.findViewById<TextView>(R.id.list_recycler_like)
        val date = itemView.findViewById<TextView>(R.id.list_recycler_date)
    }
}
