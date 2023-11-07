package data;

import comparator.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
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

    public int printSuperheroArrayListSize() {
        return superheroArrayList.size();
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
    public void sortByHeroName() {
        Collections.sort(superheroArrayList, new Heronamecomparator());
    }
    public void sortByRealName() {
        Collections.sort(superheroArrayList, new Realnamecomparator());
    }
    public void sortBySuperPower() {
        Collections.sort(superheroArrayList, new Superpowercomparator());
    }
    public void sortByStrength() {
        Collections.sort(superheroArrayList, new Strengthcomparator());
    }
    public void sortByBirthYear() {
        Collections.sort(superheroArrayList, new Birthyearcomparator());
    }
    public void sortByIsHuman() {
        Collections.sort(superheroArrayList, new Ishumancomparator());
    }
}


