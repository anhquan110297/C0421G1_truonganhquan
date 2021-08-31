package _00_bai_tap_them.tu_hoc.tu_hoc.test_regex;

public class TestTwo {
    public static int hihi(int budget, int[] keyboard, int[] usb) {
        int[] b = new int[20];
        int result = 0;
        int count = 0;
        int max = -1;
        for (int i = 0; i < keyboard.length; i++) {
            for (int j = 0; j < usb.length; j++) {
                if ( keyboard[i] + usb[j] <= budget ){
                    result = keyboard[i] + usb[j];
                    b[count] = result;
                    count++;
                }
            }
        }
        for (int k = 0; k< b.length;k++){
            if (b[k] > max){
                max = b[k];
            } else {
                if (b[k] == 0){
                    return -1;
                }
            }
        }
        return max;
    }


    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = 0;
        int sum = 0;
        for(int i = 0; i < keyboards.length; i ++){
            for(int j = 0; j < drives.length; j++){
                sum = keyboards[i] + drives[j];
                if(sum >= max && sum <= b){
                    max = sum;
                }
            }
        }
        if(max == 0){
            return -1;
        }
        return max;
    }

    public static void main(String[] args) {
        int budget = 20;
        int [] keyboard = {40,50,60};
        int [] usb = {5,8,12};
        System.out.println(hihi(budget,keyboard,usb));
    }
}
