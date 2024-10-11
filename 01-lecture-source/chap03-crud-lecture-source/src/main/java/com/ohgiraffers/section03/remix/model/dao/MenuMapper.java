package com.ohgiraffers.section03.remix.model.dao;

import com.ohgiraffers.section03.remix.model.dto.MenuDTO;

import java.util.List;

public interface MenuMapper {

    List<MenuDTO> selectAllMenu();

    MenuDTO selectMenuCode(int code);

    int insertMenu(MenuDTO insertMenu);

    int updateMenu(MenuDTO modifyMenu);

    int deleteMenu(MenuDTO menu);
}
