package comparator;


import data.Superhero;

import java.util.Comparator;

public class Superpowercomparator  implements Comparator<Superhero> {


    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getSuperPower().compareTo(o2.getSuperPower());
    }
}
