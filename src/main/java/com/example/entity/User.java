package com.example.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.io.Serializable;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: lemdeng
 * @date: 2022/2/14
 **/
@Entity(name = "user")
@Data
@Cacheable
@JsonSerialize
public class User extends PanacheEntity implements Serializable {


    @Column
    @Schema(title = "姓名", required = true, example = "kl")
    private String username;

    @Column
    private Integer age;

}
