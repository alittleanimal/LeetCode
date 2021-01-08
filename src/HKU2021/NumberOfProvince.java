package HKU2021;

/**
 * 547. Number of Provinces
 */
public class NumberOfProvince {
    /**
     * Use isVisited array to record search history
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int[] isVisit = new int[isConnected.length];
        int resultCount = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (isVisit[i] == 0) {
                getAllProvince(i, isConnected, isVisit);
                resultCount++;
            }
        }
        return resultCount;
    }

    private void getAllProvince(int index, int[][] isConnected, int[] isVisit) {
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[index][j] == 1 && isVisit[j] == 0) {
                isVisit[j] = 1;
                getAllProvince(j, isConnected, isVisit);
            }
        }
    }

    public static void main(String[] args) {
        NumberOfProvince numberOfProvince = new NumberOfProvince();
        int[][] isConnected = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(numberOfProvince.findCircleNum(isConnected));
    }
}
