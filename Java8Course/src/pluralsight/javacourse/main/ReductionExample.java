package pluralsight.javacourse.main;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {

    public static void main(String[] args) {

        List<Integer> list  = Arrays.asList(10,12,10);
        Integer sum = list.stream()
                .reduce(0,Integer::sum);

        Optional<Integer> max = list.stream()
                .reduce(Integer::max);

        System.out.println("Sum = " + sum);
        System.out.println("Max = " + max);
    }

}
