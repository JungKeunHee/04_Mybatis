package controller;

import model.dto.MenuDTO;
import model.service.MenuService;
import view.PrintView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuController {

    private final MenuService menuService;
    private final PrintView printView;


    public MenuController () {
        this.menuService = new MenuService();
        this.printView = new PrintView();
    }

    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        if (menuList != null && menuList.size() > 0){
            printView.selectAllMenu(menuList);
        } else {
            printView.selectAllError("selectAllError");
        }

    }

    public void selectByMenuPrice(int price) {

        Map<String, Integer> map = new HashMap<>();
        map.put("price", price);

        List<MenuDTO> menuList = menuService.selectByMenuPrice(map);

        if (menuList != null){
            printView.selectMenuByPrice(menuList);
        } else {
            printView.selectAllError("selectMenuError");
        }

    }
}
