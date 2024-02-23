package filmingtest;

import org.junit.Before;
import org.junit.Test;

import CSC1035.Film;
import CSC1035.FilmStudio;
import CSC1035.Reporting;

import java.util.List;
import static org.junit.Assert.*;

/**
 * Tests the Reporting class for correct functionality of its methods,
 * focusing on managing multiple film studios and providing reporting
 * capabilities such as finding the longest film, the studio with the
 * largest average box office earnings, and filtering films based on
 * earnings criteria.
 */
public class ReportingTest {
    private Reporting reporting;
    private FilmStudio studio1;
    private FilmStudio studio2;

    /**
     * Sets up a Reporting object and some FilmStudio objects with films for testing.
     * This method is executed before each test method.
     */
    @Before
    public void setUp() {
        reporting = new Reporting();
        studio1 = new FilmStudio("Pixar");
        studio2 = new FilmStudio("DreamWorks");

        Film film1 = new Film("Toy Story", 1995, 81, 373.55, "Comedy");
        Film film2 = new Film("Finding Nemo", 2003, 100, 940.34, "Action");
        studio1.addFilm(film1);
        studio1.addFilm(film2);

        Film film3 = new Film("Shrek", 2001, 90, 484.41, "Comedy");
        Film film4 = new Film("Kung Fu Panda", 2008, 92, 631.74, "Action");
        studio2.addFilm(film3);
        studio2.addFilm(film4);

        reporting.addFilmStudio(studio1);
        reporting.addFilmStudio(studio2);
    }

    /**
     * Tests the addFilmStudio method by checking the size of the film studios list.
     */
    @Test
    public void testAddFilmStudio() {
        // Adding one more studio to see if list size increases
        reporting.addFilmStudio(new FilmStudio("Warner Bros"));
        assertEquals(3, reporting.getFilmStudios().size());
    }

    /**
     * Tests the findLongestFilm method.
     */
    @Test
    public void testFindLongestFilm() {
        // Assuming the longest film is "Finding Nemo" with 100 minutes
        Film longestFilm = reporting.findLongestFilm();
        assertNotNull(longestFilm);
        assertEquals("Finding Nemo", longestFilm.getTitle());
    }

    /**
     * Tests the findStudioWithLargestAverageEarnings method for a specific year.
     */
    @Test
    public void testFindStudioWithLargestAverageEarnings() {
        // In 2003, Pixar should have the largest average box office earnings
        FilmStudio studioWithLargestEarnings = reporting.findStudioWithLargestAverageEarnings(2003);
        assertNotNull(studioWithLargestEarnings);
        assertEquals("Pixar", studioWithLargestEarnings.getName());
    }

    /**
     * Tests the findStudioWithLargestAverageEarnings method for a year with no films.
     */
    @Test
    public void testFindStudioWithLargestAverageEarningsNoFilmsYear() {
        // No films were released in 2020
        assertNull(reporting.findStudioWithLargestAverageEarnings(2020));
    }

    /**
     * Tests the findAllFilmsWithEarningsUnder method.
     */
    @Test
    public void testFindAllFilmsWithEarningsUnder() {
        // Films with box office earnings under 500 million
        List<Film> filmsUnderAmount = reporting.findAllFilmsWithEarningsUnder(500);
        assertFalse(filmsUnderAmount.isEmpty());
        assertTrue(filmsUnderAmount.stream().anyMatch(film -> film.getTitle().equals("Toy Story")));
        assertTrue(filmsUnderAmount.stream().anyMatch(film -> film.getTitle().equals("Shrek")));
    }
}
