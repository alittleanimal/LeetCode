import java.util.*;

public class LetterCombinations {

	public List<String> letterCombinations(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<>();
		}
		List<String> letterList = new ArrayList<>(Arrays.asList("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"));
		String[] inputList = digits.split("");
		Queue<String> resultList = new LinkedList<>();
		for (int i = 0; i < inputList.length; i++) {
			String[] letterOfThis = letterList.get(Integer.valueOf(inputList[i]) - 2).split("");
			if (!resultList.isEmpty()) {
				int size = resultList.size();
				for (int j = 0; j < size; j++) {
					String head = resultList.poll();
					Arrays.stream(letterOfThis).forEach(letter -> resultList.offer(head + letter));
				}
			} else {
				resultList.addAll(Arrays.asList(letterOfThis));
			}
		}
		return (List<String>) resultList;
	}

	public List<String> letterCombinations_betterSolution(String digits) {
		if (digits.isEmpty()) {
			return new ArrayList<>();
		}
		String[] letterList = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		String[] inputList = digits.split("");
		for (int i = 0; i < inputList.length; i++) {
			inputList[i] = letterList[Integer.valueOf(inputList[i])];
		}
		List<String> resultList = new LinkedList<>();
		return getString(inputList, resultList, 0, "");
	}

	public List<String> getString(String[] inputList, List<String> resultList, int inputItemPosition, String tempStr) {
		if (inputItemPosition < inputList.length - 1) {
			for (int i = 0; i < inputList[inputItemPosition].length(); i++) {
				resultList = getString(inputList, resultList, inputItemPosition + 1, tempStr + inputList[inputItemPosition].charAt(i));
			}
			inputItemPosition++;
		} else {
			for (int i = 0; i < inputList[inputItemPosition].length(); i++) {
				resultList.add(tempStr + inputList[inputItemPosition].charAt(i));
			}
		}

		return resultList;
	}

	public static void main(String[] args) {
		LetterCombinations letterCombinations = new LetterCombinations();
		List<String> result = letterCombinations.letterCombinations_betterSolution("");
		System.out.println(result.toString());
	}
}
