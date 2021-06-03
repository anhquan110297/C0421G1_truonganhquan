package _02_loop.bai_tap;

public class ShowPrimesLessThan100 {
    public static void main(String[] args) {
        int run = 2;
        int countPrime = 0;
        while (true) {
            int count = 0;
            for (int i = 1; i <= run; i++) {
                if (run % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(run);
                countPrime++;
            }
            if (countPrime == 100) {
                break;
            }
            run++;
        }
    }
}
