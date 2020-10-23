package lk.et.collapseitemrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RAdapater extends RecyclerView.Adapter<RAdapater.ViewHolder> {

    private List<Movie> movies;

    public RAdapater(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public RAdapater.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RAdapater.ViewHolder holder, final int position) {
        final Movie movie = movies.get(position);
        holder.bind(movie);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movie.setExpanded(!movie.isExpanded());
                notifyItemChanged(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item_title;
        private TextView sub_item_genre;
        private TextView sub_item_year;
        private View subItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.item_title);
            sub_item_genre = itemView.findViewById(R.id.sub_item_genre);
            sub_item_year = itemView.findViewById(R.id.sub_item_year);
            subItem = itemView.findViewById(R.id.sub_item);
        }

        private void bind(Movie movie) {
            boolean expanded = movie.isExpanded();

            subItem.setVisibility(expanded ? View.VISIBLE : View.GONE);

            item_title.setText(movie.getTitle());
            sub_item_genre.setText("Genre: " + movie.getGenre());
            sub_item_year.setText("Year: " + movie.getYear());
        }
    }
}
