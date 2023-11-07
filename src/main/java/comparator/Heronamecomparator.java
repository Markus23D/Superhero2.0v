package comparator;


import data.Superhero;

import java.util.Comparator;

public class Heronamecomparator  implements Comparator<Superhero> {


    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getHeroName().compareTo(o2.getHeroName());
    }
}
