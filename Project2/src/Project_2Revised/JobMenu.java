package Project_2Revised;

import JobService.JobListing;
import JobService.JobListingDAO;
import Security.MySQLConnector;
import JobService.Apply;

import java.io.IOException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;

public class JobMenu {

    private final MySQLConnector connector;
    private final JobListingDAO dao;
    private Apply apply;

    public JobMenu() {
        connector = new MySQLConnector();
        dao = new JobListingDAO(connector);
        apply = new Apply();
    }

    public void jobMenu() throws SQLException, IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            lineSeparator();
            System.out.println("   ***   Please select an option:   ***");
            System.out.println("----------------------------------------");
            System.out.println("1. Display all job listings");
            System.out.println("2. Search for job listings");
            System.out.println("3. Exit");
            lineSeparator();

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllJobListings();
                    break;
                case 2:
                    searchJobListings();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    connector.close();
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public void displayAllJobListings() throws SQLException, IOException {
        List<JobListing> jobListings = dao.getAllJobListings();
        if (jobListings.isEmpty()) {
            System.out.println("No job listings found.");
        } else {
            printJobListingsPageByPage(jobListings);
        }
    }

    public void printJobListingsPageByPage(List<JobListing> jobListings) throws SQLException, IOException {
        if (jobListings.isEmpty()) {
            System.out.println("No job listings found.");
            return;
        }

        int pageSize = 5;
        int totalPages = (int) Math.ceil((double) jobListings.size() / pageSize);
        int currentPage = 1;

        while (true) {
            List<JobListing> currentJobs = getJobsForPage(jobListings, currentPage, pageSize);
            if (currentJobs.isEmpty()) {
                System.out.println("No more job listings available on this page.");
                break;
            }

            System.out.println("Job Listings (Page " + currentPage + " of " + totalPages + "):\n");
            for (JobListing jobListing : currentJobs) {
                System.out.println("Job ID: " + jobListing.getId());
                System.out.println("Company: " + jobListing.getCompany());
                System.out.println("Title: " + jobListing.getTitle());
                System.out.println("Location: " + jobListing.getCity() + ", " + jobListing.getState());
                System.out.println("Requirements: " + jobListing.getRequirements());
                System.out.println("Salary: $" + jobListing.getSalaryMin() + " per year");
                lineSeparator();
            }

            System.out.println("----------------------------------------");
            System.out.println("   ***   Select an option:   ***");
            System.out.println("----------------------------------------");
            System.out.println("1) Apply for a job");
            System.out.println("2) View next page");
            System.out.println("3) Return to main menu");
            System.out.println("----------------------------------------");

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    apply.applyForJob();
                    break;
                case "2":
                    if (currentPage < totalPages) {
                        currentPage++;
                    } else {
                        System.out.println("This is the last page.");
                    }
                    break;
                case "3":
                    return; // Return to the main menu
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private List<JobListing> getJobsForPage(List<JobListing> jobListings, int currentPage, int pageSize) {
        int startIndex = (currentPage - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, jobListings.size());
        return jobListings.subList(startIndex, endIndex);
    }

    public void searchJobListings() {
        Scanner scanner = new Scanner(System.in);
        lineSeparator();
        System.out.println("   ***   Search by:   ***\n" +
                "----------------------------------------\n" +
                "1. Title\n" +
                "2. Requirements\n" +
                "3. City\n" +
                "4. State\n" +
                "5. Salary Minimum");
        lineSeparator();

        int searchBy = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        try {
            switch (searchBy) {
                case 1:
                    System.out.println("Available titles:");
                    List<String> titles = dao.getAllTitles();
                    int index = 1;
                    for (String title : titles) {
                        System.out.println(index + ". " + title);
                        index++;
                    }
                    System.out.println("Enter the number next to the title option:");
                    int titleOption = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (titleOption >= 1 && titleOption <= titles.size()) {
                        String titleQuery = titles.get(titleOption - 1);
                        List<JobListing> jobsByTitle = dao.searchJobListings(titleQuery, "title");
                        printJobListingsPageByPage(jobsByTitle);
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("Available requirements:");
                    List<String> requirements = dao.getAllRequirements();
                    index = 1;
                    for (String requirement : requirements) {
                        System.out.println(index + ". " + requirement);
                        index++;
                    }
                    System.out.println("Enter the number next to the requirements option:");
                    int requirementsOption = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (requirementsOption >= 1 && requirementsOption <= requirements.size()) {
                        String requirementsQuery = requirements.get(requirementsOption - 1);
                        List<JobListing> jobsByRequirements = dao.searchJobListings(requirementsQuery, "requirements");
                        printJobListingsPageByPage(jobsByRequirements);
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                    break;

                case 3:
                    System.out.println("Available cities:");
                    List<String> cities = dao.getAllCities();
                    index = 1;
                    for (String city : cities) {
                        System.out.println(index + ". " + city);
                        index++;
                    }
                    System.out.println("Enter the number next to the city option:");
                    int cityOption = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (cityOption >= 1 && cityOption <= cities.size()) {
                        String cityQuery = cities.get(cityOption - 1);
                        List<JobListing> jobsByCity = dao.searchJobListings(cityQuery, "city");
                        printJobListingsPageByPage(jobsByCity);
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                    break;
                case 4:
                    System.out.println("Available states:");
                    List<String> states = dao.getAllStates();
                    index = 1;
                    for (String state : states) {
                        System.out.println(index + ". " + state);
                        index++;
                    }
                    System.out.println("Enter the number next to the state option:");
                    int stateOption = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (stateOption >= 1 && stateOption <= states.size()) {
                        String stateQuery = states.get(stateOption - 1);
                        List<JobListing> jobsByState = dao.searchJobListings(stateQuery, "state");
                        printJobListingsPageByPage(jobsByState);
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                    break;
                case 5:
                    System.out.println("Available minimum salaries:");
                    List<Double> minSalaries = dao.getDistinctMinSalaries();
                    index = 1;
                    for (Double salary : minSalaries) {
                        System.out.println(index + ". " + salary);
                        index++;
                    }
                    System.out.println("Enter the number next to the minimum salary option:");
                    int salaryOption = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    if (salaryOption >= 1 && salaryOption <= minSalaries.size()) {
                        double salaryQuery = minSalaries.get(salaryOption - 1);
                        List<JobListing> jobsBySalary = dao.searchJobListingsBySalaryMin(salaryQuery);
                        printJobListingsPageByPage(jobsBySalary);
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }
                    break;
            }
        } catch (InputMismatchException ex) {
            ex.printStackTrace();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void lineSeparator() {
        for (int i = 0; i < 40; i++)
            System.out.print("-");
        System.out.println();
        // easy for separation
    }
}
