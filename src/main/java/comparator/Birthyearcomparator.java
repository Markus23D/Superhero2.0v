package comparator;


import data.Superhero;

import java.util.Comparator;

public class Birthyearcomparator  implements Comparator<Superhero> {


    @Override
    public int compare(Superhero o1, Superhero o2) {
        return Integer.compare(o1.getBirthYear(), o2.getBirthYear());
    }
}
