package com.ohgiraffers.section01.dynamic;

import com.ohgiraffers.common.SearchCriteria;

import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        /* title. Mybatis Dynamic SQL 확인하기 */
        Scanner sc = new Scanner(System.in);

        do {

            System.out.println("===========마이바티스 동적 SQL 학습 메뉴==============");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where, set) 확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1:
                    ifsubMenu();
                    break;
                case 2:
                    chooseSubMenu();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다...");
                    return;
                default:
                    System.out.println("메뉴에 맞는 번호를 입력해주세요...");
                    break;
            }


        } while (true);
    }

    public static void ifsubMenu(){

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("===================if 서브메뉴====================");
            System.out.println("1. 원하는 금액대 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 or 카테고리 명으로 검색해서 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("원하는 메뉴를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    menuService.selectMenuByPrice(inputPrice());
                    break;
                case 2:
                    menuService.searchMenu(inputSearchCriteria());
                    break;
                case 9:
                    System.out.println("if 서브메뉴 종료");
                    return;
            }

        }while (true);

    }

    private static int inputPrice() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색하실 가격의 최대 금액을 입력 해주세요  : ");
        int price = sc.nextInt();

        return price;
    }

    private static SearchCriteria inputSearchCriteria() {

        Scanner sc = new Scanner(System.in);
        System.out.print("검색 기준을 선택해주세요(menuName or category) : ");
        String condition = sc.nextLine();

        System.out.print("검색어를 입력해주세요 : ");
        String value = sc.nextLine();

        return new SearchCriteria(condition, value);

    }

    public static void chooseSubMenu(){

        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();

        do {
            System.out.println("===============choose 서브 메뉴==================");
            System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기(식사, 음료, 디저트)");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("메뉴 번호를 입력해주세요 : ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    menuService.searchMenuBySupCategory(inputSupCategory());
                    break;
                case 9:
                    System.out.println("choose 서브 메뉴 종료");
                    return;
            }
        }while (true);
    }

    private static SearchCriteria inputSupCategory() {

        Scanner sc = new Scanner(System.in);
        System.out.print("상위 분류를 입력해주세요(식사, 음료, 디저트) : ");
        String value = sc.nextLine();

        return new SearchCriteria("category", value);
    }


}
