package seedu.parser;

import seedu.command.Command;
import seedu.command.ExitCommand;
import seedu.command.InvalidCommand;
import seedu.command.SearchCommand;
import seedu.command.ShowCommand;
import seedu.command.UpdateCommand;
import seedu.command.AddCommand;
import seedu.command.TimetableCommand;
import seedu.duke.Duke;

public class CommandParser {
    private static final Integer SEARCH_LENGTH = 6;
    private static final Integer SHOW_LENGTH = 4;
    private static final Integer ADD_LENGTH = 3;

    public Command parseCommand(String text) {
        Command command;
        text = text.trim();
        String lowerCaseText = text.toLowerCase();

        if (text.equalsIgnoreCase("exit")) {
            command = new ExitCommand();
        } else if (lowerCaseText.startsWith("update")) {
            command = new UpdateCommand();
        } else if (lowerCaseText.startsWith("search")) {
            command = parseSearchCommand(text);
        } else if (lowerCaseText.startsWith("show")) {
            command = parseShowCommand(text);
        } else if (lowerCaseText.startsWith("timetable")) {
            command = new TimetableCommand(Duke.timetable);
        } else if (lowerCaseText.startsWith("add")) {
            command = parseAddCommand(text);
        } else {
            command = new InvalidCommand();
        }
        return command;
    }

    public Command parseSearchCommand(String text) {
        String str = text.substring(SEARCH_LENGTH).trim();
        return new SearchCommand(str);
    }

    public Command parseShowCommand(String text) {
        String str = text.substring(SHOW_LENGTH).trim();
        return new ShowCommand(str);
    }

    public Command parseAddCommand(String input) {
        input = input.substring(ADD_LENGTH).trim();
        String moduleCode = input.toUpperCase();
        return new AddCommand(moduleCode);
    }
}