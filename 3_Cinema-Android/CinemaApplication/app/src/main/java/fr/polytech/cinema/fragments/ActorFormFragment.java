package fr.polytech.cinema.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import fr.polytech.cinema.R;
import fr.polytech.cinema.activities.IHome;
import fr.polytech.cinema.entities.Actor;

public class ActorFormFragment extends AbstractFragment implements View.OnClickListener {

    public static final String DATE_FORMAT = "yyyy-MM-dd";

    private IHome home;

    @Override
    public int getLayout() {
        return R.layout.fragment_actor_form;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            this.home = (IHome) context;
        } catch (ClassCastException ex) {
            Log.e("ActorFormFragment", "ClassCastException", ex);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final FragmentActivity activity = getActivity();
        ((EditText) activity.findViewById(R.id.birth_date_edit_text)).setText(DATE_FORMAT);
        ((EditText) activity.findViewById(R.id.date_of_death_edit_text)).setText(DATE_FORMAT);

        activity.findViewById(R.id.validate_actor_form_button).setOnClickListener(this);
        activity.findViewById(R.id.cancel_actor_form_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.validate_actor_form_button) {
            try {
                final FragmentActivity activity = getActivity();

                final String lastname = ((EditText) activity.findViewById(R.id.lastname_edit_text)).getText().toString();
                final String firstname = ((EditText) activity.findViewById(R.id.firstname_edit_text)).getText().toString();
                final String birthDate = ((EditText) activity.findViewById(R.id.birth_date_edit_text)).getText().toString();
                final String dateOfDeath = ((EditText) activity.findViewById(R.id.date_of_death_edit_text)).getText().toString();

                final Actor newActor = new Actor();
                newActor.setLastname(lastname);
                newActor.setFirstname(firstname);
                newActor.setBirthDate(birthDate.isEmpty() || birthDate.equals(DATE_FORMAT) ? null : formatDate(birthDate));
                newActor.setDateOfDeath(dateOfDeath.isEmpty() || dateOfDeath.equals(DATE_FORMAT) ? null : formatDate(dateOfDeath));

                this.home.notifyValidateActorFormButtonHasBeenPressed(newActor);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (view.getId() == R.id.cancel_actor_form_button) {
            this.home.notifyCancelActorFormButtonHasBeenPressed();
        }
    }

    private String formatDate(String initialDate) throws ParseException {
        final SimpleDateFormat fromDateFormat = new SimpleDateFormat(DATE_FORMAT);
        final SimpleDateFormat toDateFormat = new SimpleDateFormat("dd-MM-yyyy");

        return toDateFormat.format(fromDateFormat.parse(initialDate));
    }
}