package com.rayjackson.ood;

import com.rayjackson.ood.composite.Builder;
import com.rayjackson.ood.composite.Street;
import com.rayjackson.ood.composite.Town;
import org.junit.Test;

public class CompositeTest {

    @Test
    public void builderTown(){
        Builder builder = new Builder();
        Town town = builder.buildTown("Los Angeles");
        System.out.println(town.toString());
//        builder.buildStreet("Baker St.");
    }

    @Test
    public void builderStreet(){
        Builder builder = new Builder();
        Town town = builder.buildTown("Los Angeles");
        Street street = builder.buildStreet(town, "Ave");
        Street street1 = builder.buildStreet(town, "Ave1");
        System.out.println(town.getStreets());
    }

//    @Test
//    public void builder1() {
//        Town la = new Town("Los Angeles");
//        Street street = new Street(la, "Baker St.");
//        Builder builder = new Builder();
//        builder.buildHouse(la, street, 13);
//        System.out.println(street.getHouses().toString());
//    }

}
