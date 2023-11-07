package comparator;


import data.Superhero;

import java.util.Comparator;

public class Ishumancomparator  implements Comparator<Superhero> {


    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getIsHuman().compareTo(o2.getIsHuman());
    }
}
