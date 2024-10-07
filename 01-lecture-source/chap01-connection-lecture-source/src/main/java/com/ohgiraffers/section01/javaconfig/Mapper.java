package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.annotations.Select;

import java.util.Date;

public interface Mapper {
    // DUAL : 가상의 테이블
    @Select("SELECT CURRENT_DATE FROM DUAL")
    Date selectSysDate();
}
