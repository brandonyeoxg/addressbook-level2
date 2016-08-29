package seedu.addressbook.data.address;

/**
 * Represents the template to which each address component must follow.
 * @param <T> Allow for more than one type of address component.
 */
public interface AddressComponent <T> {
    public abstract T getValue();
}
