package view.pager.recycler.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import view.pager.recycler.R;
import view.pager.recycler.utils.SquareViewPager;

/**
 * Created by harneev on 20/09/16.
 */

public class PagerItemHolder extends RecyclerView.ViewHolder {

    public SquareViewPager viewPager;
    //public ImageView ivLoading;

    public PagerItemHolder(View view) {
        super(view);

        viewPager = (SquareViewPager) view.findViewById(R.id.slidesPager);
        //ivLoading = (ImageView) view.findViewById(R.id.ivLoading);
    }
}
