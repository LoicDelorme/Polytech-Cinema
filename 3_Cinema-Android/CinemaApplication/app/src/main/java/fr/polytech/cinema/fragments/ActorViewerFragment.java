package fr.polytech.cinema.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import fr.polytech.cinema.R;
import fr.polytech.cinema.entities.Actor;

public class ActorViewerFragment extends AbstractFragment {

    public static final String ACTOR_VIEWER_MESSAGE_KEY = "actor";

    public static final String DATE_FORMAT = "null";

    @Override
    public int getLayout() {
        return R.layout.fragment_actor_viewer;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final FragmentActivity activity = getActivity();
        final Actor actor = (Actor) getArguments().getSerializable(ACTOR_VIEWER_MESSAGE_KEY);

        ((TextView) activity.findViewById(R.id.identifier_text_view)).setText("" + actor.getId());
        ((TextView) activity.findViewById(R.id.lastname_text_view)).setText(actor.getLastname());
        ((TextView) activity.findViewById(R.id.firstname_text_view)).setText(actor.getFirstname());
        ((TextView) activity.findViewById(R.id.birth_date_text_view)).setText(actor.getBirthDate() == null ? DATE_FORMAT : actor.getBirthDate().substring(0, 10));
        ((TextView) activity.findViewById(R.id.date_of_death_text_view)).setText(actor.getDateOfDeath() == null ? DATE_FORMAT : actor.getDateOfDeath().substring(0, 10));
    }
}