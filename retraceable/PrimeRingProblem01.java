package shuanfa;

import java.util.Date;

/**
 * 回溯算法练习
 * 将素数环问题修改为递归--效率慢
 * 符合条件：
 * 1.该数不能超出上限
 * 2.该数和前一位数相加符合素数
 * 3.该数如果为最后一个数和第一个数相加为素数
 * 4.判断该值是否被使用
 */
public class PrimeRingProblem01 {
    private static final int NUM = 600;
    private static int[] array = new int[NUM];//初始化数组

    static {
        array[0] = 1;//初始化值
    }

    public static void main(String[] args) {
        Date begin =new Date();
        tian(array, 1);
        Date end =new Date();
        System.out.println("耗时"+String.valueOf(end.getTime()-begin.getTime()));
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    /**
     * 通过递归填值
     * 回溯
     *
     * @return
     */
    private static void tian(int[] array, int k) {

        if (k < NUM && array[k] < NUM + 1) {
            for (int i = array[k] ; i <= NUM; i++) {
                if (booTJ(array, NUM-1)){//满足条件跳出循环
                    return;
                }
                array[k] = i;//填入k
                //判断是否符合条件
                if (booTJ(array, k)) {
                    //符合条件填入下一个数
                    tian(array, k + 1);
                } else {
                    array[k] = 0;//填入k
                }
            }
            //该值全部不符合条件回溯到上一个值等于0
            if (array[k] == 0) {
                return;
            }
        }
    }

    /**
     * 用于判断是否符合条件
     *
     * @param array
     * @param k
     * @return
     */
    private static boolean booTJ(int[] array, int k) {
        if (array[k]==0){//该值不为0
            return false;
        }
        for (int i = 0; i < array.length; i++) {//该值不能被使用
            if (k != i) {
                if (array[k] == array[i]) {
                    return false;
                }
            }
        }
        if (k < NUM) {//该数不能超出上限
            if (booPrime(array[k - 1], array[k])) {//该数和前一位数相加符合素数
                if (k == NUM - 1) {//该数如果为最后一个数和第一个数相加为素数
                    boolean b = booPrime(array[0], array[k]);
                    return b;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    private static boolean booPrime(int a, int b) {
        int c = a + b;
        int n = (int) Math.sqrt(c);
        for (int i = 2; i <= n; i++) {
            if (c % i == 0)
                return false;
        }
        return true;
    }
}
