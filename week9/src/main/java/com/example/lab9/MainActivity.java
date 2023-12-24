package com.example.lab9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NoteFragment.OnNoteListInteractionListener {

    boolean displayingEditor = false;
    Note editingNote;
    ArrayList<Note> notes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notes = retrieveNotes();
        if(!displayingEditor) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.container, NoteFragment.newInstance(notes));
            fragmentTransaction.commit();
        }
        else {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, EditNoteFragment.newInstance(readContent(editingNote)));
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);

    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private String readContent(Note note) {
        Log.d("Reading Note with path",note.getFilePath());
        StringBuffer content = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(new
                File(note.getFilePath())))) {
            String line;
            while ((line = reader.readLine()) != null){
                content.append(line).append("\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }


    private ArrayList<Note> retrieveNotes() {

    }

    @Override
    public void onSelectedNote(Note note) {
        editingNote =note;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        ft.replace(R.id.container,EditNoteFragment.newInstance(editingNote.getContent()),"edit
                _note");
                ft.addToBackStack(null);
        ft.commit();
        displayingEditor = !displayingEditor;
        invalidateOptionsMenu();
    }
}