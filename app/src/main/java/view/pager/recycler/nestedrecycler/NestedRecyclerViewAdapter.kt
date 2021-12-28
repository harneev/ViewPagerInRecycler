package view.pager.recycler.nestedrecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import view.pager.recycler.R
import view.pager.recycler.model.PagerItem

class NestedRecyclerViewAdapter(private val dataList: List<PagerItem>) : RecyclerView.Adapter<NestedRecyclerViewAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemViewHolder(inflater.inflate(R.layout.item_pager, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataList[position]
        holder.pagerText.text = "Recycler Item Number ${item.itemText}"

        Picasso.get().load(item.itemImageUrl)
            .placeholder(R.drawable.placeholder)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int = dataList.size

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pagerText: TextView = view.findViewById(R.id.tvPager)
        val imageView: ImageView = view.findViewById(R.id.imageViewViewpager)
    }
}