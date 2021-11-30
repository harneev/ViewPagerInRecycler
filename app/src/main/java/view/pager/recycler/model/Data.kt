package view.pager.recycler.model

data class Data(
    var viewType: Int = 0,
    val textItem: String? = null,
    val pagerItemList: List<PagerItem> = mutableListOf()
)

data class PagerItem(
    val itemText: String,
    val itemImageUrl: String
)