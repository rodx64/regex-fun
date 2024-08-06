package regex;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

public class RegexPipeTest {


    /**
     * * Exercise:
     * - We have to find words:
     * 1. starting with far or mar
     * 2. ending with obar
     * <p>
     * example: aoobar,
     * hoobar,
     * zoobar
     * <p>
     * REGEX TO DO THIS
     * (...) -> Groups a set of matching characters together. Multiple groups can be specified.
     * | -> Matches either one expression or an alternative expression.
     */
    @Test
    void testingWithSpecificWordAfterAndStartingWithSpecificLetters() {
        final String REGEX_PATTERN = "^(far|mar)oobar$";
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        final String[] valuesToMatch = {
                "faroobar",
                "fooabar",
                "hoobar",
                "Zoobar",
                "zoobar",
                "zoobaro",
                "s oobar",
                "maroobar",
                "marobar"
        };
        List<String> matches = new ArrayList<>();

        for (String value : valuesToMatch) {
            if (pattern.matcher(value).find()) {
                matches.add(value);
            }
        }
        assertThat(matches).hasSameElementsAs(
                List.of("faroobar", "maroobar")
        );
    }


}
