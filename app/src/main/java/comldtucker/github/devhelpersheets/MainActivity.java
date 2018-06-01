package comldtucker.github.devhelpersheets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
//    Member variables
    private ArrayList<SubTopics> mSubTopics;
    private SubTopicAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Initialize RecyclerView and set the layout manager
        RecyclerView mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

//        Initialize the array and the adapter
        mSubTopics = new ArrayList<>();
        mAdapter = new SubTopicAdapter(this, mSubTopics);
//        Set the adapter to the RecyclerView
        mRecyclerView.setAdapter(mAdapter);

//        Get the data
        initializeData();
    }

//    TODO create method for initializing data
    private void initializeData(){
//        Build Arrays from xml resources
        String[] subTopics = getResources().getStringArray(R.array.git_subtopics);
//        Clear the ArrayList to remove duplicate
        mSubTopics.clear();
//        Loop for filling the ArrayList with new objects using the arrays
        for (int i = 0; i < subTopics.length; i++) {
            mSubTopics.add(new SubTopics(subTopics[i]));
        }
//        Notify the adapter of changes
        mAdapter.notifyDataSetChanged();
    }
}
