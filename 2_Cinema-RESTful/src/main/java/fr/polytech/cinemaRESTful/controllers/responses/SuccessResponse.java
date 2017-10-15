package fr.polytech.cinemaRESTful.controllers.responses;

public class SuccessResponse extends AbstractResponse {

    public SuccessResponse() {
        this(null);
    }

    public SuccessResponse(Object data) {
        super(true, data);
    }
}