package lk.et.collapseitemrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie("Schindler's List", "Biography, Drama, History", 1993));
        movieList.add(new Movie("Pulp Fiction", "Crime, Drama", 1994));
        movieList.add(new Movie("No Country for Old Men", "Crime, Drama, Thriller", 2007));
        movieList.add(new Movie("Léon: The Professional", "Crime, Drama, Thriller", 1994));
        movieList.add(new Movie("Fight Club", "Drama", 1999));
        movieList.add(new Movie("Forrest Gump", "Drama, Romance", 1994));
        movieList.add(new Movie("The Shawshank Redemption", "Crime, Drama", 1994));
        movieList.add(new Movie("The Godfather", "Crime, Drama", 1972));
        movieList.add(new Movie("A Beautiful Mind", "Biography, Drama", 2001));
        movieList.add(new Movie("Good Will Hunting", "Drama", 1997));

        RAdapater adapter = new RAdapater(movieList);

        RecyclerView recyclerView = findViewById(R.id.rv);

        ((SimpleItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
    }
}