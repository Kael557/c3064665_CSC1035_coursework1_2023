package CSC1035;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a film studio with a name and a list of films it has made.
 * This class allows for the creation of a film studio object, adding films to
 * the studio's catalog,
 * and performing various queries on the films such as finding the longest film,
 * calculating average
 * box office earnings for a given year, and listing films below a certain box
 * office threshold.
 */
public class FilmStudio {
    private String name;
    private List<Film> films;

    /**
     * Constructs a FilmStudio instance with a specified name. Initializes the list
     * of films
     * associated with the studio to an empty list.
     *
     * @param name The name of the film studio.
     */
    public FilmStudio(String name) {
        this.name = name;
        this.films = new ArrayList<>();
    }

    /**
     * Adds a film to the studio's list of films. This method allows for expanding
     * the studio's
     * catalog of produced films.
     *
     * @param film The film to be added to the studio's list of films.
     */
    public void addFilm(Film film) {
        this.films.add(film);
    }

    /**
     * Returns the longest film produced by the film studio. If there are multiple
     * films of the
     * same longest length, the first encountered in the list is returned.
     *
     * @return The longest film produced by the studio, or null if the studio has
     *         not produced any films.
     */
    public Film getLongestFilm() {
        Film longestFilm = null;
        for (Film film : films) {
            if (longestFilm == null || film.getLength() > longestFilm.getLength()) {
                longestFilm = film;
            }
        }
        return longestFilm;
    }

    /**
     * Calculates the average box office earnings for films released in a given year
     * by the studio.
     * Only includes films released in the specified year.
     *
     * @param year The year to calculate the average earnings for.
     * @return The average box office earnings for the specified year, or 0 if no
     *         films were released that year.
     */
    public double getAverageBoxOfficeEarnings(int year) {
        double totalEarnings = 0;
        int count = 0;
        for (Film film : films) {
            if (film.getYearOfRelease() == year) {
                totalEarnings += film.getBoxOfficeEarnings();
                count++;
            }
        }
        return count == 0 ? 0 : totalEarnings / count;
    }

    /**
     * Returns a list of all films made by the film studio with box office earnings
     * less than a specified amount.
     * This method is useful for filtering films based on financial performance.
     *
     * @param amount The maximum amount of box office earnings.
     * @return A list of films with earnings less than the specified amount, or an
     *         empty list if no films meet the criteria.
     */
    public List<Film> getFilmsWithBoxOfficeLessThan(double amount) {
        List<Film> filteredFilms = new ArrayList<>();
        for (Film film : films) {
            if (film.getBoxOfficeEarnings() < amount) {
                filteredFilms.add(film);
            }
        }
        return filteredFilms;
    }

    /**
     * Gets the name of the film studio.
     *
     * @return The name of the film studio.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the film studio.
     *
     * @param name The new name for the film studio.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the list of films produced by the film studio.
     *
     * @return A list of films produced by the studio.
     */
    public List<Film> getFilms() {
        return films;
    }

    /**
     * Sets the list of films produced by the film studio.
     *
     * @param films The new list of films for the studio.
     */
    public void setFilms(List<Film> films) {
        this.films = films;
    }

    /**
     * Returns a string representation of the FilmStudio object, including its name
     * and the list of films.
     *
     * @return A string containing the film studio's details.
     */
    @Override
    public String toString() {
        return "FilmStudio{" +
                "name='" + name + '\'' +
                ", films=" + films +
                '}';
    }
}
