package dsm2017.com.sns.Recycler

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import dsm2017.com.sns.R
import dsm2017.com.sns.ShowDetailActivity

class SportsListAdapter(val items: ArrayList<Recycleitem>, val context: Context) : RecyclerView.Adapter<SportsListAdapter.SportsCustomViewHolder>() {
    override fun onBindViewHolder(holder: SportsCustomViewHolder, position: Int) {
        holder.title.text = items[position].title
        holder.name.text = items[position].nick_name
        holder.like.text = items[position].like
        holder.date.text = items[position].date
        holder.view.setOnClickListener({
            val intent = Intent(context,ShowDetailActivity::class.java)
            context.startActivity(intent)
        })
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SportsCustomViewHolder{
        val v = LayoutInflater.from(context).inflate(R.layout.item_sports, parent, false)
        return SportsCustomViewHolder(v)
    }


    override fun getItemCount(): Int {
        return items.size
    }


    inner class SportsCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.list_sports_title)
        val name = itemView.findViewById<TextView>(R.id.list_sports_name)
        val like = itemView.findViewById<TextView>(R.id.list_sports_like)
        val date = itemView.findViewById<TextView>(R.id.list_sports_date)
        val view = itemView.findViewById<LinearLayout>(R.id.sports_item)
    }
}
