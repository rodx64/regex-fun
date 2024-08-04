package regex;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexCurlyBracesTest {

    /**
     * * Exercise:
     * - We have to find numbers:
     * 1. with 3 size
     * <p>
     * example: xxx, yyy, xzy
     * <p>
     * REGEX TO DO THIS
     * [...] -> Matches the characters specified in the brackets.
     * {n} -> Matches n repetitions of the previous character or expression.
     * $ ->	Matches the end of the line.
     * ^ -> Matches the beginning of a line.
     */
    @Test
    void testingSpecificNumbers() {
        final String REGEX_PATTERN = "^\\d{3}$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "333",
                "Aoobar",
                "fooabar",
                "boobar",
                "Boobar",
                "s.oobar",
                "coo:bar",
                "12",
                "-12",
                "123",
                "1234"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("333", "123")
        );
    }

    /**
     * * Exercise:
     * - We have to find words:
     * 1. bigger than 4 chars
     * 2. smaller than 7 chars
     * <p>
     * example: mouse, tiger, deer
     * <p>
     * REGEX TO DO THIS
     * [...] -> Matches the characters specified in the brackets.
     * {n} -> Matches n repetitions of the previous character or expression.
     * $ ->	Matches the end of the line.
     * ^ -> Matches the beginning of a line.
     */
    @Test
    void testingSpecificStringsBySize() {
        final String REGEX_PATTERN = "^[a-zA-Z]{4,7}$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "333",
                "lion",
                "tiger",
                "Tiger",
                "fox",
                "bat",
                "mouse",
                "12",
                "-12",
                "deer",
                "kangaroo",
                "elephant"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("lion", "tiger", "Tiger", "mouse", "deer")
        );
    }


    /**
     * * Exercise:
     * - We have to find words with repetitions:
     * 1. bigger than 2 repetitions
     * 2. smaller than 5 repetitions
     * <p>
     * example: ahahah, ahahahah, ahahahahah
     * <p>
     * REGEX TO DO THIS
     * (...) -> Groups a set of matching characters together.
     * {n,m} -> Matches n to m repetitions of the previous character or expression.
     * $ ->	Matches the end of the line.
     * ^ -> Matches the beginning of a line.
     */
    @Test
    void testingSpecificStringsByRepetitions() {
        final String REGEX_PATTERN = "^(ah){2,5}$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "ah",
                "ahah",
                "",
                "ahahah",
                "ahahahahah",
                "ahahahahahah",
                "ahahahah",
                "haha",
                "hahaha",
                "a",
                "1313",
                "11ah",
                "ah11"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("ahah", "ahahah", "ahahahah", "ahahahahah")
        );
    }

    /**
     * * Exercise:
     * - We have to find words with char repetitions between two words:
     * <p>
     * example: fooabar, fooaaabar, fooaabar
     * <p>
     * REGEX TO DO THIS
     * (...) -> Groups a set of matching characters together.
     * + -> Matches 1 or more repetitions of the previous character or expression.
     * $ ->	Matches the end of the line.
     * ^ -> Matches the beginning of a line.
     */
    @Test
    void testingSpecificStringsByCharRepetitionsInside() {
        final String REGEX_PATTERN = "^(foo)(a)+(bar)$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "aoobar",
                "Aoobar",
                "fooabar",
                "fooaabar",
                "fooaaabar",
                "boobar",
                "Boobar",
                "booabar",
                "hoobar",
                "Zoobar",
                "foobar",
                "foobara",
                "fooobar",
                "zoobaro",
                "s oobar",
                "coobar",
                "Coobar"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("fooabar", "fooaabar", "fooaaabar")
        );
    }
}
