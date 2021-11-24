package view.pager.recycler.ui.nestedviewpager

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import view.pager.recycler.model.Data
import view.pager.recycler.model.PagerItem
import java.util.ArrayList

class NestedViewPagerViewModel : ViewModel() {

    val dataList = MutableLiveData<List<Data>>()

    private fun loadData() {
        // do async operation to fetch data
        Thread {
            Thread.sleep(5000)

            val finalList = ArrayList<Data>()

            for (i in 1..20) {
                val pagerItemList = ArrayList<PagerItem>().apply {
                    for (j in 1..10) {
                        add(PagerItem(itemText = j.toString(),
                                itemImageUrl = imageUrls()[j]))
                    }
                }

                val data = Data(textItem = "List Item: $i",
                        pagerItemList = pagerItemList)

                finalList.add(data)
            }

            dataList.value = finalList
        }.start()
    }

    private fun imageUrls(): Array<String> {
        val images = arrayOf("https://picsum.photos/300/200?image=60", "https://picsum.photos/300/200?image=8",
                "https://picsum.photos/300/200?image=34", "https://picsum.photos/300/200?image=54",
                "https://picsum.photos/300/200?image=62", "https://picsum.photos/300/200?image=12",
                "https://picsum.photos/300/200?image=15", "https://picsum.photos/300/200?image=27",
                "https://picsum.photos/300/200?image=35", "https://picsum.photos/300/200?image=69",
                "https://picsum.photos/300/200?image=3", "https://picsum.photos/300/200?image=5")
        return images
    }
}