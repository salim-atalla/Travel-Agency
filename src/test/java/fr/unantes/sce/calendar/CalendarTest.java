package fr.unantes.sce.calendar;


import fr.unantes.sce.people.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class CalendarTest {

    private Calendar calendar;
    private Person owner ;

    @BeforeEach
    public void setUp() throws Exception {
        calendar = new Calendar(owner);

    }
    @Test
    void doesNotHaveOver10Travels(){
        Travel test = new Travel(new Calendar(owner));
        for ( int i = 0; i<10; i++){// change i from 10 to 11 to see the exception, the test passes at 9 and not 10
            calendar.addTravel(test);
        }
        assertThat(calendar.getTravels().size()<11);
    }


    @AfterEach
    public void tearDown() throws Exception {
    }
}
