package io.github.rollylollypolly.people;

/**
 * Created by rolypoly on 2/12/16.
 */
public class HighSchool extends Student {
    private String year;
    private boolean honors;
    public HighSchool(String name, int age, String gender, String idNum, double gpa, String year, boolean honors) {
        super(name, age, gender, idNum, gpa);
        this.year = year;
        this.honors = honors;
    }
    public String year() {
        return year;
    }
    public void year(String year) {
        this.year = year;
    }
    public boolean honors() {
        return honors;
    }
    public void honors(boolean honors) {
        this.honors = honors;
    }

    @Override
    public String toString() {
        return super.toString() + ", Year: " + year + ", Honors: " + honors;
    }
}
