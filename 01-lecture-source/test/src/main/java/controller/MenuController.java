package controller;

import model.dto.MenuDTO;
import model.service.MenuService;
import view.PrintView;

import java.awt.*;
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

    public void selectByMenuPrice(Map<String, String> parameter) {

        int price = Integer.parseInt(parameter.get("price"));

        MenuDTO selectPrice = new MenuDTO();
        selectPrice.setMenuPrice(price);

        List<MenuDTO> menuList = menuService.selectByMenuPrice(selectPrice);

        if (menuList != null && menuList.size() > 0){
            printView.selectMenuByPrice(menuList);
        } else {
            printView.selectAllError("selectMenuError");
        }

    }

    public void insertMenu(Map<String, String> parameter) {

        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        MenuDTO newMenu = new MenuDTO();

        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);

        if(menuService.inputNewMenu(newMenu)){
            printView.inputNewMenu();
        } else {
            printView.selectAllError("inputError");
        }

    }

    public void modifyMenu(Map<String, String> modifyMenu) {

        if(menuService.modifyMenu(modifyMenu)){
            printView.successMenu("successModify");
        } else {
            printView.selectAllError("modifyError");
        }

    }

    public void deleteMenu(Map<String, String> deleteMenu) {

        if(menuService.deleteMenu(deleteMenu)){
            printView.successMenu("successDelete");
        } else {
            printView.selectAllError("deleteError");
        }
    }
}
