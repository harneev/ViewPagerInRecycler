package view.pager.recycler.ui.nestedviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import java.util.ArrayList

import view.pager.recycler.R
import view.pager.recycler.model.Data
import view.pager.recycler.model.PagerItem
import view.pager.recycler.view.ViewAdapter

class NestedViewPagerFragment : Fragment() {

    private lateinit var viewModel: NestedViewPagerViewModel

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProvider(this).get(NestedViewPagerViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_main, container, false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        activity?.let {  }
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.setHasFixedSize(false)

        val adapter = activity?.let { ViewAdapter(it) }
        recyclerView.adapter = adapter

        viewModel.dataList.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })

        return view
    }
}
