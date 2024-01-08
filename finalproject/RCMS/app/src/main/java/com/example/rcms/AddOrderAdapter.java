// AddOrderAdapter.java
package com.example.rcms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class AddOrderAdapter extends RecyclerView.Adapter<AddOrderAdapter.AddOrderViewHolder> {

    private List<OrderItem> menuItems;
    private ItemClickListener itemClickListener;

    public AddOrderAdapter(List<OrderItem> menuItems, ItemClickListener itemClickListener) {
        this.menuItems = menuItems;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public AddOrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_addorder, parent, false);
        return new AddOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AddOrderViewHolder holder, int position) {
        OrderItem menuItem = menuItems.get(position);
        holder.itemNameTextView.setText(menuItem.getOrderName());
        holder.itemPriceTextView.setText(String.valueOf(menuItem.getOrderPrice()));

        // Set click listener for the whole item view
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(position, menuItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuItems.size();
    }

    public void setMenuItems(List<OrderItem> menuItems) {
        this.menuItems = menuItems;
        notifyDataSetChanged();
    }

    public class AddOrderViewHolder extends RecyclerView.ViewHolder {

        TextView itemNameTextView;
        TextView itemPriceTextView;

        public AddOrderViewHolder(@NonNull View itemView) {
            super(itemView);
            itemNameTextView = itemView.findViewById(R.id.addordername);
            itemPriceTextView = itemView.findViewById(R.id.addorderprice);
        }
    }

    public interface ItemClickListener {
        void onItemClick(int position, OrderItem selectedItem);
    }
}
