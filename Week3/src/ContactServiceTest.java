import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	private ContactService contactService;

	@BeforeEach
    void setUp() {
        contactService = new ContactService();
    }
	
	@Test
    void testAddContact() {
        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("12345"));
    }

    @Test
    void testAddContactDuplicateId() {
        Contact contact1 = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
        Contact contact2 = new Contact("12345", "John", "Doe", "0987654321", "another address 22");
        contactService.addContact(contact1);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    @Test
    void testDeleteContact() {
        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
        contactService.addContact(contact);
        contactService.deleteContact("12345");
        assertNull(contactService.getContact("12345"));
    }

    @Test
    void testDeleteNonexistentContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("12345");
        });
    }

    @Test
    void testUpdateContact() {
        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
        contactService.addContact(contact);
        contactService.updateContact("12345", "John", "Doe", "0987654321", "new address 22");
        assertEquals("John", contactService.getContact("12345").getFirstName());
        assertEquals("Doe", contactService.getContact("12345").getLastName());
        assertEquals("0987654321", contactService.getContact("12345").getPhone());
        assertEquals("new address 22", contactService.getContact("12345").getAddress());
    }

    @Test
    void testUpdateNonexistentContact() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("12345", "John", "Doe", "0987654321", "new address 22");
        });
    }

    @Test
    void testUpdateContactWithInvalidFirstName() {
        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
        contactService.addContact(contact);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("12345", "JohnJacobJingleheimer", "Doe", "0987654321", "new address 22");
        });
    }

    @Test
    void testUpdateContactWithInvalidPhone() {
        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
        contactService.addContact(contact);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("12345", "John", "Doe", "123", "new address 22");
        });
    }
    
    @Test
    void testUpdateContactWithInvalidAddress() {
        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
        contactService.addContact(contact);
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.updateContact("12345", "John", "Doe", "0987654321", "This is a very long address that exceeds thirty characters");
        });
    }

}
