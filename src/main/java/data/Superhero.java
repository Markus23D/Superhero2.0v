package data;

public class Superhero {
    private String heroName;
    private String realName;
    private String superPower;
    private double strength;
    private int birthYear;
    private String isHuman;

    public Superhero(String heroName, String realName, String superPower, double strength, int birthYear, String isHuman) {
        this.heroName = heroName;
        this.realName = realName;
        this.superPower = superPower;
        this.strength = strength;
        this.birthYear = birthYear;
        this.isHuman = isHuman;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }
    public String getSuperPower() {
        return superPower;
    }
    public double getStrength() {
        return strength;
    }
    public int getBirthYear(){
        return birthYear;
    }
    public String getIsHuman(){
        return isHuman;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public void setStrength(double strength) {
        this.strength = strength;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setIsHuman(String isHuman) {
        this.isHuman = isHuman;
    }

    public String toString() {
        return "Your superhero's hero name: " + heroName +
                "\n" + "your superhero's real name: " + realName +
                "\n" + "their super power: " + superPower +
                "\n" + "their power level: " + strength +
                "\n" + "year they were born: " + birthYear +
                "\n" + "are they human: " + isHuman;
    }



}
