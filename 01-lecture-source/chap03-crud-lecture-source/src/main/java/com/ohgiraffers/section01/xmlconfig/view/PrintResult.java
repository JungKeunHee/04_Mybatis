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
}
