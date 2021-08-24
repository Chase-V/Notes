package com.example.notes;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NotesRepository {

    private NoteDao mNoteDao;
    private LiveData<List<Note>> mAllNotes;

    NotesRepository(Application application) {
        NotesRoomDatabase db = NotesRoomDatabase.getDatabase(application);
        mNoteDao = db.noteDao();
        mAllNotes = mNoteDao.getASCdatedNotes();
    }

    LiveData<List<Note>> getAllNotes() {
        return mAllNotes;
    }

    void insert(Note note) {
        NotesRoomDatabase.databaseWriteExecutor.execute(() ->{
            mNoteDao.insert(note);
        });
    }

}
