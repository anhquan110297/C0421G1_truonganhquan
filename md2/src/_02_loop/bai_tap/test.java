package _02_loop.bai_tap;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Chọn hình mà bạn muốn in");
        System.out.println("1. Hình chữ nhật rectangle");
        System.out.println("2. Hình tam giác vuông ở các góc...");
        System.out.println("3. Hình tam giác cân...");
        System.out.println("Input your choice");
        byte choice = scanner.nextByte();
        switch (choice){
            case 1:
                System.out.println("Nhập chiều cao cho rectangle: ");
                byte height = scanner.nextByte();
                System.out.println("Nhập chiều rộng cho rectangle: ");
                byte width = scanner.nextByte();
                for (byte i=0; i<height; i++){
                    for (byte j=0; j<width; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;

            case 2:
                System.out.println("Nhập chiều cao cho triangle: ");
                byte heightTri = scanner.nextByte();
                System.out.println("Tam giác có vuông ở top left");
                for (byte i=0; i<heightTri; i++){
                    for (int j= (heightTri-i); j>0; j--){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                System.out.println("Tam giác vuông ở top right");
                for (byte i=0; i<heightTri; i++){
                    for (int j= 0; j<heightTri; j++){
                        if (j<i){
                            System.out.print(" ");
                        }else {
                            System.out.print("*");
                        }
                    }
                    System.out.println();
                }
                System.out.println("Tam giac vuông ở bottom left");
                for (byte i=0; i<heightTri; i++){
                    for (int j= 0; j<=i; j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                System.out.println("Tam giac vuông ở bottom right");
                for (byte i=1; i<=heightTri; i++){
                    for (int j= heightTri; j>0; j--){
                        if ((j<=i)){
                            System.out.print("*");
                        }else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            case 3:
                System.out.println("Nhập chiều cao cho iso triangle: ");
                byte heightIso = scanner.nextByte();
                for (byte i=0; i< heightIso; i++){
                    for (int j =( -heightIso+1); j<heightIso; j++){
                        if (j>=-i && j<=i ){
                            System.out.print("*");
                        }else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.println("No choice!!!");
        }
    }
}