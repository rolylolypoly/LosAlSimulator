package io.github.rollylollypolly;

import io.github.rollylollypolly.people.HighSchool;

import java.io.IOException;

/**
 * Created by Will on 11/20/2015.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("============================================ Hello! ============================================");
        System.out.println("============== Welcome to Los Alamitos High School Simulator Version 1 x 10^-72! ===============");
        System.out.println("========By using this software you agree to all the terms, which will be specified later.=======");
        System.out.println("=======This software is provided free of charge, please provide bank account information.=======");
        HighSchool hue = new HighSchool("Bob", 3,"apache attack helicopter", "3", .1, "Freshman", false);
        System.out.println(hue.toString());
    }
}
