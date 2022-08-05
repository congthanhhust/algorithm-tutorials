package algorithm;

public class Pow {
    static long count1 = 0;
    static long count2 = 0;
    static long count3 = 0;

    public static long pow1(int a, int b) {
        count1++;
        if (b == 1)
            return a;

        return a * pow1(a, b - 1);
    }

    public static long pow2(int a, int b) {
        count2++;
        if (b == 1)
            return a;

        int mid = b / 2;
        boolean isEven = (b % 2 == 0);
        if (isEven) {
            return pow2(a, mid) * pow2(a, mid);
        } else {
            return a * pow2(a, mid) * pow2(a, mid);
        }
    }

    public static long pow3(int a, int b) {
        count3++;
        if (b == 1) {
            return a;
        }

        int mid = b / 2;
        boolean isEven = (b % 2 == 0);
        long result = pow3(a, mid);
        if (isEven) {
            return result * result;
        } else {
            return a * result * result;
        }
    }

    public static void main(String[] args) {
        int n = 100000;
        int b = 5000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++){
            pow1(3, b);
        }
        System.out.println("pow1 count = " + count1/n);
        System.out.println("pow1 runningTime = " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++){
            pow2(3, b);
        }
        System.out.println("pow2 count = " + count2/n);
        System.out.println("pow2 runningTime = " + (System.currentTimeMillis() - start) + " ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < n; i++){
            pow3(3, b);
        }
        System.out.println("pow3 count = " + count3/n);
        System.out.println("pow3 runningTime = " + (System.currentTimeMillis() - start) + " ms");
    }
}
