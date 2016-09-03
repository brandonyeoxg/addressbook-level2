package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

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
