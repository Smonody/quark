package com.example.producer;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/async")
public class EventResource {

    @Inject
    EventBus bus;                                       

//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    @Path("/t1")
//    public Uni<String> greeting(@PathParam String name) {
//        return bus.<String>request("greeting", name)
//                .onItem().transform(Message::body);
//    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/test/{name}")
    public Object test(@PathParam String name){
        // Case 1
        bus.send("greeting", name);
// Case 2
//        bus.publish("greeting", name);
// Case 3
        Uni<String> response = bus.<String>request("address", "hello, how are you?")
                .onItem().transform(Message::body);

        return response;
    }
}