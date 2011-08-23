//
//  Three.m
//  playground
//
//

#import "Three.h"

@interface Three (Private)

- (int) waysToSum:(int)sum
			index:(int)index
		   values:(NSArray*)values;

@end

@implementation Three

- (int) count:(NSArray*)values
{
	int previousValue = -1, duplicates = 0, totalsets = 0, value;
	for (int i = 0, l = [values count]; i < l; i++) {
		value = [[values objectAtIndex:i] intValue];
		if (previousValue == value) {
			duplicates++;
		} 
		previousValue = value;
		totalsets += [self waysToSum:value
							   index:0
							  values:values];
	}
	return totalsets - [values count] + duplicates;
}

- (int) waysToSum:(int)sum
			index:(int)index
		   values:(NSArray*)values
{
	int value = [[values objectAtIndex:index] intValue];
	if (sum < value) {
		return 0;
	} else if (sum > value) {
		return [self waysToSum:sum - value
				  index:index + 1
				 values:values] +
				[self waysToSum:sum
						  index:index + 1
						 values:values];
	} else {
		return 1;
	}
}

@end
