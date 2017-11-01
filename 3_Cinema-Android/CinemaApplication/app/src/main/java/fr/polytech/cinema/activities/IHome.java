package fr.polytech.cinema.activities;

import fr.polytech.cinema.entities.Actor;

public interface IHome {

    public void notifyWebServiceButtonHasBeenPressed();

    public void notifyActorHasBeenSelected(Actor actor);

    public void notifyAddActorButtonHasBeenPressed();

    public void notifyEditActorButtonHasBeenPressed(Actor actor);

    public void notifyDeleteActorButtonHasBeenPressed(Actor actor);

    public void notifyValidateActorFormButtonHasBeenPressed(Actor newActor);

    public void notifyCancelActorFormButtonHasBeenPressed();

    public void notifyValidateActorEditorButtonHasBeenPressed(Actor newActor);

    public void notifyCancelActorEditorButtonHasBeenPressed();

    public void notifySuccessfulMessage(String message);

    public void notifyFailureMessage(String message);
}