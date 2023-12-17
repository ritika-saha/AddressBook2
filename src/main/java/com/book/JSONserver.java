package com.book;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class JSONserver {
    static final int PORT = 3000;
    HttpServer server;
    List<Person> jsonData;

    public JSONserver() throws IOException {
        this.server = HttpServer.create(new InetSocketAddress(PORT), 0);
        this.jsonData = initializeData();
        this.server.createContext("/addressBook", new AddressBookHandler(jsonData));
    }

    public List<Person> initializeData() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Read JSON data from the file and convert it to a List<Person>
            return objectMapper.readValue(
                    new File("AddressBookDir/AddressBookDataDB.json"),
                    new TypeReference<List<Person>>() {}
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Collections.emptyList(); // Return an empty list if there's an error
    }

    public void startServer() throws IOException {
        this.server.start();
        System.out.println("JSON server started on port " + PORT);
    }

    public void readAndPrintData() {
        try {
            URL url = new URL("http://localhost:3000/addressBook");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    String line;
                    StringBuilder response = new StringBuilder();

                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                    }
                    System.out.println("Data from server\n" + response.toString());
                }
            } else {
                System.out.println("Failed to retrieve data: Response Code " + responseCode);
            }
            connection.disconnect();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static class AddressBookHandler implements HttpHandler {
        List<Person> jsonData;

        public AddressBookHandler(List<Person> jsonData) {
            this.jsonData = jsonData;
        }

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            exchange.getResponseHeaders().set("Content-Type", "application/json");

            if (exchange.getRequestURI().getPath().equals("/addressBook")) {
                StringBuilder response = new StringBuilder("[");
                boolean first = true;

                ObjectMapper objectMapper = new ObjectMapper();

                for (Person person : jsonData) {
                    if (!first) {
                        response.append(",");
                    }
                    String jsonPerson = objectMapper.writeValueAsString(person);
                    response.append(jsonPerson);
                    first = false;
                }
                response.append("]");

                String jsonResponse = response.toString();
                System.out.println(jsonResponse);
                byte[] jsonResponseBytes = jsonResponse.getBytes();
                exchange.sendResponseHeaders(200, jsonResponseBytes.length);
                try (OutputStream outputStream = exchange.getResponseBody()) {
                    outputStream.write(jsonResponseBytes);
                }
            } else {
                exchange.sendResponseHeaders(404, 0);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        JSONserver jsonServerApp = new JSONserver();
        jsonServerApp.startServer();
        jsonServerApp.readAndPrintData();
    }
}
