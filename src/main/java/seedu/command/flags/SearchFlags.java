package seedu.command.flags;

public class SearchFlags {

    private boolean hasQuickFlag;
    private boolean hasLevelFlag;
    private int level;
    private boolean hasMcFlag;
    private int mcs;
    private boolean hasFacultyFlag;
    private String faculty;
    private boolean hasExamFlag;
    private boolean hasExam;
    private boolean hasDepartmentFlag;
    private String department;
    private boolean hasSemesterFlag;
    private int semester;

    public SearchFlags() {
        this.hasQuickFlag = false;
        this.hasLevelFlag = false;
        this.hasMcFlag = false;
        this.hasFacultyFlag = false;
        this.hasExamFlag = false;
        this.hasDepartmentFlag = false;
    }

    public boolean getHasQuickFlag() {
        return hasQuickFlag;
    }

    public void setHasQuickFlag(boolean hasQuickFlag) {
        this.hasQuickFlag = hasQuickFlag;
    }

    public boolean getHasLevelFlag() {
        return hasLevelFlag;
    }

    public void setHasLevelFlag(boolean hasLevelFlag) {
        this.hasLevelFlag = hasLevelFlag;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean getHasMcFlag() {
        return hasMcFlag;
    }

    public void setHasMcFlag(boolean hasMcFlag) {
        this.hasMcFlag = hasMcFlag;
    }

    public int getMcs() {
        return mcs;
    }

    public void setMcs(int mcs) {
        this.mcs = mcs;
    }

    public boolean getHasFacultyFlag() {
        return hasFacultyFlag;
    }

    public void setHasFacultyFlag(boolean hasFacultyFlag) {
        this.hasFacultyFlag = hasFacultyFlag;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public boolean getHasExamFlag() {
        return hasExamFlag;
    }

    public void setHasExamFlag(boolean hasExamFlag) {
        this.hasExamFlag = hasExamFlag;
    }

    public boolean getHasExam() {
        return hasExam;
    }

    public void setHasExam(boolean hasExam) {
        this.hasExam = hasExam;
    }

    public boolean getHasDepartmentFlag() {
        return hasDepartmentFlag;
    }

    public void setHasDepartmentFlag(boolean hasDepartmentFlag) {
        this.hasDepartmentFlag = hasDepartmentFlag;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public boolean getHasSemesterFlag() {
        return hasSemesterFlag;
    }

    public void setHasSemesterFlag(boolean hasSemesterFlag) {
        this.hasSemesterFlag = hasSemesterFlag;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
}