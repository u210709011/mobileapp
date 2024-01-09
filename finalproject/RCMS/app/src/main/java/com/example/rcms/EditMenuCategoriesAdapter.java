package com.example.rcms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EditMenuCategoriesAdapter extends RecyclerView.Adapter<EditMenuCategoriesAdapter.CategoryViewHolder> {

    private List<String> categories;
    private Context context;
    private OnCategoryItemClickListener onCategoryItemClickListener;

    public EditMenuCategoriesAdapter(List<String> categories, Context context, OnCategoryItemClickListener onCategoryItemClickListener) {
        this.categories = categories;
        this.context = context;
        this.onCategoryItemClickListener = onCategoryItemClickListener;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View categoryItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_category, parent, false);
        return new CategoryViewHolder(categoryItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String category = categories.get(position);
        holder.categoryButton.setText(category);

        // Set up onClickListener for the category button
        holder.categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onCategoryItemClickListener != null) {
                    onCategoryItemClickListener.onCategoryClick(category);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        Button categoryButton;

        public CategoryViewHolder(View itemView) {
            super(itemView);
            categoryButton = itemView.findViewById(R.id.categorybutton);
        }
    }

    public interface OnCategoryItemClickListener {
        void onCategoryClick(String category);
    }
}
