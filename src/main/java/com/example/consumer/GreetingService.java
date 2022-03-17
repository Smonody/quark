package com.example.consumer;

import io.quarkus.vertx.ConsumeEvent;

import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.infrastructure.Infrastructure;
import io.vertx.core.eventbus.Message;
import java.util.concurrent.Executor;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.context.ManagedExecutor;

@ApplicationScoped
public class GreetingService {

    @Inject
    ManagedExecutor executor;

//    quarks线程池
    Executor executor1 = Infrastructure.getDefaultWorkerPool();

    @ConsumeEvent(value = "blocking-consumer")
    public String consume(String name) {    
        return name.toUpperCase();
    }


    //    @ConsumeEvent("greeting")
    //    public Uni<String> consume2(String name) {
    //        return Uni.createFrom().item(() -> name.toUpperCase()).emitOn(executor);
    //    }

    @ConsumeEvent("greeting")
    public void consume(Message<String> msg) {
        System.out.println(msg.address());
        System.out.println(msg.body());
    }
}