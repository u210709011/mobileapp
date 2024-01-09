package com.example.rcms;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Tables extends AppCompatActivity implements TablesAdapter.TableClickListener {

    private RecyclerView recyclerView;
    private TablesAdapter tablesAdapter;
    private List<Table> tableList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tables);

        Log.d("Tables:", "table is on");

        recyclerView = findViewById(R.id.recyclerViewTables);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        tableList = createTables();
        tablesAdapter = new TablesAdapter(tableList, this);
        recyclerView.setAdapter(tablesAdapter);
    }

    private List<Table> createTables() {
        List<Table> tables = new ArrayList<>();
        tables.add(new Table(1, 0, new ArrayList<>(), false));
        tables.add(new Table(2, 8, new ArrayList<>(), false));
        tables.add(new Table(3, 0, new ArrayList<>(), false));
        tables.add(new Table(4, 0, new ArrayList<>(), false));
        tables.add(new Table(5, 0, new ArrayList<>(), false));
        tables.add(new Table(6, 0, new ArrayList<>(), false));
        tables.add(new Table(8, 0, new ArrayList<>(), false));
        tables.add(new Table(9, 0, new ArrayList<>(), false));
        tables.add(new Table(10, 0, new ArrayList<>(), false));
        tables.add(new Table(11, 0, new ArrayList<>(), false));
        tables.add(new Table(12, 0, new ArrayList<>(), false));

        return tables;
    }

    @Override
    public void onTableClick(Table table) {
        navigateToCustomerTable(table);
    }

    private void navigateToCustomerTable(Table table) {
        Intent intent = new Intent(Tables.this, CustomerTable.class);
        intent.putExtra("TABLE_OBJECT", table);
        startActivity(intent);
    }
}
