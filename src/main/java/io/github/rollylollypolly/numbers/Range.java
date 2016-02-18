package io.github.rollylollypolly.numbers;

/**
 * Created by rolypoly on 2/18/16.
 */
public class Range implements NumberGroup {
    private int min, max;
    Range(int min, int max) {
        this.max = max;
        this.min = min;
    }
    @Override
    public boolean contains(int n) {
        if (min == n || max == n) return true;
        else return false;
    }
}
