import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
		assertTrue(contact.getContactId().equals("12345"));
		assertTrue(contact.getFirstName().equals("Michael"));
		assertTrue(contact.getLastName().equals("Michaels"));
		assertTrue(contact.getPhone().equals("1231231234"));
		assertTrue(contact.getAddress().equals("blank address 11"));
	}
	@Test
	void testContactContactIdToLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Michael", "Michaels", "1231231234", "blank address 11"); 
		});
	}
	@Test
	void testContactContactIdNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Michael", "Michaels", "1231231234", "blank address 11"); 
		});
	}
	@Test
	void testContactFirstNameToLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Michaeleahcim", "Michaels", "1231231234", "blank address 11"); 
		});
	}
	@Test
	void testContactFirstNameNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", null, "Michaels", "1231231234", "blank address 11"); 
		});
	}
	@Test
	void testContactLastNameToLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Michael", "Michaelsleahcim", "1231231234", "blank address 11"); 
		});
	}
	@Test
	void testContactLastNameNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Michael", null, "1231231234", "blank address 11"); 
		});
	}
	@Test
	void testContactPhoneToLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Michael", "Michaels", "123123123412345", "blank address 11"); 
		});
	}
	@Test
	void testContactPhoneNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Michael", "Michaels", null, "blank address 11"); 
		});
	}
	@Test
	void testContactAddressToLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Michael", "Michaels", "1231231234", "30 characters blank address street"); 
		});
	}
	@Test
	void testContactAddressNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678911", "Michael", "Michaels", "1231231234", null); 
		});
	}
	 @Test
	    void testSetFirstName() {
	        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
	        contact.setFirstName("John");
	        assertEquals("John", contact.getFirstName());

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            contact.setFirstName("JohnJacob");
	        });

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            contact.setFirstName(null);
	        });
	    }

	    @Test
	    void testSetLastName() {
	        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
	        contact.setLastName("Doe");
	        assertEquals("Doe", contact.getLastName());

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            contact.setLastName("DoeDoeDoeDoe");
	        });

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            contact.setLastName(null);
	        });
	    }

	    @Test
	    void testSetPhone() {
	        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
	        contact.setPhone("0987654321");
	        assertEquals("0987654321", contact.getPhone());

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            contact.setPhone("123456789012");
	        });

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            contact.setPhone(null);
	        });

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            contact.setPhone("12345");
	        });
	    }

	    @Test
	    void testSetAddress() {
	        Contact contact = new Contact("12345", "Michael", "Michaels", "1231231234", "blank address 11");
	        contact.setAddress("new address 22");
	        assertEquals("new address 22", contact.getAddress());

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            contact.setAddress("This is a very very long address exceeding the limit");
	        });

	        Assertions.assertThrows(IllegalArgumentException.class, () -> {
	            contact.setAddress(null);
	        });
	    }
	
}
