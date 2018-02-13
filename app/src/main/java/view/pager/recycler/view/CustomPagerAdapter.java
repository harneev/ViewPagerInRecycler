package view.pager.recycler.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import view.pager.recycler.R;
import view.pager.recycler.model.PagerItem;
import view.pager.recycler.utils.Check;

/**
 * Created by harneev on 20/09/16.
 */

public class CustomPagerAdapter extends PagerAdapter {

    private LayoutInflater mInflater;
    private Context mContext;

    private List<PagerItem> mPagerList = new ArrayList<>();

    public CustomPagerAdapter(List<PagerItem> list, Context context) {

        if (list != null && list.size() > 0)
            mPagerList.addAll(list);

        this.mContext = context;

        this.mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        View rootView = mInflater.inflate(R.layout.item_pager, container, false);

        ViewHolder holder = new ViewHolder(rootView);

        final PagerItem data = mPagerList.get(position);

        if (data != null) {

            holder.pagerText.setText(data.getItemText());
        }

        container.addView(rootView);

        return rootView;
    }

    @Override
    public int getCount() {

        return mPagerList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Don't call the super
        // super.destroyItem(container, position, object);

        container.removeView((View) object);
    }

    /**
     * {@link android.support.v7.widget.RecyclerView.ViewHolder}
     */
    class ViewHolder {

        public TextView pagerText;

        ViewHolder(View rootView) {
            pagerText = rootView.findViewById(R.id.tvPager);
        }
    }
}
