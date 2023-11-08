import data.Database;
import data.Superhero;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

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

}