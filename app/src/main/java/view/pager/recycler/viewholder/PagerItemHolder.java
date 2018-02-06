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

    public PagerItemHolder(View view) {
        super(view);

        viewPager = view.findViewById(R.id.slidesPager);
    }
}
