package shuanfa;

import java.util.Date;

/**
        * 素数环
        * 将从1到n这n个整数围成一个圆环，若其中任意2个相邻的数字相加，结果均为素数，那么这个环就成为素数环。
        * 要求输出：从整数1开始。
        * 素数环，相邻两个相加是否为素数，数字范围（1~20）
        * 数组+和是否素数
        * 回溯，返回到上一个
        */
public class PrimeRingProblem02 {
    public static int NUMLENGTH=600;
    public static void main(String args[]){
        Date begin =new Date();
        int [] arr=new int[NUMLENGTH];
        arr[0]=1;//第一个数字只能为1
        int k=1;
        while(k>=1){//极小边界限制
            arr[k]=arr[k]+1;
            while(arr[k]<NUMLENGTH){//极大边界限制
                if(check(arr, k)==1)
                    break;//符合条件，跳出循环
                else
                    arr[k]=arr[k]+1;//叠加到下一位
            }
            if(arr[k]<=NUMLENGTH&&k==NUMLENGTH-1){//求解完毕，输出解
                for(int x:arr) {
                    System.out.print(x + " ");
                }
                Date end =new Date();
                System.out.println("耗时"+String.valueOf(end.getTime()-begin.getTime()));
                return ;
            }
            if(arr[k]<NUMLENGTH&&k<NUMLENGTH-1){//填写下一个位置
                k=k+1;
            }
            else{
                arr[k--]=0;//回溯 k--先做运算后加减
            }
        }
    }
    /**
     * 判断当前放进的数字是否符合条件
     * 1.是否与之前重复
     * 2.相邻之和是否素数
     * 3.第一个和最后一个相加是否为素数
     */
    public static int check(int[] arr,int k){
        int flag=0;
        for(int i=0;i<k;i++){//是否与之前重复
            if(arr[i]==arr[k])
                return 0;
        }
        flag=prime(arr[k-1]+arr[k]);//相邻之和是否素数
        if(flag==1&&k==NUMLENGTH-1){//k保证了为最后一个；第一个和最后一个相加是否为素数
            flag=prime(arr[0]+arr[k]);
        }
        return flag;

    }
    /*
     * 判断之和是否为素数
     */
    public static int prime(int sum){
        int n=(int)Math.sqrt(sum);
        for(int i=2;i<=n;i++){
            if(sum%i==0)
                return 0;
        }
        return 1;

    }
}
