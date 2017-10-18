package fr.polytech.cinema.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import fr.polytech.cinema.cinemaapplication.R;
import fr.polytech.cinema.fragments.HomeFragment;
import fr.polytech.cinema.tasks.WebServiceASyncTask;

public class MainActivity extends AppCompatActivity implements IHome {

    private static final int fragmentContainerId = R.id.fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(fragmentContainerId) != null) {
            if (savedInstanceState == null) {
                final HomeFragment homeFragment = new HomeFragment();
                homeFragment.setArguments(getIntent().getExtras());

                final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(fragmentContainerId, homeFragment);
                transaction.commit();
            }
        }
    }

    @Override
    public void notifyWebServiceButtonHasBeenPressed() {
        new WebServiceASyncTask(this).execute();
        //final Toast toast = Toast.makeText(getApplicationContext(), "Button pressed!", Toast.LENGTH_SHORT);
        //toast.show();
    }
}