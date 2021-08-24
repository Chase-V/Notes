package com.example.notes;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesViewModel extends AndroidViewModel {

    private NotesRepository mRepository;
    private final LiveData<List<Note>> mAllNotes;

    public NotesViewModel(Application application) {
        super(application);
        mRepository = new NotesRepository(application);
        mAllNotes = mRepository.getAllNotes();
    }

    LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    public void insert(Note note) {
        mRepository.insert(note);
    }

}
