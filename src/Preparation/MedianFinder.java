package Preparation;

import java.util.ArrayList;
import java.util.List;

public class MedianFinder {
	private List<Integer> recordList;
	int size = 0;

	/** initialize your data structure here. */
	public MedianFinder() {
		recordList = new ArrayList<>();
		size = 0;
	}

	public void addNum(int num) {
		int i = 0;
		boolean addFlag = false;
		for (i = 0; i < size; i++) {
			if (recordList.get(i) > num) {
				recordList.add(i, num);	
				addFlag = true;
				break;
			}
		}
		
		if (size==0 || !addFlag) {
			recordList.add(num);
		}
		size++;
	}

	public double findMedian() {
		return (recordList.get(0) + recordList.get(size-1)) / 2.0;
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
