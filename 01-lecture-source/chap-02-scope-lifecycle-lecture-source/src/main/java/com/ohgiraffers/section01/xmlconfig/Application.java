package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.session.SqlSession;

import static com.ohgiraffers.section01.xmlconfig.MybatisTemplate.getSqlSession;

public class Application {

    public static void main(String[] args) {

        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());
        System.out.println(getSqlSession());

    }
}
