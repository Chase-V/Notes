package com.example.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class NotesFragment extends Fragment {

    private static String KEY_TITLE = "title";
    private static String KEY_DATE = "date";
    private static String KEY_TEXT = "text";

    public static NotesFragment newInstance() {
        return new NotesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notes_fragment, container, false);
        LinearLayout linearLayout = (LinearLayout) view;
        initViews(view);

        return view;
    }

    private void initViews(View view) {
        EditText editTitle = view.findViewById(R.id.title_note);
        EditText editDate = view.findViewById(R.id.date_note);
        EditText editText = view.findViewById(R.id.text_note);
    }
}
