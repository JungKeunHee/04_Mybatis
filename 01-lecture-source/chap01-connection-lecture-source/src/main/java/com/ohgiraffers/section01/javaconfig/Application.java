package com.ohgiraffers.section01.javaconfig;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import java.io.InputStream;
import java.util.Date;
import java.util.Map;

public class Application {

    private static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/menudb";
    private static String USER = "ohgiraffers";
    private static String PASSWORD = "ohgiraffers";

    public static void main(String[] args) {

        // MyBatis 기능을 사용하기 위한 환경 설정

        /* index. 1. 환경 구성 */
        /* comment.
        *   JdbcTransactionFactory : 수동 커밋
        *   ManagedTransactionFactory : 자동 커밋
        *   -------------------------------------
        *   PooledDataSource : ConnectionPoll 사용
        *   UnPooleDataSource :  ConnectionPool 미사용
        *  */
        Environment environment = new Environment("dev", new JdbcTransactionFactory(), new PooledDataSource(DRIVER, URL, USER, PASSWORD));

        /* index. 2. 만들어둔 환경 정보를 바탕으로 MyBatis 설정 구성 */
        Configuration configuration = new Configuration(environment);

        /* index. 4. DataBase 와 접근을 할 수 있는 클래스 등록 */
        configuration.addMapper(Mapper.class);

        /* index. 3. DataBase 와 접속 할 정보 만들었다. 이제 Session 구성 */
        /* comment.
        *   SqlSession 을 만들기 위한 준비 단계
        *   SqlSessionFactory : SqlSession 객체를 생성하기 위한 팩토리(공장)
        *                       역할의 인터페이스
        *   SqlSessionFactoryBuilder
        *   - SqlSessionFactory 인터페이스 타입의 하위 구현 객체를 생성하기 위한
        *   - 빌드 역할을 수행한다.
        *   build()
        *   - 환경 설정에 대한 정보를 담고 있는 Configuration 타입의 객체
        *   - 혹은 외부 설정 파일과 연결 된 Stream 을 매개변수로 전달하면
        *   - SqlSessionFactory 인터페이스 타입의 객체를 반환
        *  */

        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);

        /* comment.
        *   openSession()
        *   - SqlSession 인터페이스 타입의 객체를 반환하는 메소드
        *   - boolean 타입을 인자로 전달할 수 있다.
        *   - false 를 전달하게 되면
        *   - Connection 인터페이스 타입 객체로 DML 수행 후 autocommit
        *   - 설정을 꺼주게 된다. (권장)
        *  */
        SqlSession sqlSession = factory.openSession(false);

        /* index. 5. 등록한 매퍼를 활용해서 내부에 작성한 기능을 수행 */
        Mapper mapper = sqlSession.getMapper(Mapper.class);

        Date date = mapper.selectSysDate();

        System.out.println(date);

        sqlSession.close();
    }
}
