package com.ohgiraffers.section03.remix.common;

import com.ohgiraffers.section03.remix.model.dao.MenuMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

public class Template {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSession getSqlSession() {

        // 만약 SqlSessionFactory가 없다면?
        if (sqlSessionFactory == null){
            // 만들 수 있는 환경을 만들어준다 Enviroment
            Environment environment = new Environment(
                    "dev",
                    new JdbcTransactionFactory(),
                    new PooledDataSource(DRIVER, URL, USER, PASSWORD)
            );

            // 만들어둔 환경을 가지고 설정을 해준다 Configuration
            Configuration configuration = new Configuration(environment);

            // comment. 작성한 MenuMapper 인터페이스 mapper 로 등록
            configuration.addMapper(MenuMapper.class);

            // 환경과 설정을 모두 마친 후 sqlSessionFactory 를 만들어준다
            // 공장을 만들 객체 SqlSessionFactoryBuilder, 그 공장을 사람들이 설정값 기준으로 만들어야 하므로 build(설정값)
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

        } return sqlSessionFactory.openSession(false);

    }

}
