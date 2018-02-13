package view.pager.recycler.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import view.pager.recycler.R;
import view.pager.recycler.model.Data;
import view.pager.recycler.model.PagerItem;

/**
 * @author Harneev Sethi
 */

public class NestedViewPagerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        RecyclerView mRecyclerView = view.findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(false);

        ViewAdapter adapter = new ViewAdapter(getData(), getActivity());
        mRecyclerView.setAdapter(adapter);

        return view;
    }

    /**
     * @return
     */
    private List<Data> getData() {

        List<Data> finalList = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {

            Data data = new Data();

            if (i % 2 == 0) {

                data.setViewType(ViewAdapter.VIEW_TYPE_TEXT);
                data.setTextItem("List Item: " + i);
            } else {

                data.setViewType(ViewAdapter.VIEW_TYPE_PAGER);
                List<PagerItem> pagerItemList = new ArrayList<>();

                for (int j = 1; j <= 10; j++) {
                    PagerItem item = new PagerItem();
                    item.setItemText(String.valueOf(j));
                    pagerItemList.add(item);
                }
                data.setPagerItemList(pagerItemList);
            }
            finalList.add(data);
        }

        return finalList;
    }
}
