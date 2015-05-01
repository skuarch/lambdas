package com.examples;

import java.io.IOException;
import java.io.Reader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author edgmarti
 */
public class LambdaWebSocketDecoder implements Decoder.TextStream<Person> {

    @Override
    public void init(EndpointConfig config) {
        System.out.println("Entered init...");
    }

    @Override
    public void destroy() {
    }

    @Override
    public Person decode(Reader reader) throws DecodeException, IOException {
        try (JsonReader jsonReader = Json.createReader(reader)) {
            JsonObject jsonObject = jsonReader.readObject();
            Person person = new Person();
            person.setGivenName(jsonObject.getString("givenName"));
            person.setSurname(jsonObject.getString("surname"));
            person.setAge(Integer.parseInt(jsonObject.getString("age")));
            person.setGender(jsonObject.getString("gender"));
            person.setEmail(jsonObject.getString("email"));
            return person;
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            throw new IOException(e);
        }
    }
}
