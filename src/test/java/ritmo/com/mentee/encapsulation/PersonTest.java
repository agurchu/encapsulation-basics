package ritmo.com.mentee.encapsulation;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testParameterizedConstructorAndGetters() {
        Person person = new Person("Katlego", 28, "katlego@example.com");

        assertEquals("Katlego", person.getName());
        assertEquals(28, person.getAge());
        assertEquals("katlego@example.com", person.getEmail());
    }

    @Test
    void testSettersWithValidation() {
        Person person = new Person();

        person.setName("John Doe");
        person.setAge(35);
        person.setEmail("john@example.com");

        assertEquals("John Doe", person.getName());
        assertEquals(35, person.getAge());
        assertEquals("john@example.com", person.getEmail());
    }

    @Test
    void testInvalidInputsThrowException() {
        Person person = new Person();

        assertThrows(IllegalArgumentException.class, () -> person.setName(""));
        assertThrows(IllegalArgumentException.class, () -> person.setName(null));
        assertThrows(IllegalArgumentException.class, () -> person.setAge(-5));
        assertThrows(IllegalArgumentException.class, () -> person.setAge(200));
        assertThrows(IllegalArgumentException.class, () -> person.setEmail("invalid-email"));
    }

    @Test
    void testCopyConstructor() {
        Person original = new Person("Alice", 30, "alice@test.com");
        Person copy = new Person(original);

        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());
        assertEquals(original.getEmail(), copy.getEmail());
    }
}