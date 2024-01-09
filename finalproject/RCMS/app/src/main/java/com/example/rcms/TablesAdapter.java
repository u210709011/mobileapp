package com.example.rcms;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TablesAdapter extends RecyclerView.Adapter<TablesAdapter.TablesViewHolder> {

    private List<Table> tablesList;
    private TableClickListener tableClickListener;

    public TablesAdapter(List<Table> tablesList, TableClickListener tableClickListener) {
        this.tablesList = tablesList;
        this.tableClickListener = tableClickListener;
    }

    @NonNull
    @Override
    public TablesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_tablestableempty, parent, false);
        return new TablesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TablesViewHolder holder, int position) {
        Table table = tablesList.get(position);
        int tableNumber = table.getTableno();
        holder.tableButton.setText(String.valueOf(tableNumber));

        holder.tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tableClickListener != null) {
                    tableClickListener.onTableClick(table);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return tablesList.size();
    }

    public class TablesViewHolder extends RecyclerView.ViewHolder {

        Button tableButton;

        public TablesViewHolder(@NonNull View itemView) {
            super(itemView);
            tableButton = itemView.findViewById(R.id.tablestablebutton);
        }
    }

    public interface TableClickListener {
        void onTableClick(Table table);
    }
}
