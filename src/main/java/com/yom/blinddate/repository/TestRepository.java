package com.yom.blinddate.repository;

import com.yom.blinddate.model.TestModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TestRepository {
    List<TestModel> selectAll();
}
