package fr.polytech.cinemaRESTful.controllers.responses;

public class ErrorResponse extends AbstractResponse {

    public ErrorResponse() {
        this(null);
    }

    public ErrorResponse(Object data) {
        super(false, data);
    }
}