package a.com.recyclerdesign;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static DataAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    List<DataModel> dataModelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        dataModelList = new ArrayList<>();

        dataModelList.add(
                new DataModel("HDFC", "3500", R.drawable.hdfclogo));
        dataModelList.add(
                new DataModel("SBI", "4500", R.drawable.sbi));
        dataModelList.add(
                new DataModel("HDFC", "6500", R.drawable.hdfclogo));
        dataModelList.add(
                new DataModel("SBI", "7500", R.drawable.sbi));
        dataModelList.add(
                new DataModel("SBI", "9500", R.drawable.sbi));

        adapter = new DataAdapter(this, dataModelList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);
    }
}
