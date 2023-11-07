package data;

import comparator.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Database {
    private String filename = "superhero.csv";

    private ArrayList<Superhero> superheroArrayList = new ArrayList<>();

    public ArrayList<Superhero> getSuperheroArrayList() {
        return superheroArrayList;
    }


    public void addSuperhero(String heroName, String realName, String superPower, int strength, int birthYear, String isHuman) {
        superheroArrayList.add(new Superhero(heroName, realName, superPower, strength, birthYear, isHuman));
    }

    public String printAllSuperheroes() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Superhero superhero : superheroArrayList) {
            stringBuilder.append("\u2500".repeat(50)).append("\n");
            stringBuilder.append(superhero).append("\n");


        }

        return stringBuilder.toString();
    }

    public ArrayList<Superhero> search(String superHeroName) {
        ArrayList<Superhero> heroNames = new ArrayList<>();
        boolean herofound = false;
        for (Superhero superhero : superheroArrayList) {
            if (superhero.getHeroName().toLowerCase().trim().contains(superHeroName.toLowerCase())) {
                ArrayList<Superhero> searchResults = new ArrayList<>();
                searchResults.add(superhero);
                herofound = true;
                return searchResults;
            }
        }
        return null;
    }

    public ArrayList<Superhero> findHeroName(String heroName) {
        ArrayList<Superhero> heroNames = new ArrayList<>();
        for (Superhero superhero : superheroArrayList) {
            if (superhero.getHeroName().toLowerCase().contains(heroName.toLowerCase())) {
                heroNames.add(superhero);

            }
        }

        return heroNames;


    }


    public void deleteSuperhero(Superhero superhero) {
        if (superheroArrayList.contains(superhero)) {
            superheroArrayList.remove(superhero);
        }
    }

    public void saveSuperheroes() {
        try {
            PrintStream output = new PrintStream(new File(filename));
            output.println("Heroname,Realname,SuperPower,Strength,BirthYear,IsHuman");
            for (Superhero superhero : superheroArrayList) {
                output.println(superhero.csvString());
            }
            output.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
    public void loadSuperHeroData() {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] values = line.split(",");
                if (values.length == 6) {
                    String heroName = values[0];
                    String realName = values[1];
                    String superpower = values[2];
                    double strength = Double.parseDouble(values[3]);
                    int birthYear = Integer.parseInt(values[4]);
                    String isHuman = values[5];

                    Superhero superhero = new Superhero(heroName,realName,superpower,strength,birthYear,isHuman);
                    superheroArrayList.add(superhero);
                } else {

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
    private Comparator<Superhero> primaryComparator;
    private Comparator<Superhero> secondaryComparator;

    public void setPrimaryComparator(Comparator<Superhero> primaryComparator) {
        this.primaryComparator = primaryComparator;
    }

    public void setSecondaryComparator(Comparator<Superhero> secondaryComparator) {
        this.secondaryComparator = secondaryComparator;
    }

    public void compareForPrimThenSec(int primary, int secondary) {
        switch (primary) {
            case 1:
                setPrimaryComparator(new Heronamecomparator());
                break;
            case 2:
                setPrimaryComparator(new Realnamecomparator());
                break;
            case 3:
                setPrimaryComparator(new Superpowercomparator());
                break;
            case 4:
                setPrimaryComparator(new Strengthcomparator());
                break;
            case 5:
                setPrimaryComparator(new Birthyearcomparator());
                break;
            case 6:
                setPrimaryComparator(new Ishumancomparator());
                break;
            default:
                System.out.println("Wrong input, try again");
                break;
        }
        switch (secondary) {
            case 1:
                setSecondaryComparator(new Heronamecomparator());
                break;
            case 2:
                setSecondaryComparator(new Realnamecomparator());
                break;
            case 3:
                setSecondaryComparator(new Superpowercomparator());
                break;
            case 4:
                setSecondaryComparator(new Strengthcomparator());
                break;
            case 5:
                setSecondaryComparator(new Birthyearcomparator());
                break;
            case 6:
                setSecondaryComparator(new Ishumancomparator());
                break;
            default:
                System.out.println("Wrong input, try again");
                break;
        }
    }
    public void sort() {
        Collections.sort(superheroArrayList,primaryComparator.thenComparing(secondaryComparator));
    }
}