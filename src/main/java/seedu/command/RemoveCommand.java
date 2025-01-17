package seedu.command;

import seedu.duke.Duke;
import seedu.exceptions.FetchException;
import seedu.exceptions.UniModsException;
import seedu.module.Module;
import seedu.online.NusMods;
import seedu.ui.TextUi;
import seedu.user.Profile;


public class RemoveCommand extends Command {
    private final String moduleToBeRemoved;

    public RemoveCommand(String moduleToBeRemoved) {
        this.moduleToBeRemoved = moduleToBeRemoved;
    }

    public void execute() {
        Module module;
        try {
            module = NusMods.fetchModOnline(moduleToBeRemoved);
            Profile currentProfile = Duke.getProfileInUse();
            currentProfile.getRecord().removeModuleFromTranscript(moduleToBeRemoved);
        } catch (FetchException e) {
            System.out.println(TextUi.ERROR_INVALID_MODULE_CODE);
        } catch (UniModsException e) {
            System.out.println(e.getMessage());
        }
    }
}
