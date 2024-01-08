package com.example.rcms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class EditMenuAdapter extends RecyclerView.Adapter<EditMenuAdapter.MenuItemViewHolder> {

    private List<OrderItem> menuItems;
    private Context context;

    public EditMenuAdapter(List<OrderItem> menuItems, Context context) {
        this.menuItems = menuItems;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View menuItemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_editmenu, parent, false);
        return new MenuItemViewHolder(menuItemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuItemViewHolder holder, int position) {
        OrderItem menuItem = menuItems.get(position);
        holder.menuItemNameEditText.setText(menuItem.getOrderName());
        holder.menuItemPriceEditText.setText(String.valueOf(menuItem.getOrderPrice()));

        // Add any other binding logic here
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder {
        TextView menuItemNameEditText;
        TextView menuItemPriceEditText;

        MenuItemViewHolder(View itemView) {
            super(itemView);
            menuItemNameEditText = itemView.findViewById(R.id.editmenuitemname);
            menuItemPriceEditText = itemView.findViewById(R.id.editmenuitemprice);
        }
    }

    public void setMenuItems(List<OrderItem> menuItems) {
        this.menuItems = menuItems;
        notifyDataSetChanged();
    }

    public void setGridLayout(RecyclerView recyclerView, int spanCount) {
        GridLayoutManager layoutManager = new GridLayoutManager(context, spanCount);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void setMenuCategory(String category) {
        ArrayList<OrderItem> itemsBasedOnCategory = new ArrayList<>();
        for (OrderItem item : menuItems) {
            if (item.getOrderType().equals(category)) {
                itemsBasedOnCategory.add(item);
            }
        }

        this.menuItems = itemsBasedOnCategory;
        notifyDataSetChanged();
    }
}
