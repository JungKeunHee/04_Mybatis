package model.dao;

import model.dto.MenuDTO;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    List<MenuDTO> selectAllMenu();

    List<MenuDTO> selectByMenuPrice(Map<String, Integer> selectMenu);
}
