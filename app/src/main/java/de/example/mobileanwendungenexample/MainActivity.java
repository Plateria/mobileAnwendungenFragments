package de.example.mobileanwendungenexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import de.example.mobileanwendungenexample.callbacks.InteractWithOtherFragmentCallback;
import de.example.mobileanwendungenexample.fragments.Example2Fragment;
import de.example.mobileanwendungenexample.fragments.ExampleFragment;

public class MainActivity extends AppCompatActivity implements InteractWithOtherFragmentCallback {

    private static final String TAG_FRAGMENT_FIRST = "TAG_FRAGMENT_FIRST";
    private static final String TAG_FRAGMENT_SECOND = "TAG_FRAGMENT_SECOND";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Example2Fragment fragment2 = (Example2Fragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_SECOND);
        if (fragment2 == null) {
            fragment2 = new Example2Fragment();
        }
        ExampleFragment fragment = (ExampleFragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_FIRST);
        if (fragment == null) {
            fragment = new ExampleFragment();
        }
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container_main, fragment, TAG_FRAGMENT_FIRST)
                .replace(R.id.container_details, fragment2, TAG_FRAGMENT_SECOND)
                .commit();
    }


    @Override
    public void interactWithOtherFragment() {
        ExampleFragment fragment = (ExampleFragment) getSupportFragmentManager().findFragmentByTag(TAG_FRAGMENT_FIRST);
        if (fragment != null) {
            fragment.addCounter();
        }
    }
}
