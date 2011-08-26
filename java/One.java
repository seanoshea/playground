/**
 * Java implementation of getting the largest palindrome in a string of
 * characters.
 */
public class One {

    public static void main(String[] args) {
	// http://en.wikipedia.org/wiki/Palindrome#Long_palindromes
	String str = "atattarrattatz";
	String longest = getBiggestPalindrome(str);
	System.out.println("The longest palindrome in " + str + " is "
		+ longest);
    }

    private static String getBiggestPalindrome(String str) {
	String longest = "", palindromeCenteredAtPosition;
	// general idea here is that you pick a point in the original str, use
	// this point as a pivot and start incrementing/decrementing pointers
	// from/to this pivot checking at each increment/decrement to see if a
	// valid palindrome exists.
	for (int i = 0, l = str.length(); i < l; i++) {
	    // get the palindrome centered at position i
	    palindromeCenteredAtPosition = findPalindromeCenteredAtPosition(
		    str, i);
	    // check to see if the palindrome at position i trumps the previous
	    // record
	    if (palindromeCenteredAtPosition.length() > longest.length()) {
		longest = palindromeCenteredAtPosition;
	    }
	}
	// we're done!
	return longest;
    }

    private static String findPalindromeCenteredAtPosition(String str,
	    int position) {
	// initially, the start & end of this palindrome is equal to the
	// position passed in
	int start = position, end = position,
	// the % 2 === 1 piece here accounts for strings with an uneven number
	// of characters
	lower = str.length() % 2 == 1 ? position - 1 : position,
	// upper always starts at the current position + 1
	upper = position + 1;
	// first two clauses here ensure that the searching doesn't go off the
	// end of the array the last clause is the actual palindrome check
	while (lower >= 0 && upper < str.length()
		&& str.charAt(lower) == str.charAt(upper)) {
	    lower--;
	    upper++;
	}
	// check to see if the while looping has decremented/incremented lower
	// and upper to a sufficient enough amount such that our previous best
	// palindrome has been beaten
	if (upper - lower > end - start) {
	    // switchero
	    end = upper;
	    start = lower;
	}
	// send the client code the substring based on the most up-to-date start
	// & end
	return str.substring(start + 1, end);
    }
}