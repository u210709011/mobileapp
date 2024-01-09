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
    private OnEmployeeClickListener onEmployeeClickListener;

    public EditEmployeeAdapter(Context context, List<Employee> employeeList, OnEmployeeClickListener onEmployeeClickListener) {
        this.context = context;
        this.employeeList = employeeList;
        this.onEmployeeClickListener = onEmployeeClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_editemployee, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onEmployeeClickListener != null) {
                    onEmployeeClickListener.onEmployeeClick(viewHolder.getAdapterPosition());
                }
            }
        });
        return viewHolder;
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
        public void onClick(View v) {
            if (onEmployeeClickListener != null) {
                onEmployeeClickListener.onEmployeeClick(getAdapterPosition());
            }
        }
    }

    public interface OnEmployeeClickListener {
        void onEmployeeClick(int position);
    }
}
