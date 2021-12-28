package view.pager.recycler.nestedrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import view.pager.recycler.CommonViewModel
import view.pager.recycler.R
import view.pager.recycler.model.Data
import view.pager.recycler.nestedviewpager.pager.SquareViewPager
import view.pager.recycler.nestedviewpager.pager.ViewPagerAdapter

/**
 * Adapter shared by both [NestedRecyclerFragment] and [NestedViewPagerFragment]
 * to load parent recycler view.
 */
class RecyclerViewAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var dataList = mutableListOf<Data>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            CommonViewModel.VIEW_TYPE_TEXT ->
                TextViewHolder(inflater.inflate(R.layout.item_recycler_text, parent, false))

            CommonViewModel.VIEW_TYPE_RECYCLER ->
                NestedRecyclerViewHolder(inflater.inflate(R.layout.fragment_main, parent, false))

            else -> PagerItemHolder(
                inflater.inflate(
                    R.layout.item_recycler_pager,
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = dataList[position]

        when (holder.itemViewType) {
            CommonViewModel.VIEW_TYPE_TEXT -> {
                holder as TextViewHolder
                holder.tvTitle.text = data.textItem
            }

            CommonViewModel.VIEW_TYPE_PAGER -> {
                holder as PagerItemHolder

                holder.viewPager.adapter = ViewPagerAdapter(data.pagerItemList, context)
            }

            CommonViewModel.VIEW_TYPE_RECYCLER -> {
                holder as NestedRecyclerViewHolder
                holder.horizontalRecycler.adapter = NestedRecyclerViewAdapter(data.pagerItemList)
            }
        }
    }

    override fun getItemCount(): Int = dataList.size

    override fun getItemViewType(position: Int): Int = dataList[position].viewType
}

/**
 * [RecyclerView.ViewHolder] holding nested [SquareViewPager]
 */
private class NestedRecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val horizontalRecycler: RecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView).apply {
        layoutManager = LinearLayoutManager(
            view.context,
            LinearLayoutManager.HORIZONTAL,
            false
        )
    }
}

/**
 * [RecyclerView.ViewHolder] holding the title of type [TextView]
 */
class TextViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tvTitle: TextView = view.findViewById<TextView>(R.id.tv_item)
}

/**
 * [RecyclerView.ViewHolder] holding nested [SquareViewPager]
 */
private class PagerItemHolder(view: View) : RecyclerView.ViewHolder(view) {

    val viewPager: SquareViewPager = view.findViewById(R.id.slidesPager)
}



