package fr.unantes.sce.calendar;

import fr.unantes.sce.people.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.InvalidClassException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TravelTest {

    private  Travel travel;
    private  Calendar parent;

    @BeforeEach
    public void setUp() throws InvalidClassException {

        parent = new Calendar(new Person("Farah", "admin"));
        travel = new Travel(parent);
    }

    @Test
    public void testSetParent() throws InvalidClassException {

        Calendar parent = new Calendar(new Person("Pierre", "admin"));
        travel.setParent(parent);
        assertThat(travel.getParent()).isEqualTo(parent);
        assertThat(parent.getTravels().contains(travel)).isTrue();
    }

    @Test
    public void testUnsetParent(){

        travel.unSetParent();
        assertThat(travel.getParent()).isNull();
        assertThat(parent.getTravels().contains(travel)).isFalse();
    }

    @AfterEach
    public void tearDown() throws Exception {

    }
}
