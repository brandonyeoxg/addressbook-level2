package seedu.addressbook.data.address;

/**
 * Represents the street component of a person's address.
 */
public class Street implements AddressComponent<String> {
    private String name_;
    
    public Street(String name){
        name_ = name;
    }

    public String getValue() {
        return name_;
    }

}
