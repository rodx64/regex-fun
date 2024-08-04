package regex;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexEscapingTest {


    /**
     * * Exercise:
     * - We have to find words:
     * 1. contains a period between two different strings
     * <p>
     * example: xxx.yyy, xx.yyy, xxxxxx.y
     * <p>
     * REGEX TO DO THIS
     * \ -> Escapes a regular expression special character
     * . -> Matches any single character.
     * + -> Matches 1 or more repetitions of the previous character or expression.
     */
    @Test
    void testingEscapeAPeriodBetweenTwoFilledStrings() {
        final String REGEX_PATTERN = "^(.+)\\.(.+$)"; // If a period is inside a brackets, it need not be escaped. But here, we need to scape it
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "333.x",
                "Aoobar",
                "fooabar",
                "boobar",
                "Boobar",
                "boo.",
                "hoobar",
                "Zoobar",
                "zoobar",
                "zoobaro",
                "s.oobar",
                "coo.bar",
                "Cooba.r"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("333.x", "s.oobar", "coo.bar", "Cooba.r")
        );
    }

    /**
     * * Exercise:
     * - We have to find words:
     * 1. contains specific chars (.,:,#) between two different strings
     * <p>
     * example: xxx.yyy, xx:yyy, xxxxxx#y
     * <p>
     * REGEX TO DO THIS
     * [...] -> Matches the characters specified in the brackets.
     * . -> Matches any single character.
     * + -> Matches 1 or more repetitions of the previous character or expression.
     */
    @Test
    void testingEscapeDifferentCharsBetweenTwoFilledStrings() {
        final String REGEX_PATTERN = "^(.+)[.#:](.+$)"; // If a period is inside a brackets, it need not be escaped.
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "333.x",
                "Aoobar",
                "fooabar",
                "boobar",
                "Boobar",
                "boo.",
                "hoo?bar",
                "Zoo&bar",
                "zoobar",
                "zoo%aro",
                "s.oobar",
                "coo:bar",
                "Cooba#r"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("333.x", "s.oobar", "coo:bar", "Cooba#r")
        );
    }

    /**
     * * Exercise:
     * - We have to find words:
     * 1. contains specific chars (.,:,#,^,-) between two different strings
     * <p>
     * example: xxx.yyy, xx:yyy, xxxxxx#y, xx^yy, x-yyy
     * <p>
     * REGEX TO DO THIS
     * \ -> Escapes a regular expression special character
     * [...] -> Matches the characters specified in the brackets.
     * . -> Matches any single character.
     * + -> Matches 1 or more repetitions of the previous character or expression.
     */
    @Test
    void testingEscapeDifferentCharsWhoNeedScapeBetweenTwoFilledStrings() {
        // If a period is inside a brackets, it need not be escaped.
        // But even inside brackets, the ^ and - needs to be scaped
        final String REGEX_PATTERN = "^(.+)[.#:\\^\\-](.+$)";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "333.x",
                "Aoobar",
                "fooabar",
                "boobar",
                "Boobar",
                "boo.",
                "hoo?bar",
                "Zoo&bar",
                "zoobar",
                "zoo%aro",
                "s.oobar",
                "coo:bar",
                "co-barr",
                "coo^barr",
                "Cooba#r"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("333.x", "s.oobar", "coo:bar", "Cooba#r", "co-barr", "coo^barr")
        );
    }

    /**
     * * Exercise:
     * - We have to find words:
     * 1. contains a backslash
     * <p>
     * example: xxx\yyy, x\yyy
     * <p>
     * REGEX TO DO THIS
     * \ -> Escapes a regular expression special character
     * . -> Matches any single character.
     * + -> Matches 1 or more repetitions of the previous character or expression.
     */
    @Test
    void testingEscapeABackSlashBetweenTwoFilledStrings() {
        // \ Always need to be escape
        final String REGEX_PATTERN = "^(.+)\\\\(.+$)";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "333\\x",
                "Aoobar",
                "fooabar",
                "boobar",
                "Boobar",
                "boo.",
                "hoo?bar",
                "Zoo&bar",
                "zoobar",
                "zoo%aro",
                "s\\oobar",
                "coo:bar",
                "co-barr",
                "coo^barr",
                "Cooba#r"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
                System.out.println(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("333\\x", "s\\oobar")
        );
    }
}
