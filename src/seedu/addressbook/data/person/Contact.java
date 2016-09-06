package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a template of a Person's contact in the addressbook
 */
public abstract class Contact {
    private final String value;
    private boolean isPrivate;
    
    public Contact(String address, String regex, String messageConstraints, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValid(address,regex)) {
            throw new IllegalValueException(messageConstraints);
        }
        value = address;
    }
    
    /**
     * Checks if the string is valid or not based on the regex.
     * 
     * @param test Input string to be tested, should not be null.
     * @param regex Used to check if the test string is valid.
     * @return True if it is valid, else false.
     */
    public static boolean isValid(String test, String regex) {
        return test.matches(regex);
    }
    
    public String toString() {
        return value;
    }
 
    @Override
    public int hashCode() {
        return value.hashCode();
    }


    public boolean isPrivate() {
        return isPrivate;
    }
}
