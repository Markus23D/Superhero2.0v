package userinterface;

import data.Controller;
import data.Database;
import data.Superhero;

import java.util.ArrayList;
import java.util.Scanner;


public class Userinterface {
    Scanner scanner = new Scanner(System.in);
    Controller controller = new Controller();


    public void welcomeMessage() {
        System.out.println("Welcome to the SUPERHERO UNIVERSE");
        System.out.println("\u2500".repeat(50) + " ");

        System.out.println("Enter 1 to CREATE a new superhero");
        System.out.println("Enter 2 to VIEW your superheroes");
        System.out.println("Enter 3 to SEARCH for a superhero");
        System.out.println("Enter 4 to EDIT a superhero");
        System.out.println("Enter 5 to DELETE a superhero");
        System.out.println("Enter 9 to EXIT");
        System.out.println("\u2500".repeat(50) + " ");
    }

    public void StartProgram() {
        controller.loadSuperHeroData();
        boolean run = true;


        while (run) {
            welcomeMessage();
            System.out.print("Input: ");
            String input = scanner.nextLine().trim().toLowerCase();
            String[] commands = input.split("\\s+");
            String command = commands[0];

            switch (command) {
                case "1", "one" -> {
                    System.out.println("Input your superheros hero name: ");
                    String heroName = scanner.nextLine();

                    System.out.println("Input your superheros real name: ");
                    String realName = scanner.nextLine();

                    System.out.println("Input your superheros superpower: ");
                    String superPower = scanner.nextLine();

                    System.out.println("Input your superheros power level: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("You need to input a number: ");
                        scanner.nextLine();
                    }
                    int strength = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Input your superheros birthyear: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("You need to input a number: ");
                        scanner.nextLine();
                    }
                    int birthYear = scanner.nextInt();
                    char human;
                    boolean isHuman = true;
                    do {
                        System.out.println("Is the superhero a human? [j/n]");
                        human = scanner.next().charAt(0);
                        if (human == 'j') {
                            isHuman = true;
                        } else if (human == 'n') {
                            isHuman = false;

                        } else {
                            System.out.println("Invalid input");
                        }
                    } while (human != 'j' && human != 'n');


                    controller.addSuperhero(heroName, realName, superPower, strength, birthYear, String.valueOf(isHuman));
                    System.out.println("Superhero added to the database");
                    scanner.nextLine();


                }
                case "2", "two" -> {
                    System.out.println("How would you like to sort your primary attribute?");
                    System.out.println("Enter 1 to sort by HERONAME");
                    System.out.println("Enter 2 to sort by REALNAME");
                    System.out.println("Enter 3 to sort by BIRTHYEAR");
                    System.out.println("Enter 4 to sort by SUPERPOWER");
                    System.out.println("Enter 5 to sort by STRENGTH");
                    System.out.println("Enter 6 to sort by ISHUMAN");
                    int choice;
                    while (!scanner.hasNextInt()) {
                        System.out.println("Input a number");
                        scanner.nextLine();
                    }
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("How would you like to sort your secondary attribute?");
                    System.out.println("Enter 1 to sort by HERONAME");
                    System.out.println("Enter 2 to sort by REALNAME");
                    System.out.println("Enter 3 to sort by BIRTHYEAR");
                    System.out.println("Enter 4 to sort by SUPERPOWER");
                    System.out.println("Enter 5 to sort by STRENGTH");
                    System.out.println("Enter 6 to sort by ISHUMAN");
                    int secondChoice;
                    while (!scanner.hasNextInt()) {
                        System.out.println("Input a number");
                        scanner.nextLine();
                    }
                    secondChoice = scanner.nextInt();
                    scanner.nextLine();
                  controller.compareForPrimThenSec(choice,secondChoice);
                  controller.sort();
                    System.out.println(controller.printAllSuperheroes());


                }

                case "3", "three" -> {
                    System.out.println("Search for a superhero");
                    String userInput = scanner.nextLine();
                    System.out.println(controller.findHeroName(userInput));

                }

                case "4", "four" -> {
                    editSuperhero();

                }

                case "5", "five" -> {
                    deleteSuperhero();
                }

                case "9", "nine" -> {
                    controller.saveSuperheroes();
                    System.exit(0);
                }

            }
        }

    }

    public void editSuperhero() {

        System.out.println("Enter your search criteria");
        String userInput = scanner.nextLine();

        ArrayList<Superhero> searchResult = controller.findHeroName(userInput);

        Superhero superheroToEdit = null;

        if (searchResult.size() == 0) {
            System.out.println("There is no superhero in the list with the name: " + "\"" + userInput + "\"");

        } else if (searchResult.size() >= 1) {


            // Vælg en person i søgeresultat med flere personer
            System.out.println("Pick your superhero");
            int tæller = 1;
            for (Superhero superhero : searchResult) {
                System.out.println(tæller++ + ". " +
                        superhero.getHeroName() + " " +
                        superhero.getRealName() + " " +
                        superhero.getSuperPower() + " " +
                        superhero.getBirthYear() + " " +
                        superhero.getIsHuman() + " " +
                        superhero.getStrength()
                );
                int superheroChoice = scanner.nextInt();
                scanner.nextLine();
                superheroToEdit = searchResult.get(superheroChoice - 1);
            }
        } else {
            superheroToEdit = searchResult.get(0);
        }

        if (superheroToEdit != null) {
            System.out.println("Edit superhero information. Press ENTER to keep previous information.");
            String newValue;
            System.out.println("Hero name: " + superheroToEdit.getHeroName());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superheroToEdit.setHeroName(newValue);
            }
            System.out.println("Real name: " + superheroToEdit.getRealName());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superheroToEdit.setRealName(newValue);
            }
            System.out.println("Birth year: " + superheroToEdit.getBirthYear());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superheroToEdit.setBirthYear(Integer.parseInt(newValue));
            }
            System.out.println("Superpower: " + superheroToEdit.getSuperPower());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superheroToEdit.setSuperPower(newValue);
            }
            System.out.println("IsHuman: " + superheroToEdit.getIsHuman());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superheroToEdit.setIsHuman(newValue);
            }
            System.out.println("Strengh: " + superheroToEdit.getStrength());
            newValue = scanner.nextLine();
            if (!newValue.isEmpty()) {
                superheroToEdit.setStrength(Double.parseDouble(newValue));
            }

            System.out.println(superheroToEdit + " is updated.");

        }

    }

    //slettefunktion
    public void deleteSuperhero() {
        System.out.println("Input a search for the hero you want to delete");
        String superheroname = scanner.nextLine();
        ArrayList<Superhero> results = controller.search(superheroname);


        if (results.isEmpty()) {
            System.out.println("No matches found.");
            System.out.println("\u2500".repeat(50));

        } else if (results.size() == 1) {
            Superhero superhero = results.get(0);
            controller.deleteSuperhero(superhero);
            System.out.println(superhero.getHeroName() + " has been deleted from the database");
            System.out.println("\u2500".repeat(50));
        } else {
            System.out.println("Multiple matches found, pick by entering a number");
            for (int i = 0; i < results.size(); i++) {
                Superhero superhero = results.get(i);
                System.out.println((i + 1) + ". " + superhero.getHeroName());
            }

            int valg = Integer.parseInt(scanner.nextLine());

            if (valg >= 1 && valg <= results.size()) {
                Superhero superhero = results.get(valg - 1);
                controller.deleteSuperhero(superhero);
                System.out.println(superhero.getHeroName() + " has been deleted from the database");
                System.out.println("\u2500".repeat(50));
            } else {
                System.out.println("Invalid input");
            }
        }


    }

}