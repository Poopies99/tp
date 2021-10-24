package seedu.module;

import com.google.gson.annotations.JsonAdapter;
import seedu.command.flags.SearchFlags;
import seedu.exceptions.UniModsException;
import seedu.online.PrerequisiteTreeAdapterFactory;
import seedu.ui.TextUi;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.text.WordUtils.wrap;

public class Module extends BaseModule {
    private static final int FINALISE_INDEX = 1;

    private String department;
    private String faculty;
    private String prerequisite;
    private String preclusion;
    private String corequisite;
    private String acadYear;
    private Attributes attributes;
    private ArrayList<Semester> semesterData;
    private static final String[] GRADES = {"A+", "A", "A-", "B+", "B", "B-", "C+", "C", "D+", "D", "F"};
    private static final String[] SU_GRADES = {"S", "U", "CS", "CU"};


    @JsonAdapter(PrerequisiteTreeAdapterFactory.class)
    private PrerequisiteTree prereqTree;

    private static final int CODE_LENGTH = 4;
    private static final int THOUSAND = 1000;

    public Module(String moduleCode) {
        super(moduleCode);
    }

    public GradedModule toGradedModule(String grade) {
        return new GradedModule(this, grade);
    }

    public UngradedModule toUngradedModule(String grade) {
        return new UngradedModule(this, grade);
    }

    public Lesson getLesson(int sem, int idx) {
        for (Semester s : semesterData) {
            if (s.getSemester() == sem) {
                return s.getLesson(idx);
            }
        }
        return null;
    }

    public List<Integer> getSemesters() {
        return null;
    }

    public PrerequisiteTree getPrerequisiteTree() {
        return prereqTree;
    }

    public String getPrerequisite() {
        return prerequisite;
    }

    public Semester getSemester(int sem) {
        for (Semester s : semesterData) {
            if (s.getSemester() == sem) {
                return s;
            }
        }
        //What is the point of this? Shouldn't we just print out an error
        return new Semester();
    }

    public String getFullInfo() {
        String isSUable = "No data";
        if (attributes != null) {
            isSUable = attributes.isSUable();
        }
        String fullInfo = "Title: " + title + "\n"
                + "MCs: " + (int) moduleCredit + "\n"
                + "Department: " + department + "\n"
                + wrap(description, 70) + "\n"
                + "Prerequisites: " + prerequisite + "\n"
                + "S/U able: " + isSUable + "\n"
                + "Semester Availability: " + semesterData + "\n";
        //uncomment and test this with mods with special sems eg CS1010E, CS2040, CS3243. It should print the
        //weeks for two lessons, one from sem 1 and one from special term 2.
        //String test = getSemester(1).getLesson(0).getWeeks() + getSemester(4).getLesson(0).getWeeks();
        //return fullInfo + test;
        return fullInfo;
    }

    public boolean meetsPreliminaryConditions(String searchTerm, SearchFlags searchFlags) {
        if (searchFlags.getHasLevelFlag()) {
            if (!isSameLevel(searchFlags.getLevel())) {
                return false;
            }
        }
        return codeContains(searchTerm);
    }

    private boolean codeContains(String searchTerm) {
        return moduleCode.toLowerCase().contains(searchTerm.toLowerCase());
    }

    private boolean isSameLevel(int level) {
        String modNumericCode = moduleCode.replaceAll("[^0-9]", "");
        int modLevel = Integer.parseInt(modNumericCode) / THOUSAND;
        return modLevel == level / THOUSAND;
    }

    public boolean meetsSecondaryConditions(SearchFlags searchFlags) {
        if (searchFlags.getHasMcFlag()) {
            if (moduleCredit != searchFlags.getMcs()) {
                return false;
            }
        }
        if (searchFlags.getHasFacultyFlag()) {
            if (!faculty.equalsIgnoreCase(searchFlags.getFaculty())) {
                return false;
            }
        }
        if (searchFlags.getHasDepartmentFlag()) {
            if (!department.equalsIgnoreCase(searchFlags.getDepartment())) {
                return false;
            }
        }
        if (searchFlags.getHasExamFlag()) {
            if (!checkExams(searchFlags.getHasExam())) {
                return false;
            }
        }
        if (searchFlags.getHasSemesterFlag()) {
            if (!hasSemester(searchFlags.getSemester())) {
                return false;
            }
        }
        return true;
    }

    private boolean checkExams(boolean hasExams) {
        if (hasExams) {
            for (Semester s : semesterData) {
                if (s.getExamDate() != null) {
                    return true;
                }
            }
            return false;
        } else {
            for (Semester s : semesterData) {
                if (s.getExamDate() != null) {
                    return false;
                }
            }
            return true;
        }
    }

    private boolean hasSemester(int semester) {
        for (Semester s : semesterData) {
            if (s.getSemester() == semester) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks for the type and validity of the grade.
     *
     * @param gradeToCheck GradeToCheck stores the grade that is to be checked
     * @return gradeType which is the type of the grade
     * @throws UniModsException If grade is invalid
     */
    public static String checkGradeType(String gradeToCheck) throws UniModsException {
        String gradeType = "";
        for (int i = 0; i < GRADES.length; i++) {
            if (gradeToCheck.equals(GRADES[i])) {
                gradeType = TextUi.GRADED;
                return gradeType;
            }
        }
        for (int i = 0; i < SU_GRADES.length; i++) {
            if (gradeToCheck.equals(SU_GRADES[i])) {
                gradeType = TextUi.UNGRADED;
                return gradeType;
            }
        }
        throw new UniModsException(TextUi.ERROR_INVALID_GRADE);

    }
}
