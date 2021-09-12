package no.hvl.dat250.jpa.basicexample;

import no.hvl.dat250.jpa.basicexample.exp2.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
/*
** Main class used in exp1 with the T o d o class.
public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "todos";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        Query q = em.createQuery("select t from Todo t");
        List<Todo> todoList = q.getResultList();
        for (Todo todo : todoList) {
            System.out.println(todo);
        }
        System.out.println("Size: " + todoList.size());

        // create new todo
        em.getTransaction().begin();
        Todo todo = new Todo();
        todo.setSummary("This is a test");
        todo.setDescription("This is a test");
        em.persist(todo);
        em.getTransaction().commit();

        em.close();
    }

 */
public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "bank";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();

        Address address = new Address();
        address.setStreet("Inndalsveien");
        address.setNumber(28);

        Bank bank = new Bank();
        bank.setName("Pengebank");

        CreditCard creditCard1 = new CreditCard();
        creditCard1.setNumber(12345);
        creditCard1.setBalance(-5000);
        creditCard1.setLimit(-10000);

        CreditCard creditCard2 = new CreditCard();
        creditCard2.setNumber(123);
        creditCard2.setBalance(1);
        creditCard2.setLimit(2000);

        Person person = new Person();
        person.setName("Max Mustermann");

        Pincode pincode = new Pincode();
        pincode.setPincode("123");
        pincode.setCount(1);

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(person);
        address.setPersons(persons);

        ArrayList<CreditCard> creditCards = new ArrayList<>();
        creditCards.add(creditCard1);
        //creditCards.add(creditCard2);
        bank.setCreditCards(creditCards);

        creditCard1.setBank(bank);
        creditCard1.setPincode(pincode);

        ArrayList<Address> addresses = new ArrayList<>();
        addresses.add(address);
        person.setAddresses(addresses);
        person.setCreditCards(creditCards);

        em.persist(address);
        em.persist(bank);
        em.persist(creditCard1);
       // em.persist(creditCard2);
        em.persist(person);
        em.persist(pincode);
        em.getTransaction().commit();
        em.close();

    }

}
