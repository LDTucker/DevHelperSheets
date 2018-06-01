package comldtucker.github.devhelpersheets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SubTopicAdapter extends RecyclerView.Adapter<SubTopicAdapter.ViewHolder>{
//    Member Variables
    private ArrayList<SubTopics> mSubTopics;
    private Context context;

    SubTopicAdapter(Context context, ArrayList<SubTopics> mSubTopics) {
        this.context = context;
        this.mSubTopics = mSubTopics;
    }

    @NonNull
    @Override
    public SubTopicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        Return, inflate the ViewHolder of subtopics
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.subtopics_list,
                parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SubTopicAdapter.ViewHolder holder, int position) {
//        Get the current position of the content
        SubTopics currentSubTopic = mSubTopics.get(position);

//        Bind the current subtopic to the view holder
        holder.bindTo(currentSubTopic);

    }

    @Override
    public int getItemCount() {
//        Return the size of the ArrayList
        return mSubTopics.size();
    }

    /**
     * Method for inflating the subtopics list layout
     */
    class ViewHolder extends RecyclerView.ViewHolder {
//        Member variables for the content for the CardView
        private TextView subTopicsTitle;

        ViewHolder(View inflate) {
            super(inflate);

//            Initialize the views
            subTopicsTitle = inflate.findViewById(R.id.subtopics_title);
        }

        /**
         * Bind the data from the SubTopics object using the get methods
         */
        void bindTo(SubTopics currentSubTopic) {
//            Populate the TextView with data from object
            subTopicsTitle.setText(currentSubTopic.getSubtopic());
        }
    }

    /**
     * Method that selects the correct list to display
     * from the available options
     */
}
