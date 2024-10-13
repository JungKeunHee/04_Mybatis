package view;

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
}
