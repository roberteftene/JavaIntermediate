package pluralsight.javacourse.main;

import pluralsight.javacourse.classes.HumanKind;
import pluralsight.javacourse.classes.Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DateAndTime {

    public static void main(String[] args) {

        List<HumanKind> humans = new ArrayList<>();

        try (BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(
                                     DateAndTime.class.getResourceAsStream("PeopleDates.txt")));

             Stream<String> stream = reader.lines();
        ) {
            stream.map(line -> {
                String[] s = line.split(" ");
                int year = Integer.parseInt(s[1]);
                Month month = Month.of(Integer.parseInt(s[2]));
                int day = Integer.parseInt(s[3]);
                HumanKind h = new HumanKind(s[0].trim(), LocalDate.of(year,month,day));
                humans.add(h);
                return h;
            })
                    .forEach(System.out::println);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }

        LocalDate now = LocalDate.of(2020, Month.APRIL, 13);

        humans.stream().forEach(
                p-> {
                    Period period = Period.between(p.getDateOfBirth(),now);
                    System.out.println(p.getName() + " was born "
                                    + period.get(ChronoUnit.YEARS) + " years"
                                    + " and " + period.get(ChronoUnit.MONTHS) + " months ago!"
                            );
                }
        );

        for (HumanKind p: humans) {
            Period period = Period.between(p.getDateOfBirth(),now);
            System.out.println(p.getName() + " was born "
                    + period.get(ChronoUnit.YEARS) + " years"
                    + " and " + period.get(ChronoUnit.MONTHS) + " months ago!"
            );
        }


    }
}