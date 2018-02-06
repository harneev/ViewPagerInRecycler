package view.pager.recycler.model;

import java.io.Serializable;

/**
 * Created by harneev on 20/09/16.
 */

public class PagerItem implements Serializable {

    private String itemText;

    private int itemImage;

    public void setItemImage(int itemImage) {
        this.itemImage = itemImage;
    }

    public void setItemText(String itemText) {
        this.itemText = itemText;
    }

    public int getItemImage() {
        return itemImage;
    }

    public String getItemText() {
        return itemText;
    }
}
