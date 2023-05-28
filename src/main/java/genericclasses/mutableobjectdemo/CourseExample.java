package genericclasses.mutableobjectdemo;

public class CourseExample {
    private String course;

    public CourseExample() {
    }

    public CourseExample(String course) {
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String courseName) {
        this.course = courseName;
    }

}
