package view.pager.recycler.view

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

import view.pager.recycler.R
import view.pager.recycler.model.PagerItem
import view.pager.recycler.utils.Check


class CustomPagerAdapter(list: List<PagerItem>?, private val mContext: Context) : PagerAdapter() {

    private val mInflater: LayoutInflater

    private val mPagerList = ArrayList<PagerItem>()

    init {

        if (list != null && list.size > 0)
            mPagerList.addAll(list)

        this.mInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val rootView = mInflater.inflate(R.layout.item_pager, container, false)

        val holder = ViewHolder(rootView)

        val data = mPagerList[position]

        if (data != null) {

            holder.pagerText.text = data.itemText
        }

        container.addView(rootView)

        return rootView
    }

    override fun getCount(): Int {

        return mPagerList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // Don't call the super
        // super.destroyItem(container, position, object);

        container.removeView(`object` as View)
    }

    /**
     * [android.support.v7.widget.RecyclerView.ViewHolder]
     */
    internal inner class ViewHolder(rootView: View) {

        var pagerText: TextView

        init {
            pagerText = rootView.findViewById(R.id.tvPager)
        }
    }
}
