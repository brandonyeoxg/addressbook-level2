package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Formatter to help format messages to be displayed
 */
public class Formatter {
    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;   
    
    public static final String FORMATTED_ENTER_COMMAND_MESSAGE = LINE_PREFIX + "Enter command: ";
    
    /**
     * Formats the message into a proper message line to be displayed.
     * 
     * @param message Unformatted message to be displayed to users.
     * @return Formatted message line.
     */
    public static String formatMessageLine(String message){
        return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }

    /**
     * Formats the message into a welcome message.
     * 
     * @param version Version of the addressbook.
     * @param storageFilePath File Path of the storage file.
     * @return Formatted welcome message.
     */
    public static String[] formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return new String[] {DIVIDER,
                             DIVIDER,
                             MESSAGE_WELCOME,
                             version,
                             MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                             storageFileInfo,
                             DIVIDER};
    }

    /**
     * Formats the goodbye message.
     * 
     * @return Formatted goodbye message.
     */
    public static String[] formatGoodbyeMessage() {
        return new String[] {MESSAGE_GOODBYE, DIVIDER, DIVIDER};
    }

    /**
     * Formats failed initialisation message.
     * 
     * @return Formatted failed initialisation message.
     */
    public static String[] formatInitFailedMessage() {
        return new String[] {MESSAGE_INIT_FAILED, DIVIDER, DIVIDER};
    }
    
    /**
     * Formats a list of persons to be displayed.
     * 
     * @param Persons List of person in the addressbook.
     * @return Formatted person list to be displayed.
     */
    public static String formatPersonListView(List<? extends ReadOnlyPerson> persons) {
        final List<String> formattedPersons = new ArrayList<>();
        for (ReadOnlyPerson person : persons) {
            formattedPersons.add(person.getAsTextHidePrivate());
        }
        return formatIndexedListForViewing(formattedPersons);
    }      
    
    /**
     * Formats the command feedback to the user.
     * 
     * @param fullInputLine Command input of the user.
     * @return Formatted command input feedback.
     */
    public static String formatCommandFeedback(String fullInputLine) {
        return "[Command entered:" + fullInputLine + "]";
    }
    
    /**
     * Formats feedback result of command to users.
     * 
     * @param feedbackToUser Feedback message of command to be displayed to user.
     * @return Formatted feedback result of command message.
     */
    public static String[] formatResultToUser(String feedbackToUser) {
        return new String[] {feedbackToUser, DIVIDER};
    }    
    
    /**
     * Formats indexed list for a list of items.
     * 
     * @param listItems List of unformatted items.
     * @return Formatted list of item with a newline at the end.
     */
    private static String formatIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }

    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
}
