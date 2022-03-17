    package com.example;

import com.example.entity.Villain;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

    @Path("/hello")
public class ExampleResource {

    @Inject
    ReactiveGreetingService service;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Villain hello() {
        Villain villain = new Villain();
        villain.name = "test";
        villain.level = 2;

//        villain.id = 1L;
        villain.persist();
        System.out.println(villain.id);

        System.out.println(Villain.findById(1L));
        List<Villain> villains = Villain.listAll();

        villain = Villain.findById(1L);
        System.out.println(villain);
        long countAll = Villain.count();
        System.out.println(countAll);

        Class villainClass = Villain.class;
//        System.out.println(villainClass.getTypeName());;

        return villain;
    }


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public Uni<String> greeting(String name) {
        System.out.println("test");
        return service.greeting(name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/{name}")
    public Multi<String> greetings(int count, String name) {
        System.out.println("test");
        return service.greetings(count, name);
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting/1")
    public void greetings() {
        System.out.println("void");
    }

//    @GET
//    @Produces(MediaType.SERVER_SENT_EVENTS)
//    @RestSseElementType(MediaType.TEXT_PLAIN)
//    @Path("/stream/{count}/{name}")
//    public Multi<String> greetingsAsStream(int count, String name) {
//        return service.greetings(count, name);
//    }


}