package org.mumu.Controller;

import org.mumu.Models.Fruit;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("fruit")
public class FruitController {
    List<Fruit> fruits = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fruit> getFruits() {
        return fruits;
    }

    @GET
    @Path("{index}")
    public Fruit getFruitById(@PathParam("index") Integer index){
        return fruits.get(index);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Fruit addFruit(Fruit fruit){
        fruits.add(fruit);
        return fruit;
    }

    @POST
    @Path("batch")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Fruit> addFruits(List<Fruit> lotOfFruit){
        for (Fruit fruit : lotOfFruit){
            fruits.add(fruit);
        }
        return lotOfFruit;
    }
}
