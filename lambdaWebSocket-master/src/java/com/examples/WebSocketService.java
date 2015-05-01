package com.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.faces.bean.ApplicationScoped;
import javax.websocket.Session;

/**
 *
 * @author edgmarti
 */
@ApplicationScoped
public class WebSocketService {

    private Set<Session> sessions
            = Collections.synchronizedSet(new HashSet<>());
    private List<Person> people = Collections.synchronizedList(new ArrayList<>());
    private static int id = 1;

    public void sendMessage(String message) {
        for (Iterator<Session> iter = sessions.iterator(); iter.hasNext();) {
            Session recipient = iter.next();
            try {
                recipient.getBasicRemote().sendText(message);
            } catch (Exception e) {
                iter.remove();
            }
        }
    }

    public void notifyPeople(Predicate<Person> pred) {
        Set<Session> sessions_subset
                = Collections.synchronizedSet(new HashSet<>());
        Session session;
        for (Person p : people) {
            if (pred.test(p)) {
                session = sessions.stream()
                        .filter(s -> p.getId() == Integer.parseInt(s.getUserProperties().get("id").toString()))
                        .collect(Collectors.toList()).get(0);
                System.out.println("session Id:" + session.getUserProperties().get("id"));
                if (session != null) {
                    sessions_subset.add(session);
                }
            }
        }
        printSession(sessions_subset);

        for (Iterator<Session> iter = sessions.iterator(); iter.hasNext();) {
            Session recipient = iter.next();
            try {
                if (sessions_subset.contains(recipient)) {
                    recipient.getBasicRemote().sendText("background blue");
                }
                else
                {
                    recipient.getBasicRemote().sendText("background red");
                }
            } catch (Exception e) {
                iter.remove();
            }
        }
    }

    public void printSession(Set<Session> sessionList) {
        for (Session s : sessionList) {
            System.out.println("=====================================");
            System.out.println("session.id:" + s.getUserProperties().get("id"));
            System.out.println("=====================================");
        }
    }

    public void printPeople(List<Person> peopleList) {
        for (Person p : peopleList) {
            System.out.println("=====================================");
            System.out.println("person.id:" + p.getId());
            System.out.println("person.givenName:" + p.getGivenName());
            System.out.println("person.surname:" + p.getSurname());
            System.out.println("person.age:" + p.getAge());
            System.out.println("person.gender:" + p.getGender());
            System.out.println("person.email:" + p.getEmail());
            System.out.println("=====================================");
        }
    }

    public List<Person> getPeople() {
        return people;
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public Set<Session> getSessions() {
        return sessions;
    }

    public void add(Session session) {
        session.getUserProperties().put("id", id++);
        sessions.add(session);
    }

    public void remove(Session session) {
        sessions.remove(session);
        people.removeIf(person -> person.getId() == Integer.parseInt(session.getUserProperties().get("id").toString()));
        printPeople(people);
    }
}
