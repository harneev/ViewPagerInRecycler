package view.pager.recycler.nestedviewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import view.pager.recycler.R
import view.pager.recycler.model.Data
import view.pager.recycler.view.ViewAdapter

/**
 * [Fragment] showing recycler view with nested [androidx.viewpager.widget.ViewPager]
 *
 * @author Harneev Sethi
 */
class NestedViewPagerFragment : Fragment() {

    private val viewModel: NestedViewPagerViewModel by viewModels()
    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(false)
            adapter = ViewAdapter(requireActivity())
        }

        viewModel.dataList.observe(viewLifecycleOwner, {dataList ->
            (dataList as? MutableList<Data>)?.let {
                (recyclerView?.adapter as? ViewAdapter)?.dataList = it
            }
        })
        viewModel.loadData()
    }
}
