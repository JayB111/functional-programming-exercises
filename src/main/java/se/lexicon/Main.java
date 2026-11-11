
package se.lexicon;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        Predicate<Person> isActive = person -> person.isActive();
        Predicate<Person> isAdult = person -> person.getAge() >= 18;
        Predicate<Person> notActive = person -> !person.isActive();
        Predicate<Person> livesInStockholm =
                person -> person.getCity().equals("Stockholm");
        Predicate<Person> activeAdult =
                person -> person.isActive() && person.getAge() >= 18;
        Predicate<Person> adultOrStockholm =
                person -> person.getAge() >= 18
                        || person.getCity().equals("Stockholm");
        Consumer<Person> printName =
                person -> System.out.println(person.getName());
        Consumer<Person> sendEmail =
                person -> System.out.println("Send email to " + person.getName());
        List<Person> people = List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        );
        System.out.println("\n==========================================");
        System.out.println("PART 1 - FUNCTIONAL PROGRAMMING");
        System.out.println("==========================================");
        System.out.println("\n\u001B[3;4mActive people:\u001B[0m");
        filterPeople(people, isActive);
        System.out.println("\n\u001B[3;4mAdults:\u001B[0m");
        filterPeople(people, isAdult);
        System.out.println("\n\u001B[3;4mPeople living in Stockholm:\u001B[0m");
        filterPeople(people, livesInStockholm);
        System.out.println("\n\u001B[3;4mActive adults:\u001B[0m");
        filterPeople(people, activeAdult);
        System.out.println("\n\u001B[3;4mAdults OR people living in Stockholm:\u001B[0m");
        filterPeople(people, adultOrStockholm);
        System.out.println("\n\u001B[3;4mInactive people:\u001B[0m");
        filterPeople(people, notActive);
        System.out.println("\n\u001B[3;4mPrint first person's name:\u001B[0m");
        printName.accept(people.get(0));
        System.out.println("\n\u001B[3;4mSend email to first person:\u001B[0m");
        sendEmail.accept(people.get(0));
        PersonProcessor processor = new PersonProcessor();
        List<Person> adultsFound = processor.findPeople(people, isAdult);
        System.out.println("\n\u001B[3;4mAdults found using PersonProcessor:\u001B[0m");
        adultsFound.forEach(person -> System.out.println(
                person.getName() + " (" + person.getAge()
                        + ") - " + person.getCity()));
        System.out.println("\n\u001B[3;4mSending emails to active people:\u001B[0m");
        processor.applyToMatching(people, isActive, sendEmail);
        System.out.println("\n==========================================");
        System.out.println("PART 2 - STREAM API");
        System.out.println("==========================================");
        System.out.println("\n\u001B[3;4mActive people:\u001B[0m");
        people.stream()
                .filter(person -> person.isActive())
                .forEach(person -> System.out.println(
                        person.getName() + " (" + person.getAge()
                                + ") - " + person.getCity()));
        System.out.println("\n\u001B[3;4mAll names:\u001B[0m");
        people.stream()
                .map(person -> person.getName())
                .forEach(System.out::println);
        System.out.println("\n\u001B[3;4mNumber of adults:\u001B[0m");
        long adultCount = people.stream()
                .filter(person -> person.getAge() >= 18)
                .count();
        System.out.println("\u001B[3;4mTotal adults: \u001B[0m" + adultCount);
        System.out.println("\n\u001B[3;4mPeople sorted by age:\u001B[0m");
        people.stream()
                .sorted((person1, person2) ->
                        Integer.compare(person1.getAge(), person2.getAge()))
                .forEach(person -> System.out.println(
                        person.getName() + " (" + person.getAge()
                                + ") - " + person.getCity()));
        System.out.println("\n\u001B[3;4mFirst active person in Stockholm:\u001B[0m");
        people.stream()
                .filter(person -> person.isActive())
                .filter(person -> person.getCity().equals("Stockholm"))
                .findFirst()
                .ifPresent(person -> System.out.println(
                        person.getName() + " (" + person.getAge()
                                + ") - " + person.getCity()));
        System.out.println("\n\u001B[3;4mActive adults:\u001B[0m");
        people.stream()
                .filter(person -> person.isActive())
                .filter(person -> person.getAge() >= 18)
                .forEach(person -> System.out.println(
                        person.getName() + " (" + person.getAge()
                                + ") - " + person.getCity()));
        System.out.println("\n\u001B[3;4mActive people in Stockholm:\u001B[0m");
        people.stream()
                .filter(person -> person.isActive())
                .filter(person -> person.getCity().equals("Stockholm"))
                .forEach(person -> System.out.println(
                        person.getName() + " (" + person.getAge()
                                + ") - " + person.getCity()));
        System.out.println("\n\u001B[3;4mInactive people older than 30:\u001B[0m");
        people.stream()
                .filter(person -> !person.isActive())
                .filter(person -> person.getAge() > 30)
                .forEach(person -> System.out.println(
                        person.getName() + " (" + person.getAge()
                                + ") - " + person.getCity()));
        System.out.println("\n\u001B[3;4mUnique cities:\u001B[0m");
        people.stream()
                .map(person -> person.getCity())
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("\n\u001B[3;4mUnique first letters of names:\u001B[0m");
        people.stream()
                .map(person -> person.getName().substring(0, 1))
                .distinct()
                .sorted()
                .forEach(System.out::println);
        System.out.println("\n\u001B[3;4mFormatted people:\u001B[0m");
        people.stream()
                .map(person -> person.getName() + " (" + person.getAge()
                        + ") - " + person.getCity())
                .forEach(System.out::println);
        System.out.println("\n\u001B[3;4mEmail addresses:\u001B[0m");
        people.stream()
                .map(person -> person.getName().toLowerCase() + "@example.com")
                .forEach(System.out::println);
        System.out.println("\n==========================================");
        System.out.println("END OF EXERCISES YAY!!!  🥳🎉");
        System.out.println("==========================================");
    }
       public static void filterPeople(List<Person> people, Predicate<Person> rule) {
        for (Person person : people) {
            if (rule.test(person)) {
                System.out.println(
                        person.getName() + " (" + person.getAge()
                                + ") - " + person.getCity());
            }
        }
    }
}
