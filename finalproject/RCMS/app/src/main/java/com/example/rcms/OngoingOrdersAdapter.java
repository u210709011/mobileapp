package com.example.rcms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OngoingOrdersAdapter extends RecyclerView.Adapter<OngoingOrdersAdapter.ViewHolder> {

    private Context context;
    private List<OrderItem> ongoingOrderItems;
    private ArrayList<OrderItem> deletedItems;

    public OngoingOrdersAdapter(Context context, List<OrderItem> ongoingOrderItems) {
        this.context = context;
        this.ongoingOrderItems = ongoingOrderItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_ongoingorders, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        OrderItem ongoingOrderItem = ongoingOrderItems.get(position);
        holder.ongoingOrderNameTextView.setText(ongoingOrderItem.getOrderName());
        holder.ongoingOrderPriceTextView.setText(ongoingOrderItem.getOrderPrice() + "TL");
        holder.ongoingOrderQuantityTextView.setText("x" + ongoingOrderItem.getOrderQuantity());
        holder.ongoingOrderOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo
            }
        });
    }

    @Override
    public int getItemCount() {
        return ongoingOrderItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ongoingOrderNameTextView;
        TextView ongoingOrderPriceTextView;
        TextView ongoingOrderQuantityTextView;
        ImageButton ongoingOrderOkButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ongoingOrderNameTextView = itemView.findViewById(R.id.ongoingordername);
            ongoingOrderPriceTextView = itemView.findViewById(R.id.ongoingorderprice);
            ongoingOrderQuantityTextView = itemView.findViewById(R.id.ongoingorderquantity);
            ongoingOrderOkButton = itemView.findViewById(R.id.ongoingorderokbutton);

        }
    }
}
