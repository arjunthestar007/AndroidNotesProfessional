package com.example.arjun.androidnotesprofessional;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> implements Filterable {
    List<Movie> mMoviesList;
    List<Movie> mMoviesListFiltered;

    public MyAdapter(List<Movie> mMoviesList) {
        this.mMoviesList = mMoviesList;
        mMoviesListFiltered = mMoviesList;
    }


    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.movie_list_row, viewGroup, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder myholder, int i) {
        Movie movie = mMoviesListFiltered.get(i);
        myholder.title.setText(movie.getTitle());
        myholder.genre.setText(movie.getGenre());
        myholder.year.setText(movie.getYear());


    }



    @Override
    public int getItemCount() {
        return mMoviesListFiltered.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()) {
                    mMoviesListFiltered = mMoviesList;
                } else {
                    List<Movie> filteredList = new ArrayList<>();
                    for (Movie row : mMoviesList) {

                        // name match condition. this might differ depending on your requirement
                        // here we are looking for title or genere number match
                        if (row.getTitle().toLowerCase().contains(charString.toLowerCase())) {
                            filteredList.add(row);
                        }
                    }

                    mMoviesListFiltered = filteredList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = mMoviesListFiltered;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mMoviesListFiltered = (ArrayList<Movie>) results.values;
                notifyDataSetChanged();
            }
        };
    }


    public class Myholder extends RecyclerView.ViewHolder {

        public TextView title, year, genre;

        public Myholder(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);
        }
    }
}
