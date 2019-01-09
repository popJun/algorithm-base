package shuanfa;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 斐波那契求素数
 * Created by Administrator on 2018\9\19 0019.
 */
public class FibonacciPrime {

    private static void countSuShu(int start, int end) {
        int [] array = new int[end-start+1];
        for (int i = 0; i < array.length ; i++) {
                array[i]=start+i;
        }
        if (start == 0) {
            System.out.println("开始值不能为0");
            return;
        }

        for (int i = 0; i <array.length; i++) {
            if (array[i] == 1) {
                array[i]=0;
                continue;
            }
            for (int j = 2; j <= Math.sqrt(array[i]); j++) {
                if (array[i] % j == 0) {//能除尽则不是素数
                    array[i]=0;
                    continue;
                }
            }
        }

        System.out.println("为素数的：");
        for (int i = 0; i < array.length ; i++) {
            if (array[i]!=0){
                System.out.print(array[i]+"  ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入开始值：");
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        System.out.println("请输入末尾值：");
        Scanner scannerV2 = new Scanner(System.in);
        int end = scannerV2.nextInt();
        countSuShu(start,end);
    }
}
