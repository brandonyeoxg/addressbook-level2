package seedu.addressbook.data.person;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.addressbook.data.address.Block;
import seedu.addressbook.data.address.PostalCode;
import seedu.addressbook.data.address.Street;
import seedu.addressbook.data.address.Unit;
import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Address is in the form a/BLOCK, STREET, UNIT, POSTAL_CODE
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, some street";
    
    private static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the format a/BLOCK, STREET, UNIT, POSTAL_CODE";
    private static final String ADDRESS_VALIDATION_REGEX = "(.+), (.+), (.+), (.+)";
    private static final String ADDRESS_COMPONENT_SPACING = ", ";
    
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;
    
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        obtainAddressComponents(address);
    }

    /**
     * Assigns the address components to the appropriate address classes.
     * 
     * @param address Person's full address in the form a/BLOCK, STREET, UNIT, POSTAL_CODE.
     */
    private void obtainAddressComponents(String address) throws IllegalValueException {
        Pattern regexPattern = Pattern.compile(ADDRESS_VALIDATION_REGEX);
        Matcher matchingPattern = regexPattern.matcher(address);
        
        if (matchingPattern.find()){
            String blockComponent = matchingPattern.group(1).trim();
            String streetComponent = matchingPattern.group(2).trim();
            String unitComponent = matchingPattern.group(3).trim();
            String postalCodeComponent = matchingPattern.group(4).trim();
            
            block = new Block(Integer.parseInt(blockComponent));
            street = new Street(streetComponent);
            unit  = new Unit(unitComponent);
            postalCode = new PostalCode(Integer.parseInt(postalCodeComponent));
        }else{
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
    }

    /**
     * Returns true if a given string is a valid address of the form a/BLOCK, STREET, UNIT, POSTAL_CODE.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.getValue().toString() + ADDRESS_COMPONENT_SPACING + street.getValue() + ADDRESS_COMPONENT_SPACING 
                + unit.getValue() + ADDRESS_COMPONENT_SPACING + postalCode.getValue();
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.toString().equals(((Address) other).toString())); // state check
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}