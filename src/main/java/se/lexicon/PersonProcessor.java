
package se.lexicon;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class PersonProcessor {
    public List<Person> findPeople(List<Person> people, Predicate<Person> rule) {
        List<Person> result = new ArrayList<>();
        for (Person person : people) {
            if (rule.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
    public void applyToMatching(List<Person> people, Predicate<Person> rule, Consumer<Person> action) {
        for (Person person : people) {
            if (rule.test(person)) {
                action.accept(person);
            }
        }
    }
}
