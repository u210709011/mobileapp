package com.example.rcms;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EditEmployeeAdapter extends RecyclerView.Adapter<EditEmployeeAdapter.ViewHolder> {

    private Context context;
    private List<Employee> employeeList;

    public EditEmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_editemployee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Employee employee = employeeList.get(position);

        holder.nameTextView.setText(employee.getName());
        holder.idTextView.setText(employee.getID());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        TextView idTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.editemployeename);
            idTextView = itemView.findViewById(R.id.editemployeeid);

        }
    }
}
