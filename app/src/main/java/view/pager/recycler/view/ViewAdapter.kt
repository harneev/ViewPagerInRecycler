package view.pager.recycler.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList
import java.util.HashMap

import view.pager.recycler.R
import view.pager.recycler.model.Data
import view.pager.recycler.utils.Check
import view.pager.recycler.view.viewholder.PagerItemHolder
import view.pager.recycler.view.viewholder.TextItemHolder


class ViewAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val mDataList = ArrayList<Data>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        var viewHolder: RecyclerView.ViewHolder? = null
        val inflater = LayoutInflater.from(parent.context)

        when (viewType) {

            VIEW_TYPE_TEXT -> {
                val userView = inflater.inflate(R.layout.item_recycler_text, parent, false)
                viewHolder = TextItemHolder(userView)
            }

            VIEW_TYPE_PAGER -> {
                val blockbusterView = inflater.inflate(R.layout.item_recycler_pager, parent, false)
                viewHolder = PagerItemHolder(blockbusterView)
            }
        }

        return viewHolder!!
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

        val data = mDataList[position]

        if (!Check.isEmpty(data.textItem))
            holder.tvTitle.text = data.textItem
    }

    private fun configurePagerHolder(holder: PagerItemHolder, position: Int) {

        val data = mDataList[position]

        val adapter = CustomPagerAdapter(data.pagerItemList, context)
        holder.viewPager.adapter = adapter

        if (mViewPageStates.containsKey(position)) {
            holder.viewPager.currentItem = mViewPageStates[position]!!
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {

        if (holder is PagerItemHolder) {

            mViewPageStates[holder.getAdapterPosition()] = holder.viewPager.currentItem
            super.onViewRecycled(holder)
        }
    }

    override fun getItemViewType(position: Int): Int {

        return mDataList[position].viewType
    }

    override fun getItemCount(): Int {

        return mDataList.size
    }

    companion object {

        internal val VIEW_TYPE_TEXT = 51
        internal val VIEW_TYPE_PAGER = 52
    }
}
