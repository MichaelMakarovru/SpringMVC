package ru.mike.springMVC.dao;

import org.springframework.stereotype.Component;
import ru.mike.springMVC.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT,"Tom",32,"Tom@email.com"));
        people.add(new Person(++PEOPLE_COUNT,"Bob",44,"Bob@email.com"));
        people.add(new Person(++PEOPLE_COUNT,"Mike",51,"Mike@email.com"));
        people.add(new Person(++PEOPLE_COUNT,"Jhon",22,"Jhon@email.com"));
        people.add(new Person(++PEOPLE_COUNT,"Katy",27,"Katy@email.com"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson){
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatePerson.getName() );
        personToBeUpdated.setAge(updatePerson.getAge());
        personToBeUpdated.setEmail(updatePerson.getEmail());
    }

    public void delete(int id){
        people.removeIf(p -> p.getId() == id);
    }
}
