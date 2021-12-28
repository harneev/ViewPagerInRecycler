package view.pager.recycler.nestedviewpager.pager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso

import java.util.ArrayList

import view.pager.recycler.R
import view.pager.recycler.model.PagerItem


class ViewPagerAdapter(list: List<PagerItem>?, private val mContext: Context) : PagerAdapter() {

    private val mInflater: LayoutInflater

    private val mPagerList = ArrayList<PagerItem>()

    init {

        if (list != null && list.isNotEmpty())
            mPagerList.addAll(list)

        this.mInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val rootView = mInflater.inflate(R.layout.item_pager, container, false)

        val holder = ViewHolder(rootView)

        val data = mPagerList[position]

        holder.pagerText.text ="Viewpager Item Number "+ data.itemText
        Picasso.get().load(data.itemImageUrl)
                .placeholder(R.drawable.placeholder)
                .into(holder.imageView)
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
     * Custom class to hold views of ever item
     */
    internal inner class ViewHolder(rootView: View) {
        val pagerText: TextView = rootView.findViewById(R.id.tvPager)
        val imageView:ImageView = rootView.findViewById(R.id.imageViewViewpager)
    }
}
