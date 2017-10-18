package fr.polytech.cinema.adapters;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fr.polytech.cinema.cinemaapplication.R;
import fr.polytech.cinema.entities.Actor;

public class ActorArrayAdapter extends ArrayAdapter<Actor> {

    private final List<Actor> actors;

    private final LayoutInflater layoutInflater;

    private final Context context;

    public ActorArrayAdapter(Context context, int textViewResourceId, List<Actor> actors) {
        super(context, textViewResourceId, actors);

        this.actors = actors;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.actors.size();
    }

    @Nullable
    @Override
    public Actor getItem(int position) {
        return this.actors.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Actor actor = getItem(position);
        final LinearLayout actorItemLayout = (LinearLayout) this.layoutInflater.inflate(R.layout.adapter_actor, parent, false);

        final TextView lastnameTextView = (TextView) actorItemLayout.findViewById(R.id.actor_lastname_text_view);
        lastnameTextView.setText(actor.getLastname());

        final TextView firstnameTextView = (TextView) actorItemLayout.findViewById(R.id.actor_firstname_text_view);
        firstnameTextView.setText(actor.getFirstname());

        return actorItemLayout;
    }
}