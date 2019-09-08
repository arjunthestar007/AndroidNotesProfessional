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
    ClickInterface mClickInterface;

    public interface ClickInterface {
        void clickEventOne(Object obj);

        void clickEventTwo(Object obj1, Object obj2);
    }

    public MyAdapter(List<Movie> mMoviesList) {
        this.mMoviesList = mMoviesList;
    }

    public void setmClickInterface(ClickInterface mClickInterface) {
        this.mClickInterface = mClickInterface;
    }


    @NonNull
    @Override
    public Myholder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.movie_list_row, viewGroup, false);
        return new Myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myholder myholder, int position) {
        Movie movie = mMoviesList.get(position);
        myholder.title.setText(movie.getTitle());
        myholder.genre.setText(movie.getGenre());
        myholder.year.setText(movie.getYear());

        //make all even positions not clickable
        myholder.firstClickListener.setmClickable(position % 2 == 0);
        myholder.firstClickListener.setmPosition(position);
        myholder.secondClickListener.setPosition(position);


    }

    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }

    public class FirstClickListener implements View.OnClickListener {
        private int mPosition;
        private boolean mClickable;

        public void setmPosition(int mPosition) {
            this.mPosition = mPosition;
        }

        public void setmClickable(boolean mClickable) {
            this.mClickable = mClickable;
        }

        @Override
        public void onClick(View v) {
            if (mClickable) {
                mClickInterface.clickEventOne(mMoviesList.get(mPosition));
            }

        }
    }

    private class SecondClickListener implements View.OnClickListener {
        private int mPosition;

        void setPosition(int position) {
            mPosition = position;
        }

        @Override
        public void onClick(View v) {
            mClickInterface.clickEventTwo(mMoviesList.get(mPosition), v);
        }
    }

    public class Myholder extends RecyclerView.ViewHolder {

        public TextView title, year, genre;
        FirstClickListener firstClickListener;
        SecondClickListener secondClickListener;

        public Myholder(@NonNull View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            genre = (TextView) view.findViewById(R.id.genre);
            year = (TextView) view.findViewById(R.id.year);

            firstClickListener = new FirstClickListener();
            title.setOnClickListener(firstClickListener);

            secondClickListener=new SecondClickListener();
            year.setOnClickListener(secondClickListener);
        }
    }
}
