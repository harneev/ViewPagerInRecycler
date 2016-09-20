package view.pager.recycler.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by harneev on 20/09/16.
 */

public class Data implements Serializable {

    private int viewType;

    private String textItem;

    private List<PagerItem> pagerItemList;

    /*
     * SETTER
     */
    public void setPagerItemList(List<PagerItem> pagerItemList) {
        this.pagerItemList = pagerItemList;
    }

    public void setTextItem(String textItem) {
        this.textItem = textItem;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    /*
     * GETTER
     */
    public List<PagerItem> getPagerItemList() {
        return pagerItemList;
    }

    public String getTextItem() {
        return textItem;
    }

    public int getViewType() {
        return viewType;
    }
}
