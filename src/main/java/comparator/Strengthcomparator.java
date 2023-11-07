package comparator;


import data.Superhero;

import java.util.Comparator;

public class Strengthcomparator  implements Comparator<Superhero> {


    @Override
    public int compare(Superhero o1, Superhero o2) {
        return Double.compare(o1.getStrength(), o2.getStrength());
    }
}
