package de.example.mobileanwendungenexample.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import de.example.mobileanwendungenexample.R;


public class ExampleFragment extends Fragment {

    private static final String TAG = ExampleFragment.class.getSimpleName();

    private static final String ARGUMENT_COUNTER = "ARGUMENT_COUNTER";

    private TextView textView;
    private int counter = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(ARGUMENT_COUNTER);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARGUMENT_COUNTER, counter);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        textView = view.findViewById(R.id.text_counter);
        textView.setText(String.valueOf(counter));
    }

    public void addCounter() {
        textView.setText(String.valueOf(++counter));
    }
}
