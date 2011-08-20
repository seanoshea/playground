public class Three {

	private static int[] values = { 3, 4, 9, 14, 15, 19, 28, 37, 47, 50, 54,
			56, 59, 61, 70, 73, 78, 81, 92, 95, 97, 99 };

	public static void main(String[] args) {
		int sum = count();
		System.out.println("summ is " + sum);
	}

	private static int count() {
		int previousValue = -1, duplicates = 0, totalsets = 0, value;
		for (int i = 0, l = values.length; i < l; i++) {
			value = values[i];
			if (previousValue == value) {
				duplicates++;
			}
			previousValue = value;
			totalsets += waysToSum(value, 0);
		}
		return totalsets - values.length + duplicates;
	}

	private static int waysToSum(int sum, int index) {
		int value = values[index];
		if (sum < value) {
			return 0;
		} else if (sum > value) {
			return waysToSum(sum - value, index + 1)
					+ waysToSum(sum, index + 1);
		} else {
			return 1;
		}
	}
}
