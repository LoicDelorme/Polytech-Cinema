package fr.polytech.cinema.tasks;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.ListView;

import java.util.List;

import fr.polytech.cinema.adapters.ActorArrayAdapter;
import fr.polytech.cinema.cinemaapplication.R;
import fr.polytech.cinema.entities.Actor;
import fr.polytech.cinema.restful.IRestfulRequester;
import fr.polytech.cinema.restful.JsonRestfulRequester;

public class WebServiceASyncTask extends AsyncTask<String, Integer, List<Actor>> {

    private final Activity activity;

    private final IRestfulRequester requester;

    public WebServiceASyncTask(Activity activity) {
        this.activity = activity;
        this.requester = new JsonRestfulRequester("localhost:8080/api/");
    }

    @Override
    protected List<Actor> doInBackground(String... params) {
        List<Actor> actors = this.requester.get("actors/list", List.class);
        return actors;
    }

    @Override
    protected void onPostExecute(List<Actor> actors) {
        super.onPostExecute(actors);

        final ActorArrayAdapter actorArrayAdapter = new ActorArrayAdapter(this.activity.getApplicationContext(), R.layout.adapter_actor, actors);

        final ListView actorsListView = (ListView) activity.findViewById(R.id.web_services_list_view);
        actorsListView.setAdapter(actorArrayAdapter);
    }
}