package shuanfa;

import java.util.Date;

/**
 * 将八皇后问题改为非递归的方法
 * <p>
 * 条件成立方法
 * 1.左上 上 右上
 * 2.
 */
public class QueenProblem02 {
    private static final int quePlace = 16;
    private static int[] array = new int[quePlace];
    private static int zplace = 1;
    private static int count = 0;

    static {
        array[0] = 1;//初始化array
    }

    public static void main(String[] args) {
        Date begin = new Date();
        place();
        Date end = new Date();
        System.out.println("耗时" + String.valueOf(end.getTime() - begin.getTime()) + "结果" + count);
    }

    private static void place() {
        while (zplace >= 0) {//最低边界--皇后循环列走
            if (zplace == 0 && array[zplace] > quePlace) {//得出全部可能
                break;
            }
            if (array[zplace] < quePlace) {
                for (int i = array[zplace] + 1; i <= quePlace; i++) {//皇后循环行走
                    array[zplace] = i;
                    if (judgePlace(array, zplace)) {
                        zplace++;
                        break;
                    }
                }
            } else {//没有符合条件
                array[zplace] = 0;//回溯
                zplace = zplace - 1;
            }
            if (zplace >= quePlace) {//超出边界输出
               /* for (int i = 0; i < array.length; i++) {
                    System.out.print(array[i] + " ");
                    if (i==array.length-1){
                        System.out.println("");
                    }
                }*/
                count++;
                array[zplace - 1] = array[zplace - 1] + 1;//回溯
                zplace = zplace - 1;
            }
        }

    }

    /**
     * 判断该位置是否符合条件
     * 1.place不能超过边界
     * 2.左上上右上都不能有值
     *
     * @param array
     * @return
     */
    private static boolean judgePlace(int[] array, int zplace) {
        boolean flag = true;
        if (array[zplace] > quePlace) {
            return false;
        }
        for (int i = 0; i < zplace; i++) {
            if ((array[zplace] == array[i])) {//上方不能相同
                return false;
            }
            if (array[zplace] - array[i] == zplace - i) {//左上
                return false;
            }
            if (array[i] - array[zplace] == zplace - i) {//右上
                return false;
            }
        }
        return flag;
    }
}
