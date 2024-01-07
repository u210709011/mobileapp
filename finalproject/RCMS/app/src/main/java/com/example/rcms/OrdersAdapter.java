package com.example.rcms;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    private Context context;
    private List<OrderItem> orderItems;

    public OrdersAdapter(Context context, List<OrderItem> orderItems) {
        this.context = context;
        this.orderItems = orderItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("ORDERS ADAPTER", "ONCREATEVIEWHOLDER IS ACTIVE");
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_orders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderItem orderItem = orderItems.get(position);
        holder.orderNameTextView.setText(orderItem.getOrderName());
        holder.orderPriceTextView.setText(orderItem.getOrderPrice() + "TL");
        holder.orderQuantityTextView.setText("x" + orderItem.getOrderQuantity());
        Log.d("asda", "dasdasda");
    }

    @Override
    public int getItemCount() {
        return orderItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderNameTextView;
        TextView orderPriceTextView;
        TextView orderQuantityTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            orderNameTextView = itemView.findViewById(R.id.ordername);
            orderPriceTextView = itemView.findViewById(R.id.orderprice);
            orderQuantityTextView = itemView.findViewById(R.id.orderquantity);
        }
    }
}
