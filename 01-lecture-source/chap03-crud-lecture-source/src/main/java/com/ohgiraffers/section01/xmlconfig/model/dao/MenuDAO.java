package com.ohgiraffers.section01.xmlconfig.model.dao;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuDAO {

    /* comment.
    *   DAO(Data Access Object)
    *   - 데이터베이스에 접근하는 계층
    *   - 쿼리문을 전달하고 수행한 쿼리문에 대한 결과를 받는 역할을 한다.
    *  */

    public List<MenuDTO> selectAllMenu(SqlSession sqlSession) {

        return sqlSession.selectList("MenuMapper.selectAllMenu");

    }

    public MenuDTO selectMenuByMenuCode(SqlSession sqlSession, int code) {

        return sqlSession.selectOne("MenuMapper.selectMenuByCode", code);

    }

    public int insertNewMenu(SqlSession sqlSession, MenuDTO newMenu) {

        return sqlSession.insert("MenuMapper.insertNewMenu", newMenu);

    }

    public int updateMenu(SqlSession sqlSession, MenuDTO modifyMenu) {

        return sqlSession.update("MenuMapper.updateMenu", modifyMenu);
    }

    public int deleteMenu(SqlSession sqlSession, MenuDTO deleteMenuCode) {

        return sqlSession.delete("MenuMapper.deleteMenu", deleteMenuCode);
    }
}
