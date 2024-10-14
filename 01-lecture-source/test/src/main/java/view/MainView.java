package view;

import controller.MenuController;
import model.dto.MenuDTO;

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
                case 3:
                    menuController.insertMenu(inputMenu());
                    break;
                case 4:
                    menuController.modifyMenu(inputModifyMenu());
                    break;
//                case 5:
//                    menuController.deleteMenu(inputDeleteMenu());
//                    break;
                default:
                    System.out.println("메뉴에 맞는 번호를 눌러주세요...");
                    break;
            }

        } while (true);
    }

    private static Map<String, String> inputPrice(){

        Scanner sc = new Scanner(System.in);
        System.out.print("현재 가지고 계신 금액을 입력해주세요 : ");
        String price = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("price", price);

        return parameter;

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
        MenuController menuController = new MenuController();
        Map<String, String> parameter = new HashMap<>();

        menuController.selectAllMenu();
        System.out.print("수정을 원하는 메뉴 번호를 입력해주세요");
        String menuCode = sc.nextLine();

        do {
            System.out.println("1. 메뉴이름 수정");
            System.out.println("2. 메뉴가격 수정");
            System.out.println("3. 카테고리 수정");
            System.out.println("4. 판매상태 수정");
            System.out.println("5. 전체 수정");
            System.out.println("6. 선택하신 번호 확인 후 메뉴 수정 진행");
            System.out.println("0. 이 전으로 돌아가기");
            System.out.print("수정을 원하시는 메뉴 번호를 선택해주세요 (여러 개 선택가능) : ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    System.out.print("수정하실 메뉴 이름을 입력해주세요 : ");
                    String menuName = sc.nextLine();
                    break;
                case 2:
                    System.out.print("수정하실 메뉴 가격을 입력해주세요 : ");
                    String menuPrice = sc.nextLine();
                    break;
                case 3:
                    System.out.print("수정하실 카테고리 번호를 입력해주세요 : ");
                    String categoryCode = sc.nextLine();
                    break;
                case 4:
                    System.out.print("수정하실 판매상태를 입력해주세요(Y or N) : ");
                    String orderableStatus = sc.nextLine().toUpperCase();
                    break;


            }


        }while (true);


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
