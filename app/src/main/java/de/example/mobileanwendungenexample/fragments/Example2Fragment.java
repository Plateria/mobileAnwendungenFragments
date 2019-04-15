package de.example.mobileanwendungenexample.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import de.example.mobileanwendungenexample.R;
import de.example.mobileanwendungenexample.callbacks.InteractWithOtherFragmentCallback;


public class Example2Fragment extends Fragment {

    private static final String TAG = Example2Fragment.class.getSimpleName();

    private static final String ARGUMENT_COUNTER = "ARGUMENT_COUNTER";
    private int counter = 0;
    private InteractWithOtherFragmentCallback interactWithOtherFragmentCallback;

    @Override
    public void onAttach(Context context) {
        Log.d(TAG, "onAttach()");
        try {
            interactWithOtherFragmentCallback = (InteractWithOtherFragmentCallback) context;
        } catch (ClassCastException e) {
            Log.e(TAG, "Must implement callback first");
        }
        super.onAttach(context);
    }

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
        Log.d(TAG, "onCreateView()");
        return inflater.inflate(R.layout.fragment_example_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated()");
        ImageButton button = view.findViewById(R.id.button_counter);
        final TextView textView = view.findViewById(R.id.text_counter);
        textView.setText(String.valueOf(counter));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                textView.setText(String.valueOf(counter));
            }
        });
        ImageButton buttonReset = view.findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interactWithOtherFragmentCallback.interactWithOtherFragment();
            }
        });
    }

    @Override
    public void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView()");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }
}
