package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
    private static final String TAG_DELETE_SYMBOL = "-";
    private static final String TAG_ADD_SYMBOL = "+";
    private final Person person;
    private final Tag tag;
    private final TagType tagType;

    public Tagging(Person person, Tag tag, TagType tagType) {
        this.person = person;
        this.tag = tag;
        this.tagType = tagType;
    }

    public String toString() {
        return tagTypeFormat() + " " + person.getName() + " " + tag.tagName;
    }

    private String tagTypeFormat(){
        String output = "";
        switch (tagType) {
        case ADD:
            output = TAG_ADD_SYMBOL;
            break;
        case DELETE:
            output = TAG_DELETE_SYMBOL;
            break;
        }
        return output;
    }
}
