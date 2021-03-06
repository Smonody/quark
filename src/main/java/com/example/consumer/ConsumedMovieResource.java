package com.example.consumer;

import io.smallrye.mutiny.Multi;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.reactive.messaging.Channel;

@ApplicationScoped
@Path("/consumed-movies")
public class ConsumedMovieResource {

    @Channel("movies-from-kafka")
    Multi<Movie> movies;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
//    @RestSseElementType(MediaType.TEXT_PLAIN)
    public Multi<String> stream() {
        return movies.map(movie -> String.format("'%s' from %s", movie.getTitle(), movie.getYear()));
    }
}
