package com.examples;

import java.io.IOException;
import java.util.function.Predicate;
import javax.faces.bean.ApplicationScoped;

import javax.inject.Inject;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ApplicationScoped
@ServerEndpoint(value = "/lambdaWebSocket",
        decoders = {LambdaWebSocketDecoder.class})
public class LambdaWebSocket {

    @Inject
    private WebSocketService webSocketService;

    Predicate<Person> allDrivers = p -> p.getAge() >= 16;
    Predicate<Person> allDraftees = p -> p.getAge() >= 18 && p.getAge() <= 25 && p.getGender().equalsIgnoreCase("male");
    Predicate<Person> allPilots = p -> p.getAge() >= 23 && p.getAge() <= 65;

    @OnOpen
    public void onOpen(Session session) throws IOException {
        webSocketService.add(session);
        System.out.println("session.getUserProperties().get(\"id\") = " + session.getUserProperties().get("id").toString());
    }

    @OnMessage
    public void onMessage(Person person, Session session) {
        person.setId(Integer.parseInt(session.getUserProperties().get("id").toString()));
        webSocketService.addPerson(person);
        webSocketService.printPeople(webSocketService.getPeople());
        webSocketService.sendMessage("thanks");
        if (person.getGivenName().equalsIgnoreCase("run")) {
            webSocketService.notifyPeople(allDrivers);
        }
    }

    @OnClose
    public void onClose(Session session) {
        webSocketService.remove(session);
    }
}
