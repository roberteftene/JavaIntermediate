package pluralsight.javacourse.main;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapExample {

    public static void main(String[] args) {

        List<Integer> l1 = Arrays.asList(1,2,3,4,5,6,7);
        List<Integer> l2 = Arrays.asList(2,4,6);
        List<Integer> l3 = Arrays.asList(3,5,7);

        List<List<Integer>> list = Arrays.asList(l1,l2,l3);

        System.out.println(list);

        Function<List<?>, Integer> size = List::size;
        Function<List<Integer>, Stream<Integer>> flatmapper = l -> l.stream();

        list.stream()
                .flatMap(flatmapper)
                .forEach(System.out::println);




    }

}
