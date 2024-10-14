package model.service;

import controller.MenuController;
import model.dao.MenuMapper;
import model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static common.Template.getSqlSession;

public class MenuService {

    private MenuMapper menuMapper;

    public List<MenuDTO> selectAllMenu() {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectAllMenu();

        sqlSession.close();

        return menuList;
    }

    public List<MenuDTO> selectByMenuPrice(MenuDTO selectPrice) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menuList = menuMapper.selectByMenuPrice(selectPrice);

        sqlSession.close();

        return menuList;
    }

    public boolean inputNewMenu(MenuDTO newMenu) {

        SqlSession sqlSession = getSqlSession();

        menuMapper = sqlSession.getMapper(MenuMapper.class);

        int result = menuMapper.inputNewMenu(newMenu);

        if (result > 0){
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        return result > 0 ? true : false;
    }
}
