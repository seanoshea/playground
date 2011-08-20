public class Two {

	public static void main(String[] args) {
		int x = nextPrimeFibonacciNumber(227000);
		int sum = sumPrimeDivisors(x + 1);
		System.out.println("Sum of prime divisidors for " + (x + 1) + " is "
				+ sum);
	}

	private static boolean isPrime(int num) {
		boolean prime = true;
		// a few simple cases
		if (num == 1 || num <= 3) {
			prime = true;
		} else {
			// start iterating and see if anything is divisible
			for (int i = 2; i <= Math.ceil(num / 2); i++) {
				if (num % i == 0) {
					prime = false;
					break;
				}
			}
		}
		return prime;
	}

	private static int fibonacci(int num) {
		if (num <= 2) {
			return 1;
		} else {
			return fibonacci(num - 1) + fibonacci(num - 2);
		}
	}

	private static int nextPrimeFibonacciNumber(int min) {
		int i = 1, fib;
		// while (true) is a little scary here - might be an idea to
		// have some kind of interrupt should this while loop run indefinitely
		while (true) {
			fib = fibonacci(i);
			// cheaper to check for less than first
			// and then worry about primes.
			if (min < fib && isPrime(fib)) {
				break;
			}
			i++;
		}
		return fib;
	}

	private static int sumPrimeDivisors(int num) {
		int factors = 0, n = num;
		for (int i = 2; i <= n; i++) {
			while (n % i == 0) {
				factors += i;
				n /= i;
			}
		}
		return factors;
	}
}