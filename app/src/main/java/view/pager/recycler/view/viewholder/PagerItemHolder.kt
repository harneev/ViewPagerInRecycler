package view.pager.recycler.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

import view.pager.recycler.R
import view.pager.recycler.utils.SquareViewPager


class PagerItemHolder(view: View) : RecyclerView.ViewHolder(view) {

    var viewPager: SquareViewPager

    init {

        viewPager = view.findViewById(R.id.slidesPager)
    }
}
