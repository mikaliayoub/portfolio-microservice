package com.contact.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.contact.entity.Contact;
import com.contact.repository.ContactRepository;

@RunWith(MockitoJUnitRunner.class)
public class ContactControllerTest {

    @InjectMocks
    private ContactController contactController;

    @Mock
    private ContactRepository contactRepository;

    private List<Contact> contactList;

    @Before
    public void setup() {
        contactList = Arrays.asList(
                new Contact(1, "John Doe", "john@example.com","messasge"),
                new Contact(2, "Jane Smith", "jane@example.com","messasge")
        );

        Mockito.when(contactRepository.findAll()).thenReturn(contactList);
        Mockito.when(contactRepository.findById(anyInt())).thenAnswer(invocation -> {
            int id = invocation.getArgument(0);
            return contactList.stream()
                    .filter(contact -> contact.getId() == id)
                    .findFirst();
        });
    }

    @Test
    public void testGetAllContact() {
        List<Contact> result = contactController.getAllContact();
        assertEquals(2, result.size());
    }

    @Test
    public void testGetContactById() {
        Contact result = contactController.getContactById(1);
        assertNotNull(result);
        assertEquals(1, result.getId());
    }

    @Test
    public void testCreateContact() {
        Contact newContact = new Contact(3, "Alice Johnson", "alice@example.com","messasge");
        Mockito.when(contactRepository.save(newContact)).thenReturn(newContact);
        Contact result = contactController.createContact(newContact);
        assertNotNull(result);
        assertEquals(3, result.getId());
    }

    // Pour le test de UpdateContact, vous pouvez suivre le même modèle que précédemment

    @Test
    public void testDeleteContact() {
        contactController.deleteContact(1);
        Mockito.verify(contactRepository, Mockito.times(1)).deleteById(1);
    }
}

