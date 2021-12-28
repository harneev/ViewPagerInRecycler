package view.pager.recycler

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import view.pager.recycler.model.Data
import view.pager.recycler.model.PagerItem
import java.util.ArrayList

/**
 * [ViewModel] to provide values to [NestedViewPagerFragment]
 * @author Harneev Sethi
 */
class CommonViewModel : ViewModel() {

    private val _dataList = MutableLiveData<List<Data>>()
    val dataList: LiveData<List<Data>>
        get() = _dataList

    fun loadDataWithRecycler() = loadData(VIEW_TYPE_RECYCLER)

    fun loadDataWithPager() = loadData(VIEW_TYPE_PAGER)

    private fun loadData(type: Int) = viewModelScope.launch(Dispatchers.Default) {

        val finalList = ArrayList<Data>()

        for (i in 1..20) {

            val data = if (i % 2 == 0) {
                val pagerItemList = ArrayList<PagerItem>().apply {
                    for (j in 1..10) {
                        add(
                            PagerItem(
                                itemText = j.toString(),
                                itemImageUrl = imageUrls()[j]
                            )
                        )
                    }
                }
                Data(
                    viewType = type,
                    pagerItemList = pagerItemList
                )
            } else {
                Data(
                    viewType = VIEW_TYPE_TEXT,
                    textItem = "List Item: $i"
                )
            }

            finalList.add(data)
        }

        _dataList.postValue(finalList)
    }

    private fun imageUrls(): Array<String> =
        arrayOf(
            "https://picsum.photos/300/200?image=60", "https://picsum.photos/300/200?image=8",
            "https://picsum.photos/300/200?image=34", "https://picsum.photos/300/200?image=54",
            "https://picsum.photos/300/200?image=62", "https://picsum.photos/300/200?image=12",
            "https://picsum.photos/300/200?image=15", "https://picsum.photos/300/200?image=27",
            "https://picsum.photos/300/200?image=35", "https://picsum.photos/300/200?image=69",
            "https://picsum.photos/300/200?image=3", "https://picsum.photos/300/200?image=5"
        )

    companion object {
        internal const val VIEW_TYPE_TEXT = 51
        internal const val VIEW_TYPE_PAGER = 52
        internal const val VIEW_TYPE_RECYCLER = 53
    }
}