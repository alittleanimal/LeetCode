package collection;

import java.util.ArrayList;
import java.util.List;

public class DuplicationEliminating {

	public static void solutionA(int[] array) {
		int sortIndex = 0;
		int findNextDifferentIndex = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] != array[i + 1]) {
				if (sortIndex < findNextDifferentIndex) {
					array[sortIndex + 1] = array[findNextDifferentIndex + 1];
					sortIndex++;
					findNextDifferentIndex++;
				} else {
					sortIndex = i + 1; // Remember different item
				}
			} else {
				findNextDifferentIndex = i + 1; // Remember duplicate item
			}
		}
	}

	public static void solutionB(int[] array) {
		List<Integer> temp = new ArrayList<>(); // Fundamental type cannot use Arrays.asList()
		for (int item : array) {
			temp.add(item);
		}
		temp.stream().distinct().forEach(item -> System.out.println(item.toString()));
	}

	private static void printArray(int[] array) {
		for (int i : array) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 2, 2, 3, 4, 5, 5, 8, 9, 6, 6 };
		solutionA(array);
		printArray(array);

	}

}
