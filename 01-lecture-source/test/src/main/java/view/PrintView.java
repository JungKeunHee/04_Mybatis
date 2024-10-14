package view;

import controller.MenuController;
import model.dto.MenuDTO;

import java.util.List;

public class PrintView {

    public void selectAllMenu(List<MenuDTO> menuList) {

        for (MenuDTO menuAllList : menuList){
            System.out.println(menuAllList);
        }

    }

    public void selectAllError(String errorMessage) {

        switch(errorMessage){
            case "selectAllError":
                System.out.println("메뉴 전체 조회에 실패하였습니다...");
                break;
            case "selectMenuError":
                System.out.println("메뉴 조회에 실패하였습니다...");
                break;
        }

    }

    public void selectMenuByPrice(List<MenuDTO> menuList){
        for (MenuDTO menuAllList : menuList){
            System.out.println(menuAllList);
        }
    }

    public void inputNewMenu() {
        MenuController menuController = new MenuController();

        menuController.selectAllMenu();
        System.out.println("신규 메뉴가 추가 되었습니다");
    }
}
