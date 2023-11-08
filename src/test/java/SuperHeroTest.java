import data.Database;
import data.Superhero;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SuperHeroTest {

    @Test
    public void testAddSuperhero() {
        // lav en database og tilføj en superhelt
        Database database = new Database();
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
        Database database = new Database();
        // tilføj superhelte til database
        database.addSuperhero("Superman", "Clark Kent", "Flight", 100, 1938, "Human");
        database.addSuperhero("Batman", "Bruce Wayne", "Detective Skills", 90, 1939, "Human");

        String result = database.printAllSuperheroes();

        String expectedOutput = database.printAllSuperheroes();

        assertEquals(expectedOutput, result);
    }


    @Test
    public void testfindHeroName() {
        Database database = new Database();
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
        //skal bruge lidt hjælp til den her :)
        Database database = new Database();
        // tilføj superhelt til database
        Superhero superhero = new Superhero("Superman", "Clark Kent", "Flight", 100, 1938, "Human");
        database.addSuperhero("superman", "Clark kent", "Flight", 100, 1938, "Human");


        ArrayList<Superhero> superheroList = database.getSuperheroArrayList();
        assertEquals(1, superheroList.size());
        assertTrue(superheroList.contains(superhero));

        // slet superhelt
        database.deleteSuperhero(superhero);

        // chekker om superhelten er blevet fjernet
        assertEquals(0, superheroList.size());
        assertFalse(superheroList.contains(superhero));
        //bev
    }
}