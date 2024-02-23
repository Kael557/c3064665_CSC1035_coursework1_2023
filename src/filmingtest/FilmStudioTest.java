package filmingtest;

import org.junit.Before;
import org.junit.Test;

import CSC1035.Film;
import CSC1035.FilmStudio;

import java.util.List;
import static org.junit.Assert.*;

/**
 * Tests the FilmStudio class for correct functionality of its methods,
 * including adding films, finding the longest film, calculating average
 * box office earnings, and filtering films based on earnings criteria.
 */
public class FilmStudioTest {
    private FilmStudio studio;
    private Film film1;
    private Film film2;
    private Film film3;

    /**
     * Sets up a FilmStudio object and a few Film objects for testing.
     * This method is executed before each test method.
     */
    @Before
    public void setUp() {
        studio = new FilmStudio("DreamWorks");
        film1 = new Film("Shrek", 2001, 90, 484.41, "Comedy");
        film2 = new Film("Madagascar", 2005, 86, 532.68, "Comedy");
        film3 = new Film("Kung Fu Panda", 2008, 92, 631.74, "Action");

        studio.addFilm(film1);
        studio.addFilm(film2);
        studio.addFilm(film3);
    }

    /**
     * Tests the addFilm method by checking the size of the films list.
     */
    @Test
    public void testAddFilm() {
        // Adding one more film to see if list size increases
        studio.addFilm(new Film("How to Train Your Dragon", 2010, 98, 494.88, "Action"));
        assertEquals(4, studio.getFilms().size());
    }

    /**
     * Tests the getLongestFilm method.
     */
    @Test
    public void testGetLongestFilm() {
        // The longest film setup is Kung Fu Panda with 92 minutes
        assertEquals(film3, studio.getLongestFilm());
    }

    /**
     * Tests the getAverageBoxOfficeEarnings method for a specific year.
     */
    @Test
    public void testGetAverageBoxOfficeEarnings() {
        // Only Kung Fu Panda was released in 2008
        assertEquals(631.74, studio.getAverageBoxOfficeEarnings(2008), 0.001);
    }

    /**
     * Tests the getAverageBoxOfficeEarnings method for a year with no films.
     */
    @Test
    public void testGetAverageBoxOfficeEarningsNoFilmsYear() {
        // No films were released in 2020 in this setup
        assertEquals(0, studio.getAverageBoxOfficeEarnings(2020), 0.001);
    }

    /**
     * Tests the getFilmsWithBoxOfficeLessThan method.
     */
    @Test
    public void testGetFilmsWithBoxOfficeLessThan() {
        // Two films have box office earnings less than 600
        List<Film> filteredFilms = studio.getFilmsWithBoxOfficeLessThan(600);
        assertTrue(filteredFilms.contains(film1) && filteredFilms.contains(film2) && filteredFilms.size() == 2);
    }

    /**
     * Tests the getName method.
     */
    @Test
    public void testGetName() {
        assertEquals("DreamWorks", studio.getName());
    }

    /**
     * Tests the setName method.
     */
    @Test
    public void testSetName() {
        studio.setName("Pixar");
        assertEquals("Pixar", studio.getName());
    }
}
