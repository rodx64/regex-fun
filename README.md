# Regex Basics

## Basic Syntax
| char  | Description                                                                                                                 | Example                                                                                             |
|-------|-----------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| (...) | Groups a set of matching characters together. Multiple groups can be specified.                                             | 	(.+)(@example\.net$)                                                                               |  
| \     | Escapes a regular expression special character: {}[]()^ $.*+?\ <br> Also used to reference a group in a replace expression. | ab\+ matches ab+                                                                                    |
| \|    | Matches either one expression or an alternative expression.                                                                 | .*@example\.(net\|com) matches against any URI for the domain example.com or the domain example.net |

## Wildcard and Character matching - [Tests](src/test/java/regex/RegexMatchingTest.java)
| char   | Description                                             | Example                                                                                                                                                                      |
|--------|---------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| .      | Matches any single character.                           | a.c matches aac, abc, azc, a2c, a$c etc.                                                                                                                                     |
| \d     | Matches a decimal digit character (i.e. 0-9).           | a\d matches a1, a2, a3 etc. but not aa, ab etc.                                                                                                                              | 
| \D     | Matches a non-digit character.                          | 	a\D matches ab but not a1, a2, a3 etc.                                                                                                                                      |
| \s     | Matches any whitespace character (space, tab, newline). | ab\sd matches ab d but not abcd, abxd etc.                                                                                                                                   |
| \S     | Matches any non-whitespace character. 	                | ab\Sd matches abcd, abxd etc. but not ab d                                                                                                                                   |
| \w     | Shorthand for [a-zA-Z0-9_].                             | Matches any alphabetical or digit character, or underscore.                                                                                                                  |
| \w+    | Matches bob and bob_jones but not bob.jones.            | [\w.-]+ matches bob, bob.jones, bob_jones, and bob-jones.                                                                                                                    |
| [...]  | Matches the characters specified in the brackets.       | 9[aeiou] matches 9a, 9e, 9i etc. and 9A, 9E, 9I etc, but not 9b, 9c, 9B, 9C etc <br> 9[a-z] matches 9a, 9b, 9z etc. and 9A, 9B, 9Z etc. but not strings such as 91, 99 or 9( |
| [^...] | Matches anything except the set of specified characters.| [^a-z] matches any non-alphabetical character <br> [^0-9#*] matches anything other than an E.164 character                                                                   |

## Repetition factors - [Tests](src/test/java/regex/RegexRepetitionFactorTest.java)
| factor   | Description                                                                | Example                                                                                             |
|----------|----------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| * 	    | Matches 0 or more repetitions of the previous character or expression.     | 	ab*c matches ac, abc, abbc, but not ab or abd                                                      |
| +        | Matches 1 or more repetitions of the previous character or expression.     | ab+c matches abc and abbc, but not ab, ac or abd                                                    |
| ?        | Matches 0 or 1 repetitions of the previous character or expression.        | ab?c matches ac and abc, but not ab, abbc or abd                                                    |
| {n}      | Matches n repetitions of the previous character or expression.             | ab{2}c matches abbc, but not abc <br> or <br> abbbc a\d{3} matches a123and a789, but not a12 or 456 |
| {n,m}    | Matches n to m repetitions of the previous character or expression.        | 	ab{2,4}c matches abbc, abbbc and abbbbc, but not abc or abbbbbc                                    |
| {n,}     | Matches at least n repetitions of the previous character or expression. 	 | ab{2,}c matches abbc, abbbc, abbbbc etc, but not abc                                                |


## Position Match - [Tests](src/test/java/regex/RegexAnchorTest.java)
| factor  | Description                      | Example                                                                                                                                         |
|---------|----------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| ^       | Matches the beginning of a line. | ^meet\.(.*) matches any string that starts with meet. and places the rest of the string into a group (which could be used in a replace string). |
| $       | Matches the end of the line.     | .*\.com$ matches any string that ends in .com                                                                                                   |
| (?!...) | Negative lookahead. Defines a subexpression that must not be present immediately after the current match position | (?!.*@example\.com$).* matches any string that does not end with @example.com |
| (?<!...)| Negative lookbehind. Defines a subexpression that must not be present immediately before the current match position | .*(?<!@)example\.com.* matches any string containing example.com providing it is not preceded by @ | 

### Some tips:
- If a `.` is inside square brackets `[.]`, it does not need to be escaped.
- If `^` or - are inside square brackets `[^]`, `[-]`, it needs to be escaped `[\^] [\-]`.
- The backslash itself ` \ ` always needs to be escaped `\\`.
- `^` can indicate the beginning of the line, or if it is enclosed in square brackets, `[^]` means negation

# References
https://docs.pexip.com/admin/regex_reference.htm
https://regex101.com/
