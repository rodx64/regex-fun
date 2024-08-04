package regex;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexMatchingTest {

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
     * - We have to find words:
     * 1. starting with a, h, z
     * 2. ending with oobar
     * <p>
     * example: aoobar,
     * hoobar,
     * zoobar
     * <p>
     * REGEX TO DO THIS
     * ^ -> Matches the beginning of a line.
     * $ ->	Matches the end of the line.
     * . -> Matches any single character.
     * + -> Matches 1 or more repetitions of the previous character or expression.
     */
    @Test
    void testingWithSpecificWordAfterAndStartingWithSpecificLetters() {
        final String REGEX_PATTERN = "^[ahz]oobar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "aoobar",
                "fooabar",
                "hoobar",
                "Zoobar",
                "zoobar",
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
                List.of("aoobar", "hoobar", "zoobar")
        );
    }

    /**
     * * Exercise:
     * - We have to find words:
     * 1. not starting with a, h, z,
     * 2. ending with oobar
     * <p>
     * example: xoobar,
     * koobar
     * <p>
     * REGEX TO DO THIS
     * [^...] -> Matches anything except the set of specified characters.
     */
    @Test
    void testingWithSpecificWordAfterAndStartingWithoutSpecificLetters() {
        final String REGEX_PATTERN = "[^ahz]oobar";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "aoobar",
                "fooabar",
                "hoobar",
                "Zoobar",
                "zoobar",
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
                List.of("Zoobar", "soobar", "s oobar")
        );
    }

    /**
     * * Exercise:
     * - We have to find words:
     * 1. starting with a,b,c and z,
     * 2. ending with oobar
     * <p>
     * example: aoobar, zoobar
     * <p>
     * REGEX TO DO THIS
     * $ ->	Matches the end of the line.
     * [...] -> Matches the characters specified in the brackets.
     */
    @Test
    void testingWithSpecificWordAfterAndStartingWithARangeOfSpecificLetters() {
        final String REGEX_PATTERN = "[a-cz]oobar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "aoobar",
                "fooabar",
                "boobar",
                "booabar",
                "hoobar",
                "Zoobar",
                "zoobar",
                "zoobaro",
                "s oobar",
                "coobar"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("aoobar", "boobar", "coobar", "zoobar")
        );
    }

    /**
     * * Exercise:
     * - We have to find words:
     * 1. starting with a,A,b,c,z and Z ,
     * 2. ending with oobar
     * <p>
     * example: aoobar, zoobar
     * <p>
     * REGEX TO DO THIS
     * $ ->	Matches the end of the line.
     * [...] -> Matches the characters specified in the brackets.
     */
    @Test
    void testingWithSpecificWordAfterAndStartingWithARangeOfSpecificLettersSomeCapitalized() {
        final String REGEX_PATTERN = "[a-cAzZ]oobar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "aoobar",
                "Aoobar",
                "fooabar",
                "boobar",
                "Boobar",
                "booabar",
                "hoobar",
                "Zoobar",
                "zoobar",
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
                List.of("aoobar", "Aoobar", "boobar", "coobar", "zoobar", "Zoobar")
        );
    }
}
