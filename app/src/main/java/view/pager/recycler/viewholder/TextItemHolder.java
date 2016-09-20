package view.pager.recycler.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import view.pager.recycler.R;

/**
 * Created by harneev on 20/09/16.
 */

public class TextItemHolder extends RecyclerView.ViewHolder {

    public TextView tvTitle;

    public TextItemHolder(View view) {
        super(view);

        tvTitle = (TextView) view.findViewById(R.id.tv_item);
    }
}
