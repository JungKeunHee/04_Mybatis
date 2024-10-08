package com.ohgiraffers.section01.xmlconfig.view;

import com.ohgiraffers.section01.xmlconfig.model.dto.MenuDTO;

import java.util.List;

public class PrintResult {

    // 1번 전체조회를 누르고 실행되는 값을 보는 메소드
    public void printListMenu(List<MenuDTO> menuList) {

        System.out.println("요청하신 전체 메뉴 조회 결과 입니다.");

        for (MenuDTO menu : menuList){
            System.out.println(menu);
        }

        System.out.println("=================================================");
    }

    public void printErrorMessage(String errorCode) {

        String errorMessage = "";

        switch(errorCode){
            case "selectList":
                errorMessage = "메뉴 전체 조회에 실패하셨습니다...";
                break;
            case "selectOne":
                errorMessage = "요청하신 메뉴코드에 대한 조회가 실패하셨습니다...";
                break;
            case "insertError":
                errorMessage = "신규 메뉴 추가에 실패하셨습니다...";
                break;

            case "updateError":
                errorMessage = "메뉴 수정이 실패하셨습니다...";
                break;

            case "delete":
                errorMessage = "메뉴 삭제에 실패하셨습니다...";
        }

        System.out.println(errorMessage);

    }

    public void printMenu(MenuDTO menu) {

        System.out.println(menu.getMenuCode() + " 번 조회 결과입니다.");
        System.out.println(menu);
        System.out.println("=====================================================");
    }

    public void printSuccessMessage(String successCode) {

        String successMessage = "";
        switch(successCode){
            case "insert":
                successMessage = "신규 메뉴 등록 성공";
                break;
            case "update":
                successMessage = "메뉴 수정 성공";
                break;
            case "delete":
                successMessage = "메뉴 삭제 성공";
        }

        System.out.println(successMessage);

    }
}
