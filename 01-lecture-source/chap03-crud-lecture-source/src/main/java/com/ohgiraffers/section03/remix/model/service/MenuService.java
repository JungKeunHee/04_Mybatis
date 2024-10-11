package com.ohgiraffers.section03.remix.model.service;

import com.ohgiraffers.section03.remix.model.dao.MenuMapper;
import com.ohgiraffers.section03.remix.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.section03.remix.common.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;


    public List<MenuDTO> selectAllMenu() {

        // 1. SqlSession 생성
        SqlSession sqlSession = getSqlSession();

        // 2. Template 에 등록 한 Mapper 파일 사용 준비
        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        // 3. 사용한 SqlSession 닫기
        sqlSession.close();

        return menuList;
    }

    public MenuDTO selectMenuByMenuCode(int code) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        MenuDTO selectMenuByMenuCode = menuMapper.selectMenuCode(code);

        sqlSession.close();

        return selectMenuByMenuCode;

    }


    public boolean insertNewMenu(MenuDTO newMenu) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.insertMenu(newMenu);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }

    public boolean modifyMenu(MenuDTO modifyMenu) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.updateMenu(modifyMenu);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;

    }

    public boolean deleteMenu(MenuDTO menu) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.deleteMenu(menu);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }

        sqlSession.close();

        return result > 0 ? true : false;
    }
}
