package com.example.notes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatButton;
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

    @SuppressLint("NewApi")
    private void initViews(View view) {
        EditText editTitle = view.findViewById(R.id.title_note);
        EditText editDate = view.findViewById(R.id.date_note);
        EditText editText = view.findViewById(R.id.text_note);
        DatePicker datePicker = view.findViewById(R.id.date_picker_note);
        AppCompatButton buttonSave = view.findViewById(R.id.button_save);
        Bundle bundle = new Bundle();

        buttonSave.setOnClickListener(v -> {
            if (TextUtils.isEmpty(editText.getText())) {
                Toast.makeText(getContext(), "Заметка пустая, нечего сохранять", Toast.LENGTH_SHORT).show();
            } else {
                if (!TextUtils.isEmpty(editText.getText())) bundle.putString(KEY_TEXT, editText.getText().toString());
                if (!TextUtils.isEmpty(editTitle.getText())) bundle.putString(KEY_TITLE, editTitle.getText().toString());
                if (!TextUtils.isEmpty(editDate.getText())) bundle.putString(KEY_DATE, editDate.getText().toString());
            }
            requireActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.notes_container, ListNotesFragment.newInstance())
                    .commit();
        });

        editDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePicker.setVisibility(View.VISIBLE);
            }
        });

        datePicker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                editDate.setText(dayOfMonth + "." + (monthOfYear + 1) + "." + year);
            }
        });

        editDate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                datePicker.setVisibility(View.GONE);

            }
        });

    }
}
