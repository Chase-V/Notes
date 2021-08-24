package com.example.notes;

import android.view.ViewGroup;

import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class NotesListAdapter extends ListAdapter<Note, NoteViewHolder> {

    public NotesListAdapter(DiffUtil.ItemCallback<Note> diffCallback) {
        super(diffCallback);
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.list_notes_fragment;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return NoteViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        Note current = getItem(position);
        holder.bind(current.getTitle());
    }

    static class NoteDiff extends DiffUtil.ItemCallback<Note> {
        @Override
        public boolean areItemsTheSame(Note oldItem, Note newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(Note oldItem, Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }
}
