package com.yom.blinddate.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TestModel {
    private Long id;
    private String name;
    private String owner;
    private Date createdAt;
    private Date updatedAt;
}
