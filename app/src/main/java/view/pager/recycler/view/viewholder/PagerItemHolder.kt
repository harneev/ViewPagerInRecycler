package view.pager.recycler.view.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View

import view.pager.recycler.R
import view.pager.recycler.utils.SquareViewPager


class PagerItemHolder(view: View) : RecyclerView.ViewHolder(view) {

    var viewPager: SquareViewPager

    init {

        viewPager = view.findViewById(R.id.slidesPager)
    }
}
