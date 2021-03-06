package pluralsight.javacourse.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {

    public static void main(String[] args) {

        List<String> strings = Arrays.asList("one", "two", "three", "four", "five");

        List<String> result = new ArrayList<>();

        //Lambda
        Consumer<String> c1 = s -> System.out.println(s);
        Consumer<String> c2 = s -> result.add(s);

        //Method reference
//        Consumer<String> c1 = System.out::println;

        System.out.println(result.size());
        strings.forEach(c1.andThen(c2));
        System.out.println(result.size());

//        strings.forEach(System.out::println);

//        strings.forEach(s -> System.out.println(s));




    }
}
