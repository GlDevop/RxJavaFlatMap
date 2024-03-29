package gabriellee.project.rxjavaflatmap.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gabriellee.project.rxjavaflatmap.R;
import gabriellee.project.rxjavaflatmap.model.Post;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG = "RecyclerAdapter";

    private List<Post> posts = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_post_list_item, null, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.bind(posts.get(i));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public void updatePosts(Post post) {
        posts.set(posts.indexOf(post), post);
        notifyItemChanged(posts.indexOf(post));
    }

    public List<Post> getPosts() {
        return posts;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title, numComments;
        ProgressBar progressBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            numComments = itemView.findViewById(R.id.num_comments);
            progressBar = itemView.findViewById(R.id.progress_bar);
        }

        public void bind(Post post) {
            title.setText(post.getTitle());

            if(post.getComments() == null){
                showProgressBar(true);
                numComments.setText("");
            }
            else {
                showProgressBar(false);
                numComments.setText(String.valueOf(post.getComments().size()));
            }
        }

        private void showProgressBar(boolean showProgressBar) {
            if(showProgressBar) {
                progressBar.setVisibility(View.VISIBLE);
            }
            else {
                progressBar.setVisibility(View.GONE);
            }
        }
    }

}
