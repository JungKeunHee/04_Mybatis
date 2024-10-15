package com.ohgiraffers.section01.xmlmapper;

import com.ohgiraffers.common.CategoryAndMenuDTO;
import com.ohgiraffers.common.MenuAndCategoryDTO;
import com.ohgiraffers.common.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.common.Template.getSqlSession;

public class ElementService {

    private ElementMapper mapper;

    public void selectCacheTest() {

        SqlSession sqlSession = getSqlSession();

        mapper = sqlSession.getMapper(ElementMapper.class);

        // 동일한 쿼리문을 여러 번 실행 테스트
        for (int i = 0; i < 10; i++){
            // 조회 시간 확인용 시작 시간 체크
            Long startTime = System.currentTimeMillis();

            List<String> menuNameList = mapper.selectCacheTest();
            System.out.println(menuNameList);

            // 조회 시간 확인용 끝나는 시간 체크
            Long endTime = System.currentTimeMillis();

            //총 걸린 시간 체크
            Long intarval = endTime - startTime;

            System.out.println("수행 시간 : " + intarval + "(ms)");

        }
        sqlSession.close();
    }

    public void selectResultMapTest() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menuList = mapper.selectResultMapTest();

        for (MenuDTO menuResultTest : menuList){
            System.out.println(menuResultTest);
        }

        sqlSession.close();
    }

    public void selectResultMapConstructor() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);
        List<MenuDTO> menu = mapper.selectResultMapConstructor();

        for (MenuDTO menuResultTest : menu){
            System.out.println(menuResultTest);
        }

        sqlSession.close();
    }

    public void selectResultMapAssociation() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);
        List<MenuAndCategoryDTO> menu = mapper.selectResultMapAssociationTest();

        for (MenuAndCategoryDTO menuResultTest : menu){
            System.out.println(menuResultTest);
        }

        sqlSession.close();
    }

    public void selectResultMapCollection() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);
        List<CategoryAndMenuDTO> menu = mapper.selectResultMapCollectionTest();

        for (CategoryAndMenuDTO menuResultTest : menu){
            System.out.println(menuResultTest);
        }

        sqlSession.close();

    }

    public void sqlTest() {

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ElementMapper.class);

        List<MenuDTO> menuList = mapper.selectSqlTest();

        for (MenuDTO menuResultTest : menuList){
            System.out.println(menuResultTest);
        }

        sqlSession.close();
    }
}
