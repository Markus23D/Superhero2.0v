package comparator;


import data.Superhero;

import java.util.Comparator;

public class Realnamecomparator  implements Comparator<Superhero> {


    @Override
    public int compare(Superhero o1, Superhero o2) {
        return o1.getRealName().compareTo(o2.getRealName());
    }
}
