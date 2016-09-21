package view.pager.recycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import view.pager.recycler.model.Data;
import view.pager.recycler.utils.Check;
import view.pager.recycler.viewholder.PagerItemHolder;
import view.pager.recycler.viewholder.TextItemHolder;

/**
 * Created by harneev on 20/09/16.
 */

public class ViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int VIEW_TYPE_TEXT = 51;
    public final static int VIEW_TYPE_PAGER = 52;

    private Context mContext;

    private List<Data> mDataList = new ArrayList<>();

    public HashMap<Integer, Integer> mViewPageStates = new HashMap<>();

    ViewAdapter(List<Data> list, Context context) {

        if (list != null && list.size() > 0)
            mDataList.addAll(list);

        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {

            case VIEW_TYPE_TEXT:
                View userView = inflater.inflate(R.layout.item_recycler_text, parent, false);
                viewHolder = new TextItemHolder(userView);
                break;

            case VIEW_TYPE_PAGER:
                View blockbusterView = inflater.inflate(R.layout.item_recycler_pager, parent, false);
                viewHolder = new PagerItemHolder(blockbusterView);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        switch (holder.getItemViewType()) {

            case VIEW_TYPE_TEXT:
                TextItemHolder textHolder = (TextItemHolder) holder;
                configureTextItem(textHolder, position);
                break;

            case VIEW_TYPE_PAGER:
                PagerItemHolder pagerHolder = (PagerItemHolder) holder;
                configurePagerHolder(pagerHolder, position);
                break;
        }
    }

    private void configureTextItem(TextItemHolder holder, int position) {

        Data data = mDataList.get(position);

        if (!Check.isEmpty(data.getTextItem()))
            holder.tvTitle.setText(data.getTextItem());
    }

    private void configurePagerHolder(PagerItemHolder holder, int position) {

        Data data = mDataList.get(position);

        CustomPagerAdapter adapter = new CustomPagerAdapter(data.getPagerItemList(), mContext);
        holder.viewPager.setAdapter(adapter);

        if (mViewPageStates.containsKey(position))
            holder.viewPager.setCurrentItem(mViewPageStates.get(position));
    }

    @Override
    public void onViewRecycled(RecyclerView.ViewHolder holder) {

        if (holder instanceof PagerItemHolder) {

            PagerItemHolder viewHolder = (PagerItemHolder) holder;

            mViewPageStates.put(holder.getAdapterPosition(), viewHolder.viewPager.getCurrentItem());
            super.onViewRecycled(holder);
        }
    }

    @Override
    public int getItemViewType(int position) {

        return mDataList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {

        return mDataList.size();
    }
}
