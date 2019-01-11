package view.pager.recycler.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

import view.pager.recycler.R
import view.pager.recycler.model.Data
import view.pager.recycler.model.PagerItem



class NestedViewPagerFragment : Fragment() {

    /**
     * @return
     */
    private val data: List<Data>
        get() {

            val finalList = ArrayList<Data>()

            for (i in 1..20) {

                val data = Data()

                if (i % 2 == 0) {

                    data.viewType = ViewAdapter.VIEW_TYPE_TEXT
                    data.textItem = "List Item: $i"
                } else {

                    data.viewType = ViewAdapter.VIEW_TYPE_PAGER
                    val pagerItemList = ArrayList<PagerItem>()

                    for (j in 1..10) {
                        val item = PagerItem()
                        item.itemText = j.toString()
                        pagerItemList.add(item)
                    }
                    data.pagerItemList = pagerItemList
                }
                finalList.add(data)
            }

            return finalList
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val mRecyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        mRecyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.setHasFixedSize(false)

        val adapter = ViewAdapter(data, activity?.baseContext!!)
        mRecyclerView.adapter = adapter

        return view
    }
}
