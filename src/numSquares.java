import java.util.ArrayList;
import java.util.List;

public class numSquares {
    public int numSquares(int n) {
        int sqrt = (int) Math.floor(Math.sqrt(n));
        List<Integer> squareList = getSquaresList(sqrt);

        int sum = 0;
        int count = 0;
        for (Integer square: squareList) {
            sum+=square;
            if (sum < n) {
                count ++;
                continue;
            } else if (sum > n) {
                sum -= square;
                continue;
            } if (sum == n) {
                count ++;
                break;
            }
        }
        return count;  
    }

    public List<Integer> getSquaresList(int n) {
        List<Integer> squareList = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            squareList.add((int) Math.pow(i, 2));
        }
        return squareList;
    }
}
