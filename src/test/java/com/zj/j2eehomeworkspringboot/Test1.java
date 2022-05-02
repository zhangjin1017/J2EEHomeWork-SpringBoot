package com.zj.j2eehomeworkspringboot;

public class Test1 {

    public static void main(String[] args) {

        System.out.println(nowTime());
    }
    static String nowTime(){
        //获取当前时间年月日时分秒
      return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());

    }
}
