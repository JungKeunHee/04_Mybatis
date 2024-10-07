package com.ohgiraffers.section01.xmlconfig;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTemplate {

    /* comment.
    *   SqlSessionFactory 는 어플리케이션 스코프를 가진다
    *   즉 Application 이 run 하면 생성을 하고
    *   끝날 때까지 유지한다 라는 뜻을 가진다.
    *   Application 이 실행되는 동안 여러 차례 Factory 를
    *   만드는 것은 나쁜 냄새가 나는 코드를 만드는 것이다.
    *   가장 좋은 방식은 싱글톤 패턴을 이용하는 것이다.
    *   (1개의 인스턴스를 공유)
    *  */

    private static SqlSessionFactory sqlSessionFactory;

    // session 필요할 때 호출하는 메소드
    public static SqlSession getSqlSession(){
        // factory 만든 적이 없다면
        if (sqlSessionFactory == null){

            String resource = "mybatis-config.xml";

            try {
                InputStream inputStream = Resources.getResourceAsStream(resource);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        SqlSession sqlSession = sqlSessionFactory.openSession(false);

        System.out.println("SqlSessionFactory 의 hashcode : " + sqlSessionFactory.hashCode());
        System.out.println("SqlSession 의 hashcode : " + sqlSession.hashCode());

        return sqlSession;

    }

}
