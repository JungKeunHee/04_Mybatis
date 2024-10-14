package model.dao;

import model.dto.MenuDTO;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    List<MenuDTO> selectAllMenu();

    List<MenuDTO> selectByMenuPrice(MenuDTO selectPrice);

    int inputNewMenu(MenuDTO newMenu);

    int modifyMenu(Map<String, String> updateMenu);

    int deleteMenu(Map<String, String> deleteMenu);

    List<MenuDTO> selectRandomMenu(Map<String, List<Integer>> randomMenu);
}
