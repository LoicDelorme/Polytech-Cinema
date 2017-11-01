package fr.polytech.cinema.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import fr.polytech.cinema.R;
import fr.polytech.cinema.activities.IHome;
import fr.polytech.cinema.entities.Actor;

public class ActorsArrayAdapter extends ArrayAdapter<Actor> implements View.OnClickListener {

    private final IHome home;

    private final List<Actor> actors;

    private final LayoutInflater layoutInflater;

    public ActorsArrayAdapter(IHome home, Context context, List<Actor> actors) {
        super(context, R.layout.adapter_actor, actors);

        this.actors = actors;
        this.home = home;
        this.layoutInflater = LayoutInflater.from(context);
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

        ((TextView) actorItemLayout.findViewById(R.id.actor_lastname_text_view)).setText(actor.getLastname());
        ((TextView) actorItemLayout.findViewById(R.id.actor_firstname_text_view)).setText(actor.getFirstname());

        actorItemLayout.findViewById(R.id.edit_actor_button).setOnClickListener(this);
        actorItemLayout.findViewById(R.id.delete_actor_button).setOnClickListener(this);
        actorItemLayout.setOnClickListener(this);

        actorItemLayout.findViewById(R.id.edit_actor_button).setTag(actor);
        actorItemLayout.findViewById(R.id.delete_actor_button).setTag(actor);
        actorItemLayout.setTag(actor);

        return actorItemLayout;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.edit_actor_button) {
            this.home.notifyEditActorButtonHasBeenPressed((Actor) view.getTag());
        } else if (view.getId() == R.id.delete_actor_button) {
            this.home.notifyDeleteActorButtonHasBeenPressed((Actor) view.getTag());
        } else {
            this.home.notifyActorHasBeenSelected((Actor) view.getTag());
        }
    }
}