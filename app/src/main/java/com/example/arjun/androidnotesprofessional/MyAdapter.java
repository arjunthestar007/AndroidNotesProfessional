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

    List<Movie> movieList;

    public MyAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    private static final int FOOTER_VIEW = 1;

    // Define a view holder for Footer view
    public class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Do whatever you want on clicking the item
                }
            });
        }
    }


    // Now define the viewholder for Normal list item
    public class NormalViewHolder extends RecyclerView.ViewHolder {
        TextView title, genere, year;

        public NormalViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView1);
            genere = itemView.findViewById(R.id.textView2);
            year = itemView.findViewById(R.id.textView3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Do whatever you want on clicking the normal items
                }
            });


        }

        public void bindView(int position) {

            Movie movie = movieList.get(position);
            title.setText(movie.getTitle());
            year.setText(movie.getYear());
            genere.setText(movie.getGenre());
            movie.getGenre();
// bindView() method to implement actions
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder { // Define elements of a row here
        public ViewHolder(View itemView) {
            super(itemView);
            // Find view by ID and initialize here
        }

        public void bindView(int position) {
            // bindView() method to implement actions
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v;
        if (viewType == FOOTER_VIEW) {
            v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_footer, viewGroup,
                    false);
            FooterViewHolder vh = new FooterViewHolder(v);
            return vh;
        }
        v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_normal, viewGroup, false);
        NormalViewHolder vh = new NormalViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        if (viewHolder instanceof NormalViewHolder) {
            NormalViewHolder vh = (NormalViewHolder) viewHolder;
            vh.bindView(i);
        } else if (viewHolder instanceof FooterViewHolder) {
            FooterViewHolder vh = (FooterViewHolder) viewHolder;

        }


    }

    @Override
    public int getItemCount() {
        if (movieList == null) {
            return 0;
        }
        if (movieList.size() == 0) {
            return 1;
        }
        // Add extra view to show the footer view
        return movieList.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == movieList.size()) {
            return FOOTER_VIEW;
        }
        return super.getItemViewType(position);
    }
}
