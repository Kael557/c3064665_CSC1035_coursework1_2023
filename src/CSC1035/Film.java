package CSC1035;

/**
 * Represents a film with its details including title, year of release,
 * length, box office earnings, and genre.
 */
public class Film {
    private String title;
    private int yearOfRelease;
    private int length; // in minutes
    private double boxOfficeEarnings; // in pounds
    private String genre; // either comedy, horror or action

    /**
     * Constructs a new Film instance.
     * 
     * @param title             The title of the film.
     * @param yearOfRelease     The year the film was released.
     * @param length            The length of the film in minutes.
     * @param boxOfficeEarnings The box office earnings of the film in pounds.
     * @param genre             The genre of the film, limited to comedy, horror, or
     *                          action.
     */
    public Film(String title, int yearOfRelease, int length, double boxOfficeEarnings, String genre) {
        this.title = title;
        this.yearOfRelease = yearOfRelease;
        this.length = length;
        this.boxOfficeEarnings = boxOfficeEarnings;
        this.genre = genre;
    }

    /**
     * Gets the title of the film.
     * 
     * @return The film's title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the film.
     * 
     * @param title The film's new title.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the year of release of the film.
     * 
     * @return The year the film was released.
     */
    public int getYearOfRelease() {
        return yearOfRelease;
    }

    /**
     * Sets the year of release of the film.
     * 
     * @param yearOfRelease The new release year of the film.
     */
    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    /**
     * Gets the length of the film in minutes.
     * 
     * @return The length of the film.
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the length of the film in minutes.
     * 
     * @param length The new length of the film.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Gets the box office earnings of the film in pounds.
     * 
     * @return The box office earnings.
     */
    public double getBoxOfficeEarnings() {
        return boxOfficeEarnings;
    }

    /**
     * Sets the box office earnings of the film in pounds.
     * 
     * @param boxOfficeEarnings The new box office earnings of the film.
     */
    public void setBoxOfficeEarnings(double boxOfficeEarnings) {
        this.boxOfficeEarnings = boxOfficeEarnings;
    }

    /**
     * Gets the genre of the film.
     * 
     * @return The genre of the film.
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets the genre of the film.
     * 
     * @param genre The new genre of the film.
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Returns a string representation of the Film object.
     * 
     * @return A string containing the film's details.
     */
    @Override
    public String toString() {
        return "Film{" +
                "title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", length=" + length +
                ", boxOfficeEarnings=" + boxOfficeEarnings +
                ", genre='" + genre + '\'' +
                '}';
    }
}
