package com.example.producer;

import io.smallrye.mutiny.Multi;
import io.smallrye.reactive.messaging.annotations.Channel;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.SseElementType;

//@Path("/pr")
//public class PriceResource {
//
//    @Inject
//    @Channel("prices")
//    Multi<Double> prices;
//
//    @GET
//    @Path("/prices")
//    @Produces(MediaType.SERVER_SENT_EVENTS)
//    @SseElementType("text/plain")
//    public Multi<Double> stream() {
//        return prices;
//    }
//}