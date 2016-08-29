package seedu.addressbook.data.address;

/**
 * Represents the postal code component of a person's address.
 */
public class PostalCode implements AddressComponent<Integer> {
    private Integer code_;
    
    public PostalCode(Integer code) {
        code_ = code;
    }
    
    public Integer getValue() {
        return code_;
    }
}
