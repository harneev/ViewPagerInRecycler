package view.pager.recycler.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import view.pager.recycler.R


class TextItemHolder(view: View) : RecyclerView.ViewHolder(view) {

    var tvTitle: TextView

    init {

        tvTitle = view.findViewById<View>(R.id.tv_item) as TextView
    }
}
