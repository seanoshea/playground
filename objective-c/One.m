//
//  One.m
//  playground
//
//

#import "One.h"

@interface One (Private)

- (NSString*) findPalindromeForString:(NSString*)str
						   atPosition:(int)position;

@end

@implementation One

- (NSString*) biggestPalindromeForString:(NSString *)str
{
	NSString *longest = @"";
	NSString *palindromeCenteredAtPosition = @"";
	for (int i = 0, l = [str length]; i < l; i++) {
		palindromeCenteredAtPosition = [self findPalindromeForString:str
														  atPosition:i];
		if ([palindromeCenteredAtPosition length] > [longest length]) {
			longest = palindromeCenteredAtPosition;
		}
	}
	// still getting the character at position 0 incorrect here - need to finialize this
	return longest;
}

- (NSString*) findPalindromeForString:(NSString*)str
						   atPosition:(int)position
{
	int start = position;
	int end = position;
	int lower = [str length] % 2 == 1 ? position - 1 : position;
	int upper = position + 1;
	while (lower >= 0 &&
		   upper < [str length] &&
		   [str characterAtIndex:lower] == [str characterAtIndex:upper]) {
		lower--;
		upper++;
	}
	if (upper - lower > end - start) {
		end = upper;
		start = lower;
	}
	if (start < 0) {
		start = 0;
	}
	return [str substringWithRange:NSMakeRange (start, end - start)];
}

@end
