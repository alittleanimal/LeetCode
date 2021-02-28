package HKU2021;

/**
 * 896. Monotonic Array
 */
public class MonotonicArray896 {
    public boolean isMonotonic(int[] A) {
        if (A.length == 1) return true;

        String monotone = "";

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] == A[i])
                continue;

            if ("" == monotone && A[i + 1] != A[i])
                monotone = A[i + 1] > A[i] ? "Increase" : "Decrease";

            if ("Increase" == monotone) {
                if (A[i + 1] < A[i])
                    return false;
            } else {
                if (A[i + 1] > A[i])
                    return false;
            }
        }

        return true;
    }

    public boolean isMonotonicBetterSol(int[] A) {
        if (A.length < 3)
            return true;

        boolean des = true, ins = true;

        for (int i = 0; i < A.length -1; i++) {
            if (des && A[i + 1] > A[i]) des = false;
            if (ins && A[i + 1] < A[i]) ins = false;
        }

        // use boolean to indicate the tendency change
        return des || ins;
    }
}
