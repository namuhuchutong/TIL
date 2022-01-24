package me.pepeprmill.java8;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WhyJava8 {
    private static final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

    public static void main(String[] args) throws IOException {
        /// 1 : 2 : 3 : ... : 10
        // 이것을 만들고 싶다.


        // old java
        simpleTaskOld();
        // forEach java
        forEachJava();
        // java 8
        java8();

        // old java
        readFileOld();
        // java 8
        readFile8();
    }

    private static void simpleTaskOld() {
        final StringBuilder str1 = new StringBuilder();
        final int size = numbers.size();
        for (int i = 0; i < size; i++) {
            str1.append(numbers.get(i));
            if (i != size -1)
                str1.append(" : ");
        }

        System.out.println("old java = " + str1);
    }

    private static void forEachJava() {
        final StringBuilder str2 = new StringBuilder();
        final String separator = " : ";
        for (final Integer number : numbers) {
            str2.append(number).append(separator);
        }

        final int stringLength = str2.length();
        if (stringLength > 0) {
            str2.delete(stringLength - separator.length(), stringLength);
        }

        System.out.println("forEach = " + str2);
    }

    private static void java8() {
        final String result = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" : "));
        System.out.println("java 8 = " + result);
    }

    private static void readFileOld() {
        try (final FileReader fileReader = new FileReader(new File("/tmp/test.txt"));
             final BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            final List<String> uniqueWords = new ArrayList<>();
            String line = bufferedReader.readLine();
            while (line != null) {
                final String[] words = line.split("[\\s]+");
                for (final String word : words) {
                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }
                }
                line = bufferedReader.readLine();
            }
            Collections.sort(uniqueWords);
            System.out.println(uniqueWords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile8() throws IOException {
        try(final Stream<String> lines = Files.lines(Paths.get("/tmp/test.txt"))) {
            System.out.println(
                    lines.map(line -> line.split("[\\s]+"))
                            .flatMap(Arrays::stream)
                            .distinct()
                            .sorted()
                            .collect(Collectors.toList())
            );
        }
    }
}
