package com.example.rcms;// ShoppingCartAdapter.java

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.CartViewHolder> {

    private List<OrderItem> cartItems;

    public ShoppingCartAdapter(List<OrderItem> cartItems) {
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_shoppingcart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        OrderItem item = cartItems.get(position);
        holder.itemNameTextView.setText(item.getOrderName());
        holder.itemPriceTextView.setText(String.valueOf(item.getOrderPrice()));
        holder.itemQuantityTextView.setText(String.valueOf(item.getOrderQuantity()));

        // Implement increment button click
        holder.incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.incrementQuantity();
                notifyDataSetChanged();
            }
        });

        // Implement decrement button click
        holder.decrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.decrementQuantity();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    static class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView itemImageView;
        TextView itemNameTextView;
        TextView itemPriceTextView;
        TextView itemQuantityTextView;
        Button incrementButton;
        Button decrementButton;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImageView = itemView.findViewById(R.id.shoppingcartimage);
            itemNameTextView = itemView.findViewById(R.id.shoppingcartname);
            itemPriceTextView = itemView.findViewById(R.id.shoppingcartprice);
            itemQuantityTextView = itemView.findViewById(R.id.shoppingcartquantity);
            incrementButton = itemView.findViewById(R.id.shoppingcartincrement);
            decrementButton = itemView.findViewById(R.id.shoppingcartdecrement);
        }
    }
}
