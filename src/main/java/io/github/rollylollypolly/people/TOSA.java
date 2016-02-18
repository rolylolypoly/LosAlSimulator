package io.github.rollylollypolly.people;

import java.util.Arrays;

/**
 * Created by rolypoly on 2/11/16.
 */
public class TOSA extends Teacher {
    private String department;
    private int[] periods;
    public TOSA(String name, int age, String gender, String subject, double salary, String department, int[] periods) {
        super(name, age, gender, subject, salary);
        this.department = department;
        this.periods = periods;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int[] getPeriods() {
        return periods;
    }

    public void setPeriods(int[] periods) {
        this.periods = periods;
    }
    @Override
    public String toString() {
        return super.toString() + this.getDepartment() + Arrays.toString(this.getPeriods());
    }
}
