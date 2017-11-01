package fr.polytech.cinema.tasks;

import android.app.Activity;
import android.widget.ListView;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import fr.polytech.cinema.R;
import fr.polytech.cinema.activities.IHome;
import fr.polytech.cinema.adapters.ActorsArrayAdapter;
import fr.polytech.cinema.entities.Actor;
import fr.polytech.cinema.entities.Response;

public class GetAllActorsAsyncTask extends AbstractAsyncTask<List<Actor>> {

    public static final String RESOURCE_URL = "actor/list";

    public GetAllActorsAsyncTask(IHome home, Activity activity) {
        super(home, activity);
    }

    @Override
    protected List<Actor> doInBackground(String... params) {
        try {
            final Response<ArrayList<Actor>> response = this.restfulRequester.get(RESOURCE_URL, new TypeToken<Response<ArrayList<Actor>>>() {
            });
            if (response.isSuccess()) {
                return response.getData();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ArrayList<Actor>();
    }

    @Override
    protected void onPostExecute(List<Actor> actors) {
        super.onPostExecute(actors);

        if (actors.isEmpty()) {
            this.home.notifyFailureMessage("Failed to recover all actors...");
        } else {
            ((ListView) this.activity.findViewById(R.id.actors_list_view)).setAdapter(new ActorsArrayAdapter(this.home, this.activity.getApplicationContext(), actors));
        }
    }
}