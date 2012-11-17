public class FizzBuzz {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            boolean isMultipleOfThree = isMultipleOfThree(i);
            boolean isMultipleOfFive = isMultipleOfFive(i);
            if (isMultipleOfThree || isMultipleOfFive) {
                StringBuilder output = new StringBuilder();
                output.append(i);
                output.append(" ");
                if (isMultipleOfThree) {
                    output.append("Fizz");
                }
                if (isMultipleOfFive) {
                    output.append("Buzz");
                }
                System.out.println(output.toString());
            }
        }
    }

    public static boolean isMultipleOfThree(int number) {
        return number % 3 == 0;
    }

    public static boolean isMultipleOfFive(int number) {
        return number % 5 == 0;
    }

}
