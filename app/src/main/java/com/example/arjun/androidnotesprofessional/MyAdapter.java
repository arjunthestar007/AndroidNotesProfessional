package com.example.arjun.androidnotesprofessional;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myholder> {
    List<Movie> mMoviesList;
    ClickInterface clickInterface;

    public interface ClickInterface {
        void clickEventOne(Object obj);

        void clickEventTwo(Object obj1, Object obj2);
    }

    public MyAdapter(List<Movie> mMoviesList) {
        this.mMoviesList = mMoviesList;
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
        Movie movie = mMoviesList.get(i);
        myholder.title.setText(movie.getTitle());
        myholder.genre.setText(movie.getGenre());
        myholder.year.setText(movie.getYear());


    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
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
