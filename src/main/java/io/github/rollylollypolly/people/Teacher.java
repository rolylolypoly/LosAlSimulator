package io.github.rollylollypolly.people;

/**
 * Created by rolypoly on 2/10/16.
 */
public class Teacher extends Person {
    private String subj;
    private double sal;
    public Teacher(String name, int age, String gender, String subject, double salary) {
        super(name, age, gender);
        subj = subject;
        sal = salary;
    }

    public String getSubj() {
        return subj;
    }

    public void setSubj(String subj) {
        this.subj = subj;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public String toString() {
        return super.toString() + ", moonknee: " + this.getSal() + ", subj: " + this.getSubj();
    }
}
