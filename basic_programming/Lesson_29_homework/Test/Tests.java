import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Tests {
    @Test
    public void testSameDataFounder() {
        Set<String> one = new HashSet<>();
        one.add("one");
        one.add("two");
        one.add("three");
        one.add("four");

        Set<String> two = new HashSet<>();
        two.add("three");
        two.add("four");
        two.add("five");
        two.add("six");

        Set<String> expected = new HashSet<>();
        expected.add("three");
        expected.add("four");

        Assertions.assertEquals(expected, Main.sameDataFounder(one, two));
    }

    @Test
    public void testSameDataFounderWIthNoSameElements() {
        Set<String> one = new HashSet<>();
        one.add("one");
        one.add("two");

        Set<String> two = new HashSet<>();
        two.add("three");
        two.add("four");
        two.add("five");
        two.add("six");

        Set<String> expected = new HashSet<>();

        Assertions.assertEquals(expected, Main.sameDataFounder(one, two));
    }

    @Test
    public void testSameDataFounderWithAllSameElements() {
        Set<String> one = new HashSet<>();
        one.add("one");
        one.add("two");
        one.add("three");
        one.add("four");

        Set<String> two = new HashSet<>();
        two.add("one");
        two.add("two");
        two.add("three");
        two.add("four");

        Set<String> expected = new HashSet<>();
        expected.add("one");
        expected.add("two");
        expected.add("three");
        expected.add("four");

        Assertions.assertEquals(expected, Main.sameDataFounder(one, two));
    }

    @Test
    public void testSameDataFounderWIthEmptySets() {
        Set<String> one = new HashSet<>();
        Set<String> two = new HashSet<>();
        Set<String> expected = new HashSet<>();

        Assertions.assertEquals(expected, Main.sameDataFounder(one, two));
    }
}
