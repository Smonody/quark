package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.Repository.UserRepository;
import com.example.ano.TestAno;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import io.quarkus.vertx.web.Route;
import io.quarkus.vertx.web.Route.HttpMethod;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.smallrye.mutiny.helpers.BlockingIterable;
import io.vertx.core.http.HttpServerRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
//import org.eclipse.microprofile.openapi.annotations.Operation;
//import org.eclipse.microprofile.openapi.annotations.tags.Tag;


/**
 * @className: UserController
 * @description: TODO 类描述
 * @author: lemdeng
 * @date: 2022/2/14
 **/
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "UserResource",description = "用户接口列表")
public class UserController {


    @Inject
    private UserRepository userRepository;

    @Autowired
    @Resource
    private UserMapper userMapper;

    @Path( "/getUserlist")
    @GET
    @TestAno
    @Operation(summary = "创建用户", description = "这是一个创建用户的接口")
    public Iterable<User> list(){
        return userRepository.findAll();
    }
//
    @Path("/jpa")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public User userUni() throws ExecutionException, InterruptedException {
        Optional<User> user = userRepository.findById(1l);
        return Uni.createFrom().item(user.get()).subscribe().asCompletionStage().get();
    }

    @Path("/userList")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Object userList() throws ExecutionException, InterruptedException {
        Optional<User> user = userRepository.findById(1l);


        return Uni.createFrom().item(user.get()).ifNoItem();
    }

    @GET
    @Path("/download")
    @Produces(MediaType.APPLICATION_JSON)
    public String download() {
        return "hello";
    }

    @Path("/userMulti")
    @GET
    public BlockingIterable<Iterable<User>> userMulti(){
        Iterable<User> users = userRepository.findAll();
        Multi<Iterable<User>> userMulti = Multi.createFrom().items(users);
        userMulti.subscribe().with(item -> System.out.println(item));
        System.out.println(" --------------------------- ");
        return userMulti.subscribe().asIterable();
    }

    @Route(path = "getUni",methods = HttpMethod.GET)
    public Uni<ArrayList<User>> getUni(){
        ArrayList<User> arrayList = new ArrayList();
        User user = new User();
        user.id = 1l;
        user.setUsername("ser");
        arrayList.add(user);
        return Uni.createFrom().item(arrayList);
    }

    @Path("/mybatis")
    @GET
    public BlockingIterable<Iterable<User>> mybatisMu(){
        QueryWrapper queryWrapper = new QueryWrapper();
        Iterable<User> users = userMapper.selectList(queryWrapper);
        Multi<Iterable<User>> userMulti = Multi.createFrom().items(users);
        userMulti.subscribe().with(item -> System.out.println(item));
        return userMulti.subscribe().asIterable();
    }

    @Path("/testEn")
    @GET
    public String test(){
        return "hello 测试";
    }

    
}
