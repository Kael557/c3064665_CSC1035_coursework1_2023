package filmingtest;

import org.junit.Before;
import org.junit.Test;

import CSC1035.Film;

import static org.junit.Assert.*;

/**
 * Tests the Film class for correct functionality of its methods,
 * including constructors, getters, setters, and the toString method.
 */
public class FilmTest {
    private Film film;

    /**
     * Sets up a Film object for testing.
     * This method is executed before each test method.
     */
    @Before
    public void setUp() {
        // Initialize the Film object with sample data
        film = new Film("Inception", 2010, 148, 829.89, "Action");
    }

    /**
     * Tests the getTitle method.
     */
    @Test
    public void testGetTitle() {
        assertEquals("Inception", film.getTitle());
    }

    /**
     * Tests the setTitle method.
     */
    @Test
    public void testSetTitle() {
        film.setTitle("Interstellar");
        assertEquals("Interstellar", film.getTitle());
    }

    /**
     * Tests the getYearOfRelease method.
     */
    @Test
    public void testGetYearOfRelease() {
        assertEquals(2010, film.getYearOfRelease());
    }

    /**
     * Tests the setYearOfRelease method.
     */
    @Test
    public void testSetYearOfRelease() {
        film.setYearOfRelease(2014);
        assertEquals(2014, film.getYearOfRelease());
    }

    /**
     * Tests the getLength method.
     */
    @Test
    public void testGetLength() {
        assertEquals(148, film.getLength());
    }

    /**
     * Tests the setLength method.
     */
    @Test
    public void testSetLength() {
        film.setLength(169);
        assertEquals(169, film.getLength());
    }

    /**
     * Tests the getBoxOfficeEarnings method.
     */
    @Test
    public void testGetBoxOfficeEarnings() {
        assertEquals(829.89, film.getBoxOfficeEarnings(), 0.001);
    }

    /**
     * Tests the setBoxOfficeEarnings method.
     */
    @Test
    public void testSetBoxOfficeEarnings() {
        film.setBoxOfficeEarnings(677.46);
        assertEquals(677.46, film.getBoxOfficeEarnings(), 0.001);
    }

    /**
     * Tests the getGenre method.
     */
    @Test
    public void testGetGenre() {
        assertEquals("Action", film.getGenre());
    }

    /**
     * Tests the setGenre method.
     */
    @Test
    public void testSetGenre() {
        film.setGenre("Sci-Fi");
        assertEquals("Sci-Fi", film.getGenre());
    }

    /**
     * Tests the toString method.
     */
    @Test
    public void testToString() {
        String expected = "Film{title='Inception', yearOfRelease=2010, length=148, boxOfficeEarnings=829.89, genre='Action'}";
        assertEquals(expected, film.toString());
    }
}
