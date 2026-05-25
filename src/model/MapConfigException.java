package model;

// Custom checked exception for map related errors

public class MapConfigException extends Exception {

    public MapConfigException(String message){
        super(message);
    }
}
