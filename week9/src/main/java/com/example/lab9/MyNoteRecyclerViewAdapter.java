package com.example.lab9;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lab9.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.lab9.databinding.FragmentNoteBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
public class MyNoteRecyclerViewAdapter extends RecyclerView.Adapter<MyNoteRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Note> notes;
    private NoteFragment.OnNoteListInteractionListener listener;

    public MyNoteRecyclerViewAdapter(ArrayList<Note> notes, NoteFragment.OnNoteListInteractionListener listener) {
        this.notes = notes;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_note, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = notes.get(position);
        holder.mHeaderView.setText(notes.get(position).getHeader());
        holder.mDateView.setText(new SimpleDateFormat("yyyy-MM-dd").format(notes.get(position).getDate()));
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(null != listener) {
                    listener.onSelectedNote(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mHeaderView;
        public final TextView mDateView;
        public final View mView;
        public Note mItem;

        public ViewHolder(View view) {
            super(view);
            mHeaderView = view.findViewById(R.id.note_header);
            mDateView = view.findViewById(R.id.note_date);
            mView = view;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mHeaderView.getText() + "'";
        }
    }
}