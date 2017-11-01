package fr.polytech.cinema.tasks;

import android.app.Activity;

import com.google.gson.reflect.TypeToken;

import fr.polytech.cinema.activities.IHome;
import fr.polytech.cinema.entities.Actor;
import fr.polytech.cinema.entities.Response;

public class UpdateActorAsyncTask extends AbstractAsyncTask<Actor> {

    public static final String RESOURCE_URL = "actor/update";

    private final Actor actor;

    public UpdateActorAsyncTask(IHome home, Activity activity, Actor actor) {
        super(home, activity);
        this.actor = actor;
    }

    @Override
    protected Actor doInBackground(String... params) {
        try {
            final Response<Actor> response = this.restfulRequester.put(RESOURCE_URL, actor, new TypeToken<Response<Actor>>() {
            });
            if (response.isSuccess()) {
                return response.getData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Actor actor) {
        super.onPostExecute(actor);

        if (actor == null) {
            this.home.notifyFailureMessage("Failed to update actor...");
        } else {
            this.home.notifySuccessfulMessage("Actor successfully updated!");
        }
    }
}