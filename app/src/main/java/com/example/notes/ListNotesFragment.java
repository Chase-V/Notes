package com.example.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ListNotesFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotesViewModel mNotesViewModel;
    private static String KEY_TITLE = "title";
    private static String KEY_DATE = "date";
    private static String KEY_TEXT = "text";
    Bundle bundle;

    private FloatingActionButton buttonAdd;


    public static ListNotesFragment newInstance() {
        return new ListNotesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_notes_fragment, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        final NotesListAdapter adapter = new NotesListAdapter(new NotesListAdapter.NoteDiff());
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(adapter);

        mNotesViewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        mNotesViewModel.getAllNotes().observe(getViewLifecycleOwner(), notes -> {
            adapter.submitList(notes);
        });


            Note note = new Note("sadasda", "23123xasd", "2.2.2020");
            Note note2 = new Note("sadas213da", "231asdx23xasd", "2.12.2020");
            mNotesViewModel.insert(note);


        buttonAdd = view.findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(v -> {
            showNotesPortrait();
        });

        return view;
    }

    private void showNotesPortrait() {
        requireActivity()
                .getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.notes_container, NotesFragment.newInstance())
                .addToBackStack("")
                .commit();
    }
}
