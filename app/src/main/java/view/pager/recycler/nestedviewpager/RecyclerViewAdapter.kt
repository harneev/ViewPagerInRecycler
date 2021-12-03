package view.pager.recycler.nestedviewpager.pager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import view.pager.recycler.R
import view.pager.recycler.model.Data
import view.pager.recycler.utils.Check

/**
 * [RecyclerView.Adapter] holding [NestedRecyclerFragment] view pager logic
 */
class RecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val viewPageStates = HashMap<Int, Int>()

    var dataList = mutableListOf<Data>()
        set(value) {
            field.clear()
            field.addAll(value)
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            VIEW_TYPE_TEXT ->
                TextItemHolder(inflater.inflate(R.layout.item_recycler_text, parent, false))

            else ->
                PagerItemHolder(inflater.inflate(R.layout.item_recycler_pager, parent, false))
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when (holder.itemViewType) {

            VIEW_TYPE_TEXT -> {
                val textHolder = holder as TextItemHolder
                configureTextItem(textHolder, position)
            }

            VIEW_TYPE_PAGER -> {
                val pagerHolder = holder as PagerItemHolder
                configurePagerHolder(pagerHolder, position)
            }
        }
    }

    private fun configureTextItem(holder: TextItemHolder, position: Int) {

        val data = dataList[position]

        if (!Check.isEmpty(data.textItem))
            holder.tvTitle.text = data.textItem
    }

    private fun configurePagerHolder(holder: PagerItemHolder, position: Int) {

        val data = dataList[position]

        val adapter = ViewPagerAdapter(data.pagerItemList, context)
        holder.viewPager.adapter = adapter

        if (viewPageStates.containsKey(position)) {
            viewPageStates[position]?.let {
                holder.viewPager.currentItem = it
            }
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        if (holder is PagerItemHolder) {

            viewPageStates[holder.getAdapterPosition()] = holder.viewPager.currentItem
            super.onViewRecycled(holder)
        }
    }

    override fun getItemViewType(position: Int): Int = dataList[position].viewType

    override fun getItemCount(): Int = dataList.size

    companion object {
        internal const val VIEW_TYPE_TEXT = 51
        internal const val VIEW_TYPE_PAGER = 52
    }
}

/**
 * [RecyclerView.ViewHolder] holding the title of type [TextView]
 */
private class TextItemHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tvTitle: TextView = view.findViewById<View>(R.id.tv_item) as TextView
}

/**
 * [RecyclerView.ViewHolder] holding nested [SquareViewPager]
 */
private class PagerItemHolder(view: View) : RecyclerView.ViewHolder(view) {

    val viewPager: SquareViewPager = view.findViewById(R.id.slidesPager)
}
