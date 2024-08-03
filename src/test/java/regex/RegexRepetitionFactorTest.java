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
     * example: fooxbar, fooybar, fooxyzbar
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
     * example: fooxbar, fooybar, fooxyzbar
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

}
