package CSC1035;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages reporting across multiple film studios, offering insights
 * on films and studio performances.
 */
public class Reporting {
    private List<FilmStudio> filmStudios;

    /**
     * Constructs a new Reporting instance.
     */
    public Reporting() {
        this.filmStudios = new ArrayList<>();
    }

    /**
     * Adds a film studio to the reporting system.
     * 
     * @param studio The film studio to be added.
     */
    public void addFilmStudio(FilmStudio studio) {
        filmStudios.add(studio);
    }

    /**
     * Finds the longest film ever made across all studios.
     * 
     * @return The longest film.
     */
    public Film findLongestFilm() {
        Film longestFilm = null;
        for (FilmStudio studio : filmStudios) {
            Film currentLongest = studio.getLongestFilm();
            if (longestFilm == null
                    || (currentLongest != null && currentLongest.getLength() > longestFilm.getLength())) {
                longestFilm = currentLongest;
            }
        }
        return longestFilm;
    }

    /**
     * Identifies the film studio with the largest average box office earnings in a
     * given year.
     * 
     * @param year The year to evaluate.
     * @return The studio with the largest average earnings, or null if no studios
     *         have data for the year.
     */
    public FilmStudio findStudioWithLargestAverageEarnings(int year) {
        FilmStudio studioWithLargestEarnings = null;
        double largestAverageEarnings = 0;
        for (FilmStudio studio : filmStudios) {
            double currentAverage = studio.getAverageBoxOfficeEarnings(year);
            if (currentAverage > largestAverageEarnings) {
                largestAverageEarnings = currentAverage;
                studioWithLargestEarnings = studio;
            }
        }
        return studioWithLargestEarnings;
    }

    /**
     * Compiles a list of all films made with box office earnings less than a
     * specified amount.
     * 
     * @param amount The earnings threshold.
     * @return A list of films under the specified earnings amount.
     */
    public List<Film> findAllFilmsWithEarningsUnder(double amount) {
        List<Film> filmsUnderAmount = new ArrayList<>();
        for (FilmStudio studio : filmStudios) {
            filmsUnderAmount.addAll(studio.getFilmsWithBoxOfficeLessThan(amount));
        }
        return filmsUnderAmount;
    }

    /**
     * Finds a film studio by name.
     * 
     * @param name The name of the studio to find.
     * @return The found FilmStudio, or null if not found.
     */
    public FilmStudio findStudioByName(String name) {
        for (FilmStudio studio : filmStudios) {
            if (studio.getName().equalsIgnoreCase(name)) {
                return studio;
            }
        }
        return null;
    }

    /**
     * Gets the list of all film studios.
     * 
     * @return A list of all film studios.
     */
    public List<FilmStudio> getFilmStudios() {
        return new ArrayList<>(filmStudios); // Return a copy of the list to avoid external modifications.
    }
}
