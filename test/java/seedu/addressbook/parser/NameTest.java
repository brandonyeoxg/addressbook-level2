package seedu.addressbook.parser;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Name;

public class NameTest {
    
    private static final String ORIGINAL_NAME = "John K Doe";

    @Test
    public void testIsExactName() throws IllegalValueException {
        Name name = new Name(ORIGINAL_NAME);
        Name other= new Name(ORIGINAL_NAME);
        assertTrue(name.isSimilar(other));
    }

}
