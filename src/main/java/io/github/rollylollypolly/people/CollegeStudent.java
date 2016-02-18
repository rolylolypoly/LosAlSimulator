package io.github.rollylollypolly.people;

/**
 * Created by rolypoly on 2/10/16.
 */
public class CollegeStudent extends Student {
    private String major;
    private int year;
    public CollegeStudent(String name, int age, String gender, String idNum, double gpa, String m, int y) {
        super(name, age, gender, idNum, gpa);
        major = m;
        year  = y;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public String toString() {
        return super.toString() + ", porpoise in life: " + this.getMajor() + ", IQ: " + this.getYear();
    }
}
