package fr.unantes.sce.calendar;


import fr.unantes.sce.people.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.InvalidClassException;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;




public class CalendarTest {

    private Calendar calendar;

    @BeforeEach
    public void setUp() throws InvalidClassException {
        Person owner = new Person ("joe", "admin");
        calendar = new Calendar(owner);
    }

    @Test
    void testSetOwner () throws InvalidClassException {
        Person owner = new Person("mark", "agent");
        calendar.setOwner(owner);

        assertThat(calendar.getOwner()).isEqualTo(owner);
    }

    @Test
    void doesNotHaveOver10Travels () {

        for (int i=0; i<10; i++){
            calendar.addTravel(new Travel(calendar));
        }
        assertThat(calendar.getTravels().size()).isEqualTo(Integer.valueOf(10));
        assertThat(calendar.addTravel(new Travel(calendar))).isFalse();
    }

    @Test
    void testAddTravel () throws InvalidClassException {
        Travel t1 = new Travel(calendar);

        Person owner = new Person("mark", "agent");
        Calendar cal2 = new Calendar(owner);

        cal2.addTravel(t1);

        assertThat(calendar.getTravels().contains(t1)).isFalse();
        assertThat(cal2.getTravels().contains(t1)).isTrue();
    }

    @Test
    void testRemoveTravel () {
        Travel t1 = new Travel(calendar);

        calendar.removeTravel(t1);
        assertThat(calendar.getTravels().contains(t1)).isFalse();
    }

    @Test
    void testBidirectionalAdd () {
        ArrayList<Travel> travels = new ArrayList<>();
        for (int i=0; i<10; i++) {
            travels.add(new Travel(calendar));
        }
        calendar.setTravels(travels);

        for (Travel each : travels) {
            assertThat(calendar.getTravels().contains(each)).isTrue();
            assertThat(each.getParent()).isEqualTo(calendar);
        }
    }


    @Test
    void testCompleteHandshake() throws InvalidClassException {
        Person owner = new Person("leo", "agent");
        Calendar cal2 = new Calendar(owner);

        Travel t1 = new Travel(calendar);
        t1.setParent(cal2);

        assertThat(calendar.getTravels().contains(t1)).isFalse();
        assertThat(t1.getParent()).isEqualTo(cal2);
        assertThat(cal2.getTravels().contains(t1)).isTrue();
    }

    @AfterEach
    public void tearDown() throws NullPointerException {
        if (calendar != null) {
            calendar.getTravels().clear();
        } else {
            throw new NullPointerException("Calendar is null!");
        }
    }


}
