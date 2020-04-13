package pluralsight.javacourse.main;

import pluralsight.javacourse.classes.Person;
import pluralsight.javacourse.classes.PersonMaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergingMaps {

    public static void main(String[] args) {

        List<PersonMaps> persons = new ArrayList<>();

        try(BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                MergingMaps.class.getResourceAsStream("peopleMaps.txt")));

            Stream<String> stream = reader.lines();

        ) {

            stream.map(line -> {
                String[] s = line.split(" ");
                PersonMaps p = new PersonMaps(s[0].trim(),Integer.parseInt(s[1]),s[2].trim());
                persons.add(p);
                return p;
            })
                    .forEach(System.out::println);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        List<PersonMaps> list1 = persons.subList(1,10);
        List<PersonMaps> list2 = persons.subList(10,persons.size());

        Map<Integer,List<PersonMaps>> map1 = mapByAge(list1);
        System.out.println("Map 1:");
        map1.forEach((age,list) -> System.out.println(age + " -> " + list));

        Map<Integer,List<PersonMaps>> map2 = mapByAge(list2);
        System.out.println("Map 2:");
        map2.forEach((age,list) -> System.out.println(age + " -> " + list) );


        map2.entrySet().stream()
                .forEach(
                        entry ->
                                map1.merge(
                                        entry.getKey(),
                                        entry.getValue(),
                                        (l1, l2) -> {
                                            l1.addAll(l2);
                                            return l1;
                                        }
                                )
                );

        System.out.println("Map 1 merged:");
        map1.forEach((age, list) -> System.out.println(age + " -> " + list));
    }

    private static Map<Integer,List<PersonMaps>> mapByAge(List<PersonMaps> list) {
        Map<Integer,List<PersonMaps>> map =
                list.stream().collect(
                        Collectors.groupingBy(
                                PersonMaps::getAge
                        )
                );
        return map;
    }

}
