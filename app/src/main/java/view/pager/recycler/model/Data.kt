package view.pager.recycler.model

data class Data(val textItem: String,
                val pagerItemList: List<PagerItem>) {
    fun bind(binding: ViewDa)
}

data class PagerItem(val itemText: String,
                     val itemImageUrl: String)