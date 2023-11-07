package data;

import java.util.ArrayList;
import java.util.Comparator;

public class Controller {
    Database database = new Database();

    public void getSuperheroArrayList() {
        database.getSuperheroArrayList();
    }

    public void addSuperhero(String heroName, String realName, String superPower, int strength, int birthYear, String isHuman) {
        database.addSuperhero(heroName, realName, superPower, strength, birthYear, isHuman);
    }

    public String printAllSuperheroes() {
        return database.printAllSuperheroes();
    }

    public ArrayList<Superhero> search(String superHeroName) {
        return database.search(superHeroName);
    }

    public ArrayList<Superhero> findHeroName(String heroName) {
        return database.findHeroName(heroName);
    }

    public void deleteSuperhero(Superhero superhero) {
        database.deleteSuperhero(superhero);
    }

    public void saveSuperheroes() {
        database.saveSuperheroes();
    }

    public void loadSuperHeroData() {
        database.loadSuperHeroData();
    }

    public void setPrimaryComparator(Comparator<Superhero> primaryComparator) {
        database.setPrimaryComparator(primaryComparator);
    }

    public void setSecondaryComparator(Comparator<Superhero> secondaryComparator) {
        database.setSecondaryComparator(secondaryComparator);
    }

    public void compareForPrimThenSec(int primary, int secondary) {
        database.compareForPrimThenSec(primary, secondary);
    }

    public void sort() {
        database.sort();
    }
}