import data.Database;
import data.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class SuperHeroTest {

    private Database database;


    @BeforeEach
    public void setUp() {
        database = new Database();
    }

    @Test
    public void testAddSuperhero() {
        // lav en database og tilføj en superhelt

        database.addSuperhero("Superman", "Clark Kent", "Flight", 100, 1938, "Human");


        Superhero superhero = database.getSuperheroArrayList().get(0);


        String expectedHeroName = "Superman";
        String expectedRealName = "Clark Kent";
        String expectedSuperPower = "Flight";
        double expectedStrength = 100;
        int expectedBirthYear = 1938;
        String expectedIsHuman = "Human";


        assertEquals(expectedHeroName, superhero.getHeroName());
        assertEquals(expectedRealName, superhero.getRealName());
        assertEquals(expectedSuperPower, superhero.getSuperPower());
        assertEquals(expectedStrength, superhero.getStrength());
        assertEquals(expectedBirthYear, superhero.getBirthYear());
        assertEquals(expectedIsHuman, superhero.getIsHuman());
    }

    @Test
    public void testPrintAllSuperheroes() {

        // tilføj superhelte til database
        database.addSuperhero("Superman", "Clark Kent", "Flight", 100, 1938, "Human");
        database.addSuperhero("Batman", "Bruce Wayne", "Detective Skills", 90, 1939, "Human");

        String result = database.printAllSuperheroes();

        String expectedOutput = database.printAllSuperheroes();

        assertEquals(expectedOutput, result);
    }


    @Test
    public void testfindHeroName() {

        // tilføj superhelte til database
        database.addSuperhero("Superman", "Clark Kent", "Flight", 100, 1938, "Human");
        database.addSuperhero("Batman", "Bruce Wayne", "Detective Skills", 90, 1939, "Human");

        // søg af superhelt navn
        ArrayList<Superhero> findheroNames = database.findHeroName("man");

        assertEquals(2, findheroNames.size()); //


        // check om search resultat har den superhero man forventer
        assertTrue(findheroNames.stream().anyMatch(hero -> hero.getHeroName().equals("Superman")));
        assertTrue(findheroNames.stream().anyMatch(hero -> hero.getHeroName().equals("Batman")));
    }

    @Test
    public void testDeleteSuperhero() {
        // Create a superhero and add it to the database

        database.addSuperhero("Superman", "Clark Kent", "Flight", 100, 1938, "Human");

        Superhero superhero = database.getSuperheroArrayList().get(0);

        // Ensure the superhero is in the database
        ArrayList<Superhero> superheroList = database.getSuperheroArrayList();
        assertEquals(1, superheroList.size());
        assertTrue(superheroList.contains(superhero));

        // Delete the superhero from the database
        database.deleteSuperhero(superhero);

        // Check if the superhero has been removed from the database
        assertEquals(0, superheroList.size());
        assertFalse(superheroList.contains(superhero));
    }
    @Test
    public void testSaveAndLoadSuperheroData() {
        String fileName = "superhero.csv";
        ArrayList<Superhero> superheroArrayList = new ArrayList<>();
        Superhero superhero1 = new Superhero("Superman1", "Clark Kent1", "Flight1", 101, 1938, "Human");
        Superhero superhero2 = new Superhero("Superman2", "Clark Kent2", "Flight2", 102, 1939, "Void");
        Superhero superhero3 = new Superhero("Superman3", "Clark Kent2", "Flight3", 103, 1940, "String");

        try {
            PrintStream output = new PrintStream(fileName);
            output.println("Heroname,Realname,SuperPower,Strength,BirthYear,IsHuman");
            for (Superhero superhero : superheroArrayList) {
                output.println(superhero.csvString());
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        Scanner scanner = new Scanner(fileName);
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

                Superhero superhero = new Superhero(heroName, realName, superpower, strength, birthYear, isHuman);
                superheroArrayList.add(superhero);
                assertEquals(3, superheroArrayList.size());
            }
        }
    }

}