package genericclasses.enumdemo;

public enum Courses {
    MATH("MAT20", 4, 10.00),
    SCIENCES("SC31", 15, 12.00),
    ENGLISH("EN44", 9, 16.00);

    private final String courseCode;
    private final Integer roomNumber;
    private final Double time;

    Courses(String courseCode, int roomNumber, double time){
        this.courseCode = courseCode;
        this.roomNumber = roomNumber;
        this.time = time;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public Double getTime() {
        return time;
    }
}
