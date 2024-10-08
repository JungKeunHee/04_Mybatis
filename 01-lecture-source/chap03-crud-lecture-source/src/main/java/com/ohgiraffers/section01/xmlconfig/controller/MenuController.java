package com.ohgiraffers.section01.xmlconfig.controller;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;
import com.ohgiraffers.section01.xmlconfig.model.service.MenuService;
import com.ohgiraffers.section01.xmlconfig.view.PrintResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuController {

    /* comment.
    *   Controller 의 역할
    *   view 에서 사용자가 입력한 정보를 파라미터 형태로 전달 받으면
    *   전달 받은 값들을 검증하거나, 추가적인 정보가 필요하면 가공을 한 뒤
    *   service 쪽으로 전달하기 위한 인스턴스를 생성하여 담고
    *   service 의 비즈니스 로직을 담당하는 메소드를 호출한다.
    *   또한 호출한 수행 결과를 반환 받아 어떤 view 를 보여줄 지
    *   결정하는 역할을 수행하게 된다.
    *  */

    private final MenuService menuService;
    private final PrintResult printResult;


    public MenuController() {
        this.menuService = new MenuService();
        this.printResult = new PrintResult();
    }


    public void selectAllMenu() {

        List<MenuDTO> menuList = menuService.selectAllMenu();

        // 정상 조회
        if(menuList != null){
            printResult.printListMenu(menuList);
        } else {
            printResult.printErrorMessage("selectList");
        }


    }

    public void selectMenuByCode(Map<String, String> parameter) {

        // 나중에 나올 개념이지만, 나중에 화면에서 입력 받은 값을
        // 컨트롤러가 전달 받게 되면 String 타입으로 넘어오게 된다.
        // 사용자가 입력한 String 타입의 값을 우리가 설계한 자료형에 맞게 parsing
        int code = Integer.parseInt(parameter.get("menuCode"));

        MenuDTO menu = menuService.selectMenuByMenuCode(code);

        if (menu != null){
            printResult.printMenu(menu);
        } else {
            printResult.printErrorMessage("selectOne");
        }


    }

    public void insertMenu(Map<String, String> parameter) {

        String menuName = parameter.get("menuName");
        int menuPrice = Integer.parseInt(parameter.get("menuPrice"));
        int categoryCode = Integer.parseInt(parameter.get("categoryCode"));

        // 서로 다른 자료형을 가진 연관있는 값을 클래스로 뭉쳐서 전달
        // MenuDTO 클래스 사용
        MenuDTO newMenu = new MenuDTO();
        newMenu.setMenuName(menuName);
        newMenu.setMenuPrice(menuPrice);
        newMenu.setCategoryCode(categoryCode);

        menuService.insertNewMenu(newMenu);
    }
}
