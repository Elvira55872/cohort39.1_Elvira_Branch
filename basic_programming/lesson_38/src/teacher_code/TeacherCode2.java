package teacher_code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TeacherCode2 {
    public static void main(String[] args) throws IOException {
//        Collection<Integer> collection = Set.of(1, 2, 3, 4, 5, 6, 7);
//        Integer oldOdd = 0;
//        for (Integer i : collection) {
//            if (i % 2 != 0) {
//                oldOdd += i;
//            }
//        }
//
//        Stream<Integer> stream = getStreamFromFile();
//
//        //IntStream intStream = getStreamFromPrimitiveValues();
//
//        Integer oddsSum = stream
//                .filter(e -> e % 2 == 1)
//                .reduce((c1, c2) -> c1 + c2)
//                .orElse(0);
//
//
//        System.out.println("oldOdd = " + oldOdd);
//        System.out.println("oddsSum = " + oddsSum);
//        System.out.println("oldOdd == oddsSum = " + (oldOdd == oddsSum));

        Stream<Integer> stream = getStreamFromArray();

        // демонстрация конвеерных оперций
        stream
                .filter(e -> e > 3)
                .sorted((e1, e2) -> e2 - e1)
                .distinct()
                .peek(e -> System.out.print(e + " "))
                .map(x -> x + 10)
                .limit(2)
                .forEach(e -> System.out.println(e));


        System.out.println(getStreamFromArray().findFirst().get());
        System.out.println(getStreamFromArray()
                .filter(x -> x > 5)
                .findAny().get());

        Set<Integer> set = getStreamFromArray().filter(x -> x > 2).collect(Collectors.toSet());

        long countUnique = getStreamFromArray().distinct().count();

        boolean containTen = getStreamFromArray().anyMatch(x -> x == 10);
        boolean dontContainTen = getStreamFromArray().noneMatch(x -> x == 10);
        boolean allMatch = getStreamFromArray().allMatch(x -> x > -1);

        System.out.println("containTen = " + containTen);
        System.out.println("dontContainTen = " + dontContainTen);
        System.out.println("allMatch = " + allMatch);


        Integer min = getStreamFromArray().min((e1, e2) -> e1-e2).get();
        Integer max = getStreamFromArray().max((e1, e2) -> e1-e2).get();

        System.out.println("min = " + min);
        System.out.println("max = " + max);

        Integer[] nums = getStreamFromArray().toArray(Integer[]::new);

        System.out.println(Arrays.toString(nums));

    }

    static Stream<Integer> getStreamFromCollection(Collection<Integer> collection) {
        return collection.stream();
    }

    static Stream<Integer> getStreamFromValues() {
        return Stream.of(1, 2, 3, 4, 5, 6, 7);
    }

    static IntStream getStreamFromPrimitiveValues() {
        return IntStream.of(1, 2, 3, 4, 5, 6, 7);
    }

    static Stream<Integer> getStreamFromArray() {
        Integer[] nums = {1, 2, 3, 4, 5, 3, 4, 5, 6, 7};

        return Arrays.stream(nums);
    }

    static Stream<Integer> getStreamFromFile() throws IOException {
        Stream<String> fromFileS = Files.lines(Paths.get("basic_programming/lesson_38/src/teacher_code/file.txt"));

        return fromFileS
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList()).stream();
    }

    static Stream getStreamFromStreamBuilder() {
        Stream<Object> stream = Stream.builder()
                .add(1)
                .add(2)
                .add(3)
                .add(4)
                .add(5)
                .add(6)
                .add(7)
                .build();

        return stream;
    }

}
