package fr.polytech.cinema.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import fr.polytech.cinema.R;
import fr.polytech.cinema.entities.Actor;
import fr.polytech.cinema.fragments.ActorEditorFragment;
import fr.polytech.cinema.fragments.ActorFormFragment;
import fr.polytech.cinema.fragments.ActorViewerFragment;
import fr.polytech.cinema.fragments.HomeFragment;
import fr.polytech.cinema.tasks.DeleteActorAsyncTask;
import fr.polytech.cinema.tasks.GetAllActorsAsyncTask;
import fr.polytech.cinema.tasks.InsertActorAsyncTask;
import fr.polytech.cinema.tasks.UpdateActorAsyncTask;

public class MainActivity extends AppCompatActivity implements IHome {

    private static final int fragmentContainerId = R.id.fragment_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(fragmentContainerId) != null) {
            if (savedInstanceState == null) {
                addFragment(new HomeFragment(), getIntent().getExtras());
            }
        }
    }

    private void addFragment(Fragment fragment, Bundle extras) {
        fragment.setArguments(extras);

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(fragmentContainerId, fragment);
        transaction.commit();
    }

    private void replaceFragment(Fragment fragment, Bundle extras) {
        fragment.setArguments(extras);

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(fragmentContainerId, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void notifyWebServiceButtonHasBeenPressed() {
        final GetAllActorsAsyncTask asyncTask = new GetAllActorsAsyncTask(this, this);
        asyncTask.execute();
    }

    @Override
    public void notifyActorHasBeenSelected(Actor actor) {
        final Bundle extras = getIntent().getExtras() == null ? new Bundle() : getIntent().getExtras();
        extras.putSerializable(ActorViewerFragment.ACTOR_VIEWER_MESSAGE_KEY, actor);

        replaceFragment(new ActorViewerFragment(), extras);
    }

    @Override
    public void notifyAddActorButtonHasBeenPressed() {
        replaceFragment(new ActorFormFragment(), getIntent().getExtras());
    }

    @Override
    public void notifyEditActorButtonHasBeenPressed(Actor actor) {
        final Bundle extras = getIntent().getExtras() == null ? new Bundle() : getIntent().getExtras();
        extras.putSerializable(ActorEditorFragment.ACTOR_EDITOR_MESSAGE_KEY, actor);

        replaceFragment(new ActorEditorFragment(), extras);
    }

    @Override
    public void notifyDeleteActorButtonHasBeenPressed(Actor actor) {
        final DeleteActorAsyncTask asyncTask = new DeleteActorAsyncTask(this, this, actor);
        asyncTask.execute();
    }

    @Override
    public void notifyValidateActorFormButtonHasBeenPressed(Actor newActor) {
        final InsertActorAsyncTask asyncTask = new InsertActorAsyncTask(this, this, newActor);
        asyncTask.execute();
    }

    @Override
    public void notifyCancelActorFormButtonHasBeenPressed() {
        replaceFragment(new HomeFragment(), getIntent().getExtras());

        notifyWebServiceButtonHasBeenPressed();
    }

    @Override
    public void notifyValidateActorEditorButtonHasBeenPressed(Actor newActor) {
        final UpdateActorAsyncTask asyncTask = new UpdateActorAsyncTask(this, this, newActor);
        asyncTask.execute();
    }

    @Override
    public void notifyCancelActorEditorButtonHasBeenPressed() {
        replaceFragment(new HomeFragment(), getIntent().getExtras());

        notifyWebServiceButtonHasBeenPressed();
    }

    @Override
    public void notifySuccessfulMessage(String message) {
        replaceFragment(new HomeFragment(), getIntent().getExtras());

        notifyWebServiceButtonHasBeenPressed();

        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void notifyFailureMessage(String message) {
        replaceFragment(new HomeFragment(), getIntent().getExtras());

        notifyWebServiceButtonHasBeenPressed();

        Toast toast = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
        toast.show();
    }
}