package regex;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexAnchorTest {

    /**
     * * Exercise:
     * - We have to find words:
     * 1. starts with foo
     * <p>
     * example: foobar, foocar, foolar
     * <p>
     * REGEX TO DO THIS
     * ^ -> Matches the beginning of a line.
     * . -> Matches any single character.
     * * ->	Matches 0 or more repetitions of the previous character or expression.
     */
    @Test
    void testingStartWith() {
        final String REGEX_PATTERN = "^foo.*";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "333.x",
                "Aoobar",
                "fooabar",
                "boobar",
                "foobar",
                "foo",
                "fo",
                "hoo?bar",
                "Zoo&bar",
                "zoobar",
                "zoo%aro",
                "s.oobar",
                "coo:bar",
                "foo:bar",
                "Cooba#r"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("foo", "fooabar", "foobar", "foo:bar")
        );
    }

    /**
     * * Exercise:
     * - We have to find words:
     * 1. ends with bar
     * <p>
     * example: xxxxbar, x:bar, yxiahd|bar
     * <p>
     * REGEX TO DO THIS
     * $ ->	Matches the end of the line.
     * . -> Matches any single character.
     * * ->	Matches 0 or more repetitions of the previous character or expression.
     */
    @Test
    void testingEndsWith() {
        final String REGEX_PATTERN = ".*bar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "333.x",
                "Aoobar",
                "fooabar",
                "boobar",
                "foobar",
                "foo",
                "fo",
                "hoo?bar",
                "Zoo&bar",
                "zoobar",
                "zoo%aro",
                "s.oobar",
                "coo:bar",
                "foo:bar",
                "Cooba#r"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }

        assertThat(matches).hasSameElementsAs(
                List.of("Aoobar", "fooabar", "boobar", "foobar", "hoo?bar", "Zoo&bar", "zoobar", "s.oobar", "coo:bar", "foo:bar")
        );
    }

}
