package com.contact.entity;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ContactTest {

    @Test
    public void testConstructorAndGetters() {
        // Arrange
        int id = 1;
        String name = "John Doe";
        String email = "john@example.com";
        String message = "Hello, world!";

        // Act
        Contact contact = new Contact(id, name, email, message);

        // Assert
        Assert.assertEquals(id, contact.getId());
        Assert.assertEquals(name, contact.getName());
        Assert.assertEquals(email, contact.getEmail());
        Assert.assertEquals(message, contact.getMessage());
    }

    @Test
    public void testSetters() {
        // Arrange
        Contact contact = new Contact();

        // Act
        int id = 2;
        String name = "Jane Smith";
        String email = "jane@example.com";
        String message = "Testing setters";

        contact.setId(id);
        contact.setName(name);
        contact.setEmail(email);
        contact.setMessage(message);

        // Assert
        Assert.assertEquals(id, contact.getId());
        Assert.assertEquals(name, contact.getName());
        Assert.assertEquals(email, contact.getEmail());
        Assert.assertEquals(message, contact.getMessage());
    }
}
