package com.yom.blinddate.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TestTwoRepository {
    boolean isExist();
}
