package regex;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;


public class RegexRepetitionFactorTest {

    /**
     * * Exercise:
     * - We have to find words:
     *   1. starting with foo,
     *   2. ending with bar
     *   3. with one letter between
     *
     * example: foo[]bar
     *
     * REGEX TO DO THIS
     * . -> Matches any single character.
     * ^ -> Matches the beginning of a line.
     * $ ->	Matches the end of the line.
     */
    @Test
    void testingOneCharRepetitions() {
        final String REGEX_PATTERN = "^foo.bar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {"fooabar", "fooxbar", "baryfoo", "foobar", "fooxybar", "foocbar", "afoocbar", "afoocbaraa"};
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if(pattern.matcher(value).find()){
                matches.add(value);
            }
        }
        assertThat(matches).hasSameElementsAs(List.of("fooabar", "fooxbar", "foocbar"));
    }

    /**
     * * Exercise:
     * - We have to find words:
     *   1. starting with foo,
     *   2. ending with bar
     *   3. with or without char between
     *
     * example: foobar, fooxbar, fooxxxbar
     *
     * REGEX TO DO THIS
     * ^ -> Matches the beginning of a line.
     * $ ->	Matches the end of the line.
     * . -> Matches any single character.
     * * -> Matches 0 or more repetitions of the previous character or expression.
     */
    @Test
    void testingZeroOrMoreCharRepetitions() {
        final String REGEX_PATTERN = "^foo(.*)bar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {"fooabar", "fooxbar", "baryfoo", "foobar", "fooxybar", "foocbar", "afoocbar", "afoocbaraa"};
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if(pattern.matcher(value).find()){
                matches.add(value);
            }
        }
        assertThat(matches).hasSameElementsAs(List.of("fooabar", "fooxbar", "foobar", "fooxybar", "foocbar"));
    }

    /**
     * * Exercise:
     * - We have to find words:
     *   1. starting with foo,
     *   2. ending with bar
     *   3. with AT LEAST one between
     *
     * example: fooxbar, fooybar, fooxyzbar
     *
     * REGEX TO DO THIS
     * ^ -> Matches the beginning of a line.
     * $ ->	Matches the end of the line.
     * . -> Matches any single character.
     * + -> Matches 1 or more repetitions of the previous character or expression.
     */
    @Test
    void testingOneOrMoreCharRepetitions() {
        final String REGEX_PATTERN = "^foo(.+)bar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {"fooabar", "fooxbar", "baryfoo", "foobar", "foo bar", "fooxybar", "foocbar", "afoocbar", "afoocbaraa"};
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if(pattern.matcher(value).find()){
                matches.add(value);
            }
        }
        assertThat(matches).hasSameElementsAs(List.of("fooabar", "fooxbar", "fooxybar", "foocbar", "foo bar"));
    }

    /**
     * * Exercise:
     * - We have to find words:
     *   1. starting with foo,
     *   2. ending with bar
     *   3. with or without SPACE between
     *
     * example: foobar, foo bar
     *
     * REGEX TO DO THIS
     * ^ -> Matches the beginning of a line.
     * $ ->	Matches the end of the line.
     * \s -> Matches any whitespace character (space, tab, newline)
     * * -> Matches 1 or more repetitions of the previous character or expression.
     */
    @Test
    void testingZeroOrMoreSpaceRepetition() {
        final String REGEX_PATTERN = "^foo(\\s*)bar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {"fooabar", "fooxbar", "baryfoo", "foobar", "foo bar", "foo  bar", "fooxybar", "foocbar", "afoocbar", "afoocbaraa"};
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if(pattern.matcher(value).find()){
                matches.add(value);
            }
        }
        assertThat(matches).hasSameElementsAs(List.of("foobar", "foo bar", "foo  bar"));
    }

    /**
     * * Exercise:
     * - We have to find words:
     *   1. starting with foo,
     *   2. ending with bar
     *   3. with AT LEAST on SPACE between
     *
     * example: foo[" "]bar
     *
     * REGEX TO DO THIS
     * ^ -> Matches the beginning of a line.
     * $ ->	Matches the end of the line.
     * \s -> Matches any whitespace character (space, tab, newline)
     * + -> Matches 1 or more repetitions of the previous character or expression.
     */
    @Test
    void testingOneOrMoreSpaceRepetitions() {
        final String REGEX_PATTERN = "^foo(\\s+)bar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {"fooabar", "fooxbar", "baryfoo", "foobar", "foo bar", "foo  bar", "fooxybar", "foocbar", "afoocbar", "afoocbaraa"};
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if(pattern.matcher(value).find()){
                matches.add(value);
            }
        }
        assertThat(matches).hasSameElementsAs(List.of("foo bar", "foo  bar"));
    }

    /**
     * * Exercise:
     * - We have to find words:
     *   1. starting with foo,
     *   2. ending with bar
     *   3. repeating 2 times some letter between
     *
     * example: foo[2x]bar
     *
     * REGEX TO DO THIS
     * ^ -> Matches the beginning of a line.
     * $ ->	Matches the end of the line.
     * {n} -> Matches n repetitions of the previous character or expression.
     * . -> Matches any single character.
     */
    @Test
    void testingNRepetitions() {
        final String REGEX_PATTERN = "^foo(.{2})bar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {"fooaxbar", "fooxbar", "baryfoo", "foobar", "foo bar", "foo  bar", "fooxybar", "foocbar", "afoocbar", "afoocbaraa"};
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if(pattern.matcher(value).find()){
                matches.add(value);
            }
        }
        assertThat(matches).hasSameElementsAs(List.of("fooxybar", "fooaxbar", "foo  bar"));
    }

    /**
     * * Exercise:
     * - We have to find words:
     * 1. starting with any letter,
     * 2. ending with oobar
     * <p>
     * example: coobar,
     * coo bar,
     * zoobar
     * <p>
     * REGEX TO DO THIS
     * ^ -> Matches the beginning of a line.
     * $ ->	Matches the end of the line.
     * . -> Matches any single character.
     * + -> Matches 1 or more repetitions of the previous character or expression.
     */
    @Test
    void testingWithSpecificWordAfter() {
        final String REGEX_PATTERN = "^(.+)oobar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "foobar",
                "fooabar",
                "coobar",
                "Zoobar",
                "zoobaro",
                "s oobar",
                "soobar"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }
        assertThat(matches).hasSameElementsAs(
                List.of("foobar", "coobar", "Zoobar", "s oobar", "soobar")
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
