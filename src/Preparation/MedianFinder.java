package Preparation;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
    private List<Integer> recordList;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        recordList = new ArrayList<>();
    }

    public void addNum(int num) {
        int left = 0;
        int right = recordList.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (recordList.get(mid) > num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (recordList.size() == 0 || num > recordList.get(recordList.size() - 1)) {
            recordList.add(num);
        } else {
            recordList.add(left, num);
        }
    }

    public double findMedian() {
        int mid = recordList.size() / 2;
        if (recordList.size()%2 != 0) {
            return recordList.get(mid);
        } else {
            return (recordList.get(mid) + recordList.get(mid - 1)) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
    }
}
