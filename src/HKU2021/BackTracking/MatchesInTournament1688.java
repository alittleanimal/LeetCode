package HKU2021.BackTracking;

import org.junit.Test;

public class MatchesInTournament1688 {
    public int numberOfMatches(int n) {
        if (n == 2)
            return 1;
        if (n == 1)
            return 0;

        if (n % 2 == 0) {
            return n / 2 + numberOfMatches(n / 2);
        } else {
            return (n - 1) / 2 + numberOfMatches((n - 1) / 2 + 1);
        }
    }

    @Test
    public void test1688() {
        System.out.println(numberOfMatches(14));
    }
}
