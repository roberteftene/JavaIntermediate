package pluralsight.javacourse.classes;

import java.time.LocalDate;

public class HumanKind {

    private String name;
    private LocalDate dateOfBirth;

    public HumanKind() {}

    public HumanKind(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "HumanKind{" +
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
