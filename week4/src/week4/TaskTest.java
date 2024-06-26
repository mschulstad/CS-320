package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	@Test
	void testTask() {
		Task task = new Task("2xc3bh45", "object name", "does something");
		assertTrue(task.getTaskId().equals("2xc3bh45"));
		assertTrue(task.getName().equals("object name"));
		assertTrue(task.getDescription().equals("does something"));
	}
	@Test
	void testTaskTaskIdToLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12xc3bh45678911", "object name", "does something"); 
		});
	}
	@Test
	void testTaskTaskIdNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "object name", "does something");
		});
	}
	@Test
	void testTaskNameToLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678", "object name is too long ", "does something"); 
		});
	}
	@Test
	void testTaskNameNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678", null, "does something"); 
		});
	}
	@Test
	void testTaskDescriptionToLong(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("123456789", "object name", "the description of theis object is that it does something"); 
		});
	}
	@Test
	void testTaskDescriptionNull(){
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task("12345678", "object name", null); 
		});
	}
	@Test
    void testSetName() {
        Task task = new Task("12345", "thing", "something");
        task.setName("John");
        assertEquals("John", task.getName());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setName("JohnJacob");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }
	@Test
    void testSetDescription() {
        Task task = new Task("12345", "thing", "something");
        task.setDescription("bouncing object");
        assertEquals("bouncing object", task.getDescription());

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription("very long description of a bouncing obect that bounces");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            task.setDescription(null);
        });
    }
}
