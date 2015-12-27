package com.ataulm.findviewbyrx;

public class CouldNotFindViewException extends IllegalStateException {

    public CouldNotFindViewException(int id) {
        super("Couldn't find view with id: " + id + ", did you remember to declare it?");
    }

}
