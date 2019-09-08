package com.example.arjun.androidnotesprofessional;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    LinearLayoutManager mLinearLayoutManager;
    MyAdapter mMyAdapter;
    private List<Movie> objectList = new ArrayList<>();

    Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mMyAdapter = new MyAdapter(objectList);
        mLinearLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRecyclerView.setAdapter(mMyAdapter);
        mMyAdapter.setmClickInterface(new MyAdapter.ClickInterface() {
            @Override
            public void clickEventOne(Object obj) {
                Movie movie = (Movie) obj;
                Toast.makeText(MainActivity.this, "" + movie.getTitle(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void clickEventTwo(Object obj1, Object obj2) {
                Movie movie = (Movie) obj1;
                Toast.makeText(MainActivity.this, "" + movie.getYear(), Toast.LENGTH_SHORT).show();

            }
        });
        prepareMovieData();

    }

    private void prepareMovieData() {
        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        objectList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        objectList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        objectList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        objectList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        objectList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        objectList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        objectList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        objectList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        objectList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        objectList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        objectList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        objectList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        objectList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        objectList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        objectList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        objectList.add(movie);

        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        objectList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        objectList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        objectList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        objectList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        objectList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        objectList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        objectList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        objectList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        objectList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        objectList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        objectList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        objectList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        objectList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        objectList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        objectList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        objectList.add(movie);

        movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015");
        objectList.add(movie);

        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015");
        objectList.add(movie);

        movie = new Movie("Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        objectList.add(movie);

        movie = new Movie("Shaun the Sheep", "Animation", "2015");
        objectList.add(movie);

        movie = new Movie("The Martian", "Science Fiction & Fantasy", "2015");
        objectList.add(movie);

        movie = new Movie("Mission: Impossible Rogue Nation", "Action", "2015");
        objectList.add(movie);

        movie = new Movie("Up", "Animation", "2009");
        objectList.add(movie);

        movie = new Movie("Star Trek", "Science Fiction", "2009");
        objectList.add(movie);

        movie = new Movie("The LEGO Movie", "Animation", "2014");
        objectList.add(movie);

        movie = new Movie("Iron Man", "Action & Adventure", "2008");
        objectList.add(movie);

        movie = new Movie("Aliens", "Science Fiction", "1986");
        objectList.add(movie);

        movie = new Movie("Chicken Run", "Animation", "2000");
        objectList.add(movie);

        movie = new Movie("Back to the Future", "Science Fiction", "1985");
        objectList.add(movie);

        movie = new Movie("Raiders of the Lost Ark", "Action & Adventure", "1981");
        objectList.add(movie);

        movie = new Movie("Goldfinger", "Action & Adventure", "1965");
        objectList.add(movie);

        movie = new Movie("Guardians of the Galaxy", "Science Fiction & Fantasy", "2014");
        objectList.add(movie);
        mMyAdapter.notifyDataSetChanged();


    }
}
