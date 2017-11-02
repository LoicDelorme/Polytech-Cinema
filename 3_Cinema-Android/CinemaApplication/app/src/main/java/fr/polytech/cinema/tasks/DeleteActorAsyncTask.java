package fr.polytech.cinema.tasks;

import android.app.Activity;

import com.google.gson.reflect.TypeToken;

import fr.polytech.cinema.activities.IHome;
import fr.polytech.cinema.entities.Actor;
import fr.polytech.cinema.entities.Response;

public class DeleteActorAsyncTask extends AbstractAsyncTask<Object> {

    public static final String RESOURCE_URL = "actor/delete/%d";

    private final Actor actor;

    public DeleteActorAsyncTask(IHome home, Activity activity, Actor actor) {
        super(home, activity);
        this.actor = actor;
    }

    @Override
    protected Object doInBackground(String... params) {
        try {
            final Response<Object> response = this.restfulRequester.delete(String.format(RESOURCE_URL, this.actor.getId()), new TypeToken<Response<Object>>() {});
            if (response.isSuccess()) {
                return new Object();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Object object) {
        super.onPostExecute(object);

        if (object == null) {
            this.home.notifyFailureMessage("Failed to delete actor...");
        } else {
            this.home.notifySuccessfulMessage("Actor successfully deleted!");
        }
    }
}