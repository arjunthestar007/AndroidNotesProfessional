package com.example.arjun.androidnotesprofessional;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    // The items to display in your RecyclerView
    private List<Object> items;

    private final int MOVIE = 0, IMAGE = 1;


    public MyAdapter(List<Object> mMoviesList) {
        this.items = mMoviesList;
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) instanceof Movie) {
            return MOVIE;
        } else if (items.get(position) instanceof String) {
            return IMAGE;
        }
        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        switch (viewType) {
            case MOVIE:
                View v1 = inflater.inflate(R.layout.movie_list_row, viewGroup, false);
                viewHolder = new ViewHolder1(v1);
                break;
            case IMAGE:
                View v2 = inflater.inflate(R.layout.viewholder2, viewGroup, false);
                viewHolder = new ViewHolder2(v2);
                break;
//            default:
//                View v = inflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
//                viewHolder = new MyAdapter(v);
//                break;
        }
        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        switch (viewHolder.getItemViewType()) {
            case MOVIE:
                ViewHolder1 vh1 = (ViewHolder1) viewHolder;
                configureViewHolder1(vh1, position);
                break;
            case IMAGE:
                ViewHolder2 vh2 = (ViewHolder2) viewHolder;
                configureViewHolder2(vh2, position);
                break;
//            default:
//                RecyclerViewSimpleTextViewHolder vh = (RecyclerViewSimpleTextViewHolder) viewHolder;
//                configureDefaultViewHolder(vh, position);
//                break;
        }
    }
    private void configureViewHolder1(ViewHolder1 vh1, int position) {
        Movie movie = (Movie) items.get(position);
        if (movie != null) {
            vh1.title.setText("title: " + movie.getTitle());
            vh1.genre.setText("genere: " + movie.getGenre());
        }
    }

    private void configureViewHolder2(ViewHolder2 vh2,int position) {
        vh2.getImageView().setImageResource(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        public TextView title, year, genre;

        public ViewHolder1(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {

        private ImageView ivExample;

        public ViewHolder2(View v) {
            super(v);
            ivExample = (ImageView) v.findViewById(R.id.ivExample);
        }

        public ImageView getImageView() {
            return ivExample;
        }

        public void setImageView(ImageView ivExample) {
            this.ivExample = ivExample;
        }
    }
}
