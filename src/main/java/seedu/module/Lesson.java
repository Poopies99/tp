package seedu.module;

import com.google.gson.annotations.JsonAdapter;

import java.time.DayOfWeek;
import java.util.ArrayList;

public class Lesson {
    private static final String GAP = ", ";
    private static final int DIVISOR = 100;
    private static final int ONE = 1;
    private final String classNo;
    private final String startTime;
    private final String endTime;

    @JsonAdapter(WeeksAdapterFactory.class)
    private Weeks weeks;

    private final String venue;
    private final String day;
    private final String lessonType; //placeholder
    private final int size;

    public Lesson(String classNo, String startTime, String endTime, String venue,
                  String lessonType, String day) {
        this.classNo = classNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.venue = venue;
        this.lessonType = lessonType;
        this.day = day;
        this.size = 0;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getClassNo() {
        return classNo;
    }

    public String getDay() {
        return day;
    }

    public DayOfWeek getParsedDay() {
        switch (getDay()) {
        case "Monday":
            return DayOfWeek.MONDAY;
        case "Tuesday":
            return DayOfWeek.TUESDAY;
        case "Wednesday":
            return DayOfWeek.WEDNESDAY;
        case "Thursday":
            return DayOfWeek.THURSDAY;
        case "Friday":
            return DayOfWeek.FRIDAY;
        case "Saturday":
            return DayOfWeek.SATURDAY;
        case "Sunday":
            return DayOfWeek.SUNDAY;
        default:
            return null;
        }
    }

    public String getLessonType() {
        return lessonType;
    }

    public String getVenue() {
        return venue;
    }

    public String getWeeks() {
        return weeks.toString();
    }

    public String lessonDetails() {
        return getDay() + GAP + getStartTime() + "-" + getEndTime() + GAP + getClassNo() + GAP + getVenue();
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Integer> getStartToEndTime() {
        int length = ((Integer.parseInt(getEndTime())) - Integer.parseInt(getStartTime())) / DIVISOR;
        ArrayList<Integer> time = new ArrayList<>();
        int startTime = Integer.parseInt(getStartTime()) / DIVISOR;
        time.add(startTime);
        for (int i = 1; length > i; i++) {
            startTime += ONE;
            time.add(startTime);
        }
        return time;
    }
}
