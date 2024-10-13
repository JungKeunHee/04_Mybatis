package view;

import controller.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {

    public void display() {

        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do {

            System.out.println("================HiMedia 메뉴 관리 시스템================");
            System.out.println("1. 메뉴 전체 조회하기");
            System.out.println("2. 금액별 추천 메뉴 조회하기");
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
                    menuController.selectByMenuPrice(inputPrice());
                    break;
//                case 3:
//                    menuController.insertMenu(inputMenu());
//                    break;
//                case 4:
//                    menuController.modifyMenu(inputModifyMenu());
//                    break;
//                case 5:
//                    menuController.deleteMenu(inputDeleteMenu());
//                    break;
                default:
                    System.out.println("메뉴에 맞는 번호를 눌러주세요...");
                    break;
            }

        } while (true);
    }

    private static int inputPrice(){

        Scanner sc = new Scanner(System.in);
        System.out.print("현재 가지고 계신 금액을 입력해주세요 : ");
        int price = sc.nextInt();

        return price;

    }

    private static Map<String, String> inputMenu (){

        // 메뉴 이름, 가격, 카테고리 코드를 입력 받아 넘겨주기
        Scanner sc = new Scanner(System.in);
        System.out.print("신규 메뉴 이름을 입력해주세요 : ");
        String menuName = sc.nextLine();

        System.out.print("가격을 입력해주세요 : ");
        String menuPrice = sc.nextLine();

        System.out.print("카테고리 번호를 입력해주세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    private static Map<String, String> inputModifyMenu () {

        Scanner sc = new Scanner(System.in);
        System.out.print("수정할 메뉴 코드를 입력해주세요 : ");
        String menuCode = sc.nextLine();

        System.out.print("수정할 메뉴 이름을 입력해주세요 : ");
        String menuName = sc.nextLine();

        System.out.print("수정할 메뉴 가격을 입력해주세요 : ");
        String menuPrice = sc.nextLine();

        System.out.print("수정할 카테고리 번호를 입력해주세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);
        parameter.put("menuName", menuName);
        parameter.put("menuPrice", menuPrice);
        parameter.put("categoryCode", categoryCode);

        return parameter;

    }

    private static Map<String, String> inputDeleteMenu () {

        Scanner sc = new Scanner(System.in);
        System.out.print("삭제할 메뉴 코드를 입력해주세요 : ");
        String menuCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("menuCode", menuCode);

        return parameter;

    }


}
