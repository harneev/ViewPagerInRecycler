package view.pager.recycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import view.pager.recycler.model.Data;
import view.pager.recycler.model.PagerItem;

/**
 * Created by harneev on 20/09/16.
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setHasFixedSize(false);

        ViewAdapter adapter = new ViewAdapter(getData(), MainActivity.this);
        mRecyclerView.setAdapter(adapter);
    }

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
