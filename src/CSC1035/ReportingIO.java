package CSC1035;

import java.util.List;
import java.util.Scanner;

/**
 * Main class for interacting with the film and film studio reporting system.
 * Provides a console interface for data entry and reporting.
 */
public class ReportingIO {
    private static Reporting reporting = new Reporting();
    private static Scanner scanner = new Scanner(System.in);

    /**
     * The entry point for the film reporting system application.
     * This method displays a menu to the user and processes user input to navigate
     * through different functionalities
     * of the application. These functionalities include entering data for film
     * studios and films, listing all film studios,
     * listing films for a specified studio, displaying various reporting
     * statistics, and exiting the application.
     * The method continuously displays the menu and processes input until the user
     * chooses to exit.
     *
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Film Reporting System Menu ---");
            System.out.println("1 - Enter film studio data");
            System.out.println("2 - Enter film data");
            System.out.println("3 - List all film studios");
            System.out.println("4 - List all films for a given studio");
            System.out.println("5 - Reporting statistics");
            System.out.println("6 - Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    enterFilmStudioData();
                    break;
                case 2:
                    enterFilmData();
                    break;
                case 3:
                    listAllFilmStudios();
                    break;
                case 4:
                    listFilmsForStudio();
                    break;
                case 5:
                    showReportingStatistics();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    /**
     * Initiates the process of entering data for a new film studio.
     * Prompts the user for the film studio's name, creates a new FilmStudio object,
     * and adds it to the reporting system.
     */
    private static void enterFilmStudioData() {
        System.out.print("Enter film studio name: ");
        String name = scanner.nextLine();
        FilmStudio studio = new FilmStudio(name);
        reporting.addFilmStudio(studio);
        System.out.println("Film studio '" + name + "' added.");
    }

    /**
     * Facilitates the entry of data for a new film associated with a specific film
     * studio.
     * Prompts the user for details about the film, including the studio name, film
     * title, year of release, length, box office earnings, and genre. It then
     * creates a new Film object and adds it to the corresponding FilmStudio.
     */
    private static void enterFilmData() {
        System.out.print("Enter the name of the studio: ");
        String studioName = scanner.nextLine();
        FilmStudio studio = reporting.findStudioByName(studioName);
        if (studio == null) {
            System.out.println("Studio not found.");
            return;
        }
        System.out.print("Enter film title: ");
        String title = scanner.nextLine();
        System.out.print("Enter year of release: ");
        int year = scanner.nextInt();
        System.out.print("Enter length (in minutes): ");
        int length = scanner.nextInt();
        System.out.print("Enter box office earnings (in pounds): ");
        double earnings = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter genre (comedy, horror, action): ");
        String genre = scanner.nextLine();

        Film film = new Film(title, year, length, earnings, genre);
        studio.addFilm(film);
        System.out.println("Film '" + title + "' added to studio '" + studioName + "'.");
    }

    /**
     * Lists all film studios currently in the reporting system.
     * Iterates over the collection of FilmStudio objects and prints the name of
     * each studio.
     */
    private static void listAllFilmStudios() {
        System.out.println("Film Studios:");
        for (FilmStudio studio : reporting.getFilmStudios()) {
            System.out.println("- " + studio.getName());
        }
    }

    /**
     * Lists all films for a specified film studio.
     * Prompts the user for the name of the studio, retrieves the corresponding
     * FilmStudio object, and prints details of each film associated with that
     * studio.
     */
    private static void listFilmsForStudio() {
        System.out.print("Enter the studio name to list films: ");
        String studioName = scanner.nextLine();
        FilmStudio studio = reporting.findStudioByName(studioName);
        if (studio == null) {
            System.out.println("Studio not found.");
            return;
        }
        List<Film> films = studio.getFilms();
        if (films.isEmpty()) {
            System.out.println("No films found for '" + studioName + "'.");
        } else {
            System.out.println("Films for '" + studioName + "':");
            for (Film film : films) {
                System.out.println("- " + film.getTitle() + " (" + film.getYearOfRelease() + ")");
            }
        }
    }

    /**
     * Displays various reporting statistics based on the current data.
     * Includes the longest film ever made, the studio with the largest average box
     * office earnings for a specified year, and all films with box office earnings
     * below a specified amount. Prompts the user for input where necessary to
     * generate these reports.
     */
    private static void showReportingStatistics() {
        System.out.println("Reporting Statistics:");
        // Longest film ever made
        Film longestFilm = reporting.findLongestFilm();
        System.out.println(
                "Longest Film Ever Made: " + longestFilm.getTitle() + " (" + longestFilm.getLength() + " mins)");

        // Prompt for year to find studio with largest average box office earnings
        System.out.print("Enter year to find studio with largest average box office earnings: ");
        int year = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        FilmStudio studioWithLargestEarnings = reporting.findStudioWithLargestAverageEarnings(year);
        if (studioWithLargestEarnings != null) {
            System.out.println("Studio with largest average box office earnings in " + year + ": "
                    + studioWithLargestEarnings.getName());
        } else {
            System.out.println("No data available for " + year);
        }

        // Prompt for amount to list all films with box office earnings less than a
        // given amount
        System.out.print("Enter box office earnings amount to list films under this amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        List<Film> filmsUnderAmount = reporting.findAllFilmsWithEarningsUnder(amount);
        if (!filmsUnderAmount.isEmpty()) {
            System.out.println("Films with box office earnings under " + amount + ":");
            for (Film film : filmsUnderAmount) {
                System.out.println("- " + film.getTitle() + " (" + film.getBoxOfficeEarnings() + " pounds)");
            }
        } else {
            System.out.println("No films found under " + amount + " pounds.");
        }
    }

}
