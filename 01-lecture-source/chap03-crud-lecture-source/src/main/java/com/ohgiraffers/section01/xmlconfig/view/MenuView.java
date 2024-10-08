package com.ohgiraffers.section01.xmlconfig.view;

import com.ohgiraffers.section01.xmlconfig.controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MenuView {


    /* comment.
    *   우리는 아직 Server 에 대한 개념과 프론트엔드에 대한 개념을
    *   배우지 않았다.
    *   따라서 실질적으로 사용자들이 볼 수 있는 화면을 만들 수는 없지만,
    *   콘솔창을 사용자들이 볼 수 있는 화면이라고 생각하고 진행해보자.
    *  */


    /* comment.
    *   1. 메뉴 전체 조회
    *   2. 메뉴 코드로 메뉴 조회
    *   3. 신규 메뉴 등록
    *   4. 메뉴 수정
    *   5. 메뉴 삭제
    *  */
    public void display() {

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do {

            System.out.println("================HiMedia 메뉴 관리 시스템================");
            System.out.println("1. 메뉴 전체 조회하기");
            System.out.println("2. 메뉴 코드로 메뉴 조회하기");
            System.out.println("3. 신규 메뉴 등록하기");
            System.out.println("4. 메뉴 수정하기");
            System.out.println("5. 메뉴 삭제하기");
            System.out.println("=====================================================");

            System.out.print("실행할 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    menuController.selectAllMenu();
                    break;
                case 2:
                    menuController.selectMenuByCode(inputMenuCode());
                    break;
                case 3:
                    menuController.insertMenu(inputMenu());
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    System.out.println("메뉴에 맞는 번호를 눌러주세요...");
                    break;
            }

        } while (true);

    }

    private static Map<String, String> inputMenuCode(){

        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 메뉴 코드를 입력해주세요 : ");
        String menuCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);

        return parameter;

    }

    private static Map<String, String> inputMenu (){

        // 메뉴 이름, 가격, 카테고리 코드를 입력 받아 넘겨주기
        Scanner sc = new Scanner(System.in);
        System.out.print("신규 메뉴 이름을 입력해주세요 : ");
        String menuName = sc.nextLine();

        System.out.print("가격을 입력해주세요 : ");
        String menuPrice = sc.nextLine();

        System.out.println("카테고리 번호를 입력해주세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

}
