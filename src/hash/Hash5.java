package hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class Hash5 {
    public static void main(String[] args) throws Exception {
        double x = 23;

        // a) Exact method
        double s = 1;
        for (double i = 0; i < x; i++) {
            s = s * ((365-i)/(365));
        }
        s = 1 - s;
        System.out.println("a) Probability of two people having the same birthday using the exact method is: " + s);

        // b) approximation
        s = 1 - Math.exp(-(x*x) / (2 * 365));
        System.out.println("b) Probability of two people having the same birthday using the approx method is: " + s);

        // d) Monte Carlo
        int numSimulations = 100000;
        int numPeople = (int)x;
        double totalProb = 0;
        for (int i = 0; i < numSimulations; i++) {
            Integer[] birthdays = new Integer[numPeople];
            Random rng = new Random();
            for (int j = 0; j < numPeople; j++) {
                birthdays[j] = rng.nextInt(1, 366);
            }
            if(new HashSet<Integer>(Arrays.asList(birthdays)).size() != birthdays.length) {
                totalProb++;
            }
        }
        double monteProb = totalProb / numSimulations;
        System.out.println("d) Probability of two people having the same birthday using the Monte Carlo method is: " + monteProb);

		/*
		 * h(id) = id mod 1000. (0 to 9999 possible hash) p(no students having same id)
		 * = (9999/10000)^100 p( no students have Id's that result in any of the 10000
		 * values) [p(no students have same id)^10000] p = 1 - p(no students have id's
		 * that result in any of the 10000 values) p = 0.0000000003%
		 */

    }
}