package main.java;

import java.util.ArrayList;

public class Map {
    private ArrayList<Case> map = new ArrayList<Case>();

    public Map() {
        for(Monde m:Monde.values()) {
            for(int i = 0; i<m.getNbCases(); i++) {
                Case temp = new Case(m, i);
                this.map.add(temp);
            }
        }
    }

    public Case getFirstCase(){
        return map.get(0);
    }

    public Case getLeft(Case c) {
        if(c.getNumCase() == 0) {
            return c;
        } else {
            for(Case ca:map) {
                if (ca.getNumMonde() == c.getNumMonde() && ca.getNumCase() == (c.getNumCase()-1)) {
                    return ca;
                }
            }
            return c;
        }
    }

    public Case getRight(Case c) {
        int temp = 0;
        for(Case ca:map) {
            if(ca==c && !(c.getNumMonde() == Monde.MONDE_3 && c.getNumCase() == Monde.MONDE_3.getNbCases())) {
                return map.get(temp+1);
            }
            temp++;
        }
        return c;
    }

}