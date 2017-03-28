package edu.mit.dig.ama.core;

/**
 * Interface which enforces a JSON representation of the class
 * @author Aaron Vontell
 */
public interface JsonRep {

    /**
     * Returns a string of valid JSON representing this object
     * @return a string of valid JSON representing this object
     */
    String getJSON();

    /**
     * Returns the object as interpreted from the given JSON
     * @param json The string representation restored from memory
     * @return the object as interpreted from the given JSON
     */
    JsonRep instFromJson(String json);

}
