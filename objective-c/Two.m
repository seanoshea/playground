//
//  Two.m
//  playground
//
//

#import "Two.h"

@interface Two (Private)

- (BOOL) isPrime:(int)num;
- (int) fibonacci:(int)num;

@end

@implementation Two

- (BOOL) isPrime:(int)num
{
	BOOL prime = YES;
	if (num == 1 || num <= 3) {
	    prime = YES;
	} else {
	    for (int i = 2; i <= ceil(num / 2); i++) {
			if (num % i == 0) {
				prime = NO;
				break;
			}
	    }
	}
	return prime;
}

- (int) fibonacci:(int) num
{
	if (num <= 2) {
		return 1;
	} else {
		return [self fibonacci:num - 1] + [self fibonacci:num -2];
	}
}

- (int) nextPrimeFibonacciNumber:(int)min
{
	int i = 1, fib;
	while (1 == 1) {
	    fib = [self fibonacci:i];
	    if (min < fib && [self isPrime:fib]) {
			break;
	    }
	    i++;
	}
	return fib;
}

- (int) sumPrimeDivisorsForNumber:(int) num
{
	int factors = 0, n = num;
	for (int i = 2; i <= n; i++) {
		while (n % i == 0) {
			factors += i;
			n /= i;
		}
	}
	return factors;
}

@end
