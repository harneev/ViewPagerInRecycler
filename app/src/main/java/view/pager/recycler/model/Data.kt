package view.pager.recycler.model

import java.io.Serializable

class Data : Serializable {
    var viewType: Int = 0
    var textItem: String? = null
    var pagerItemList: List<PagerItem>? = null
}
