package shuanfa;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 八皇后问题
 * 回溯算法的基本思想是：从一条路往前走，能进则进，不能进则退回来，换一条路再试。八皇后问题就是回溯算法的典型
 * Created by Administrator on 2018\9\29 0029.
 */
public class QueenProblem01 {
    private static final int n = 14;//用于动态解决N皇后问题
    private static int count = 0;

    public static void main(String[] args) {
        Date begin =new Date();
        int[][] arrayInt= new int[n][n];
        eightQue(arrayInt,0);
        Date end =new Date();
        System.out.println("耗时"+String.valueOf(end.getTime()-begin.getTime())+"结果"+count);
    }
    private static void eightQue(int arrayInt[][],int row) {//计算行数
        if (row == n) {//边界进行输出
            count++;
            return;
        }
        int[][] arrayIntClone = arrayInt.clone();
        for (int i = 0; i <n ; i++) {//列数
            for (int j = 0; j <n ; j++) {
                arrayIntClone[row][j]=0; //清空当前行数
            }
            arrayIntClone[row][i]=1;//摆放位置
            if (isOk(arrayIntClone,row,i)){//约束函数
                eightQue(arrayIntClone,row+1);//递归跳出循环后会到上一层循环
            }
        }
    }

    private static  boolean isOk(int arrayInt[][],int row,int col){
        //判断中上、左上、右上是否安全
        int step=1;
        while(row-step>=0){
            if(arrayInt[row-step][col]==1)                //中上
                return false;
            if(col-step>=0 && arrayInt[row-step][col-step]==1)        //左上
                return false;
            if(col+step<n && arrayInt[row-step][col+step]==1)        //右上
                return false;

            step++;
        }
        return true;
    }

}

