# Regex Basics

## Repetition factors

| factor   | Description                                                                | Example                                                                                             |
|----------|----------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------|
| * 	    | Matches 0 or more repetitions of the previous character or expression.     | 	ab*c matches ac, abc, abbc, but not ab or abd                                                      |
| +        | Matches 1 or more repetitions of the previous character or expression.     | ab+c matches abc and abbc, but not ab, ac or abd                                                    |
| ?        | Matches 0 or 1 repetitions of the previous character or expression.        | ab?c matches ac and abc, but not ab, abbc or abd                                                    |
| {n}      | Matches n repetitions of the previous character or expression.             | ab{2}c matches abbc, but not abc <br> or <br> abbbc a\d{3} matches a123and a789, but not a12 or 456 |
| {n,m}    | Matches n to m repetitions of the previous character or expression.        | 	ab{2,4}c matches abbc, abbbc and abbbbc, but not abc or abbbbbc                                    |
| {n,}     | Matches at least n repetitions of the previous character or expression. 	 | ab{2,}c matches abbc, abbbc, abbbbc etc, but not abc                                                |