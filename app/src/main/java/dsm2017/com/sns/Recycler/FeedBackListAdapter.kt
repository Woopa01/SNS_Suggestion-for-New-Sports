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

class FeedBackListAdapter(val feedback_items: ArrayList<Recycleitem>, val feedback_context: Context) : RecyclerView.Adapter<FeedBackListAdapter.FeedBackCustomViewHolder>() {
    override fun onBindViewHolder(holder: FeedBackCustomViewHolder, position: Int) {
        holder.feedback_title?.text = feedback_items[position].title
        holder.feedback_sports_name?.text = feedback_items[position].nick_name
        holder.feedback_name?.text = feedback_items[position].like
        holder.feedback_date?.text = feedback_items[position].date
        holder.feedback_view?.setOnClickListener({
            val intent = Intent(feedback_context,ShowDetailActivity::class.java)
            feedback_context.startActivity(intent)
    })
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedBackCustomViewHolder{
        val v = LayoutInflater.from(feedback_context).inflate(R.layout.item_feedback, parent, false)
        return FeedBackCustomViewHolder(v)
    }


    override fun getItemCount(): Int {
        return feedback_items.size
    }


    inner class FeedBackCustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val feedback_title = itemView.findViewById<TextView>(R.id.list_feedback_title)
        val feedback_sports_name = itemView.findViewById<TextView>(R.id.list_feedback_sports_name)
        val feedback_name = itemView.findViewById<TextView>(R.id.list_feedback_name)
        val feedback_date = itemView.findViewById<TextView>(R.id.list_feedback_date)
        val feedback_view = itemView.findViewById<LinearLayout>(R.id.feedback_item)
    }
}
