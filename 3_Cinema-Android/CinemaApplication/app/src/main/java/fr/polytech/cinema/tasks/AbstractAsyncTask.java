package fr.polytech.cinema.tasks;

import android.app.Activity;
import android.os.AsyncTask;

import fr.polytech.cinema.activities.IHome;
import fr.polytech.cinema.restful.JsonRestfulRequester;
import fr.polytech.cinema.restful.RestfulRequester;

public abstract class AbstractAsyncTask<T> extends AsyncTask<String, Integer, T> {

    public static final String API_URL = "http://10.0.2.2:8090/api/";

    protected final RestfulRequester restfulRequester;

    protected final IHome home;

    protected final Activity activity;

    public AbstractAsyncTask(IHome home, Activity activity) {
        this.restfulRequester = new JsonRestfulRequester(API_URL, activity.getApplicationContext());
        this.home = home;
        this.activity = activity;
    }
}