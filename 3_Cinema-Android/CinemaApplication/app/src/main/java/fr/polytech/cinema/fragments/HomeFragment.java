package fr.polytech.cinema.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;

import fr.polytech.cinema.activities.IHome;
import fr.polytech.cinema.R;

public class HomeFragment extends AbstractFragment implements View.OnClickListener {

    private IHome home;

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            this.home = (IHome) context;
        } catch (ClassCastException ex) {
            Log.e("HomeFragment", "ClassCastException", ex);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        final FragmentActivity activity = getActivity();
        activity.findViewById(R.id.web_services_button).setOnClickListener(this);
        activity.findViewById(R.id.add_actor_button).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.web_services_button) {
            this.home.notifyWebServiceButtonHasBeenPressed();
        } else if (view.getId() == R.id.add_actor_button) {
            this.home.notifyAddActorButtonHasBeenPressed();
        }
    }
}