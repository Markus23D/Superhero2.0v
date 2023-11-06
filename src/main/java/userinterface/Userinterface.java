package userinterface;

import data.Database;
import data.Superhero;

import java.util.ArrayList;
import java.util.Scanner;


public class Userinterface {
    Scanner scanner = new Scanner(System.in);
    Database database = new Database();


    public void welcomeMessage() {
        System.out.println("Velkommen til SUPERHERO UNIVERSET");
        System.out.println("\u2500".repeat(50) + " ");

        System.out.println("Indtast 1 for at oprette en ny superhelt");
        System.out.println("Indtast 2 for at se alle superhelte");
        System.out.println("Indtast 3 for at søge på en superhelt");
        System.out.println("Indtast 4 for at redigere en superhelt");
        System.out.println("Indtast 5 for at slette en superhelt");
        System.out.println("Indtast 9 for at afslutte");
        System.out.println("\u2500".repeat(50) + " ");
    }

    public void StartProgram() {
        boolean run = true;


        while (run) {
            welcomeMessage();

            String input = scanner.nextLine().trim().toLowerCase();
            String[] commands = input.split("\\s+");
            String command = commands[0];


            switch (command) {
                case "1", "et" -> {
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


                    database.addSuperhero(heroName, realName, superPower, strength, birthYear, String.valueOf(isHuman));
                    System.out.println("Superhelt tilføjet til Database");
                    scanner.nextLine();


                }
                case "2", "to" -> {
                    System.out.println(database.printAllSuperheroes());

                }

                case "3", "tre" -> {
                    System.out.println("Søg efter en superhelt.");
                    String brugerSøgning = scanner.nextLine();
                    System.out.println(database.findHeroName(brugerSøgning));

                }

                case "4", "fire" -> {
                    redigerPerson();

                }

                case "5", "fem" -> {
                    sletSuperHero();
                }

                case "9", "ni" -> {

                    System.exit(0);
                }

            }
        }

    }
    public void redigerPerson() {
        //Her kan delvist navn indtastes
        System.out.println("Indtast søgekriterium for person");
        String brugerInput = scanner.nextLine();

        ArrayList<Superhero> søgeResultat = database.findHeroName(brugerInput);

        Superhero superheltDerSkalRedigeres = null;

        if (søgeResultat.size() == 0) {
            System.out.println("Der findes ingen helte i listen med navn: " + "\"" + brugerInput + "\"");

        } else if (søgeResultat.size() >= 1) {


            // Vælg en person i søgeresultat med flere personer
            System.out.println("Vælg person");
            int tæller = 1;
            for (Superhero superhero : søgeResultat) {
                System.out.println(tæller++ + ". " +
                        superhero.getHeroName() + " " +
                        superhero.getRealName() + " " +
                        superhero.getSuperPower() + " " +
                        superhero.getBirthYear() + " " +
                        superhero.getIsHuman() + " " +
                        superhero.getStrength()
                );
                int superheltValg = scanner.nextInt();
                scanner.nextLine();
                superheltDerSkalRedigeres = søgeResultat.get(superheltValg - 1);
            }
        } else {
            superheltDerSkalRedigeres = søgeResultat.get(0);
        }

        if (superheltDerSkalRedigeres != null) {
            System.out.println("Rediger personinformation. Tryk ENTER hvis information ikke skal redigeres.");
            String nyVærdi;
            System.out.println("Helte navn: " + superheltDerSkalRedigeres.getHeroName());
            nyVærdi = scanner.nextLine();
            if (!nyVærdi.isEmpty()) {
                superheltDerSkalRedigeres.setHeroName(nyVærdi);
            }
            System.out.println("Rigtige navn: " + superheltDerSkalRedigeres.getRealName());
            nyVærdi = scanner.nextLine();
            if (!nyVærdi.isEmpty()) {
                superheltDerSkalRedigeres.setRealName(nyVærdi);
            }
            System.out.println("Lavet år:: " + superheltDerSkalRedigeres.getBirthYear());
            nyVærdi = scanner.nextLine();
            if (!nyVærdi.isEmpty()) {
                superheltDerSkalRedigeres.setBirthYear(Integer.parseInt(nyVærdi));
            }
            System.out.println("Superkraft: " + superheltDerSkalRedigeres.getSuperPower());
            nyVærdi = scanner.nextLine();
            if (!nyVærdi.isEmpty()) {
                superheltDerSkalRedigeres.setSuperPower(nyVærdi);
            }
            System.out.println("IsHuman: " + superheltDerSkalRedigeres.getIsHuman());
            nyVærdi = scanner.nextLine();
            if (!nyVærdi.isEmpty()) {
                superheltDerSkalRedigeres.setIsHuman(nyVærdi);
            }
            System.out.println("Strenght: " + superheltDerSkalRedigeres.getStrength());
            nyVærdi = scanner.nextLine();
            if (!nyVærdi.isEmpty()) {
                superheltDerSkalRedigeres.setStrength(Double.parseDouble(nyVærdi));
            }

            System.out.println(superheltDerSkalRedigeres + " er opdateret.");

        }

    }

    //slettefunktion
    public void sletSuperHero() {
        System.out.println("Søg på helten du vil slette");
        String superheltnavn = scanner.nextLine();
        ArrayList<Superhero> resultater = database.search(superheltnavn);


        if (resultater.isEmpty()) {
            System.out.println("Ingen matchende superhelte fundet.");
            System.out.println("\u2500".repeat(50));

        } else if (resultater.size() == 1) {
            Superhero superhero = resultater.get(0);
            database.sletSuperhero(superhero);
            System.out.println(superhero.getHeroName() + " er blevet slettet fra databasen.");
            System.out.println("\u2500".repeat(50));
        } else {
            System.out.println("Flere matchende superhelte fundet. Vælg en ved at indtaste nummeret:");
            for (int i = 0; i < resultater.size(); i++) {
                Superhero superhelt = resultater.get(i);
                System.out.println((i + 1) + ". " + superhelt.getHeroName());
            }

            int valg = Integer.parseInt(scanner.nextLine());

            if (valg >= 1 && valg <= resultater.size()) {
                Superhero superhero = resultater.get(valg - 1);
                database.sletSuperhero(superhero);
                System.out.println(superhero.getHeroName() + " er blevet slettet fra databasen.");
                System.out.println("\u2500".repeat(50));
            } else {
                System.out.println("Ugyldigt valg.");
            }
        }



    }

}