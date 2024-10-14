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
            case "modifyError":
                System.out.println("메뉴 수정에 실패하였습니다...");
                break;
            case "deleteError":
                System.out.println("메뉴 삭제에 실패하였습니다...");
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

    public void successMenu(String successMessage) {

        MenuController menuController = new MenuController();

        switch (successMessage){
            case "successModify":
                menuController.selectAllMenu();
                System.out.println("메뉴 수정 완료!!!");
                break;
            case "successDelete":
                menuController.selectAllMenu();
                System.out.println("메뉴 삭제 성공!!!");
                break;
        }

    }
}
