package com.warren.util;

//测试finally什么时候执行
public class Test {
    public static void main(String[] args) {
        System.out.println(test());
    }

     public static String test() {
        try {
                int a = 1/0;
                System.out.println("try block");
//                 return "666";      //如果是返回一个值，则先执行finally
                return test1();  //如果是返回一个方法，则先执行方法，再执行finally
             } catch (Exception ex) {
                System.out.println("catch block");
//                return test1();
                return "catch";
            }finally {
                 System.out.println("finally block");
//                  return "finally";   //finally里的返回值会替换掉try或者catch的返回值
             }
     }
     public static String test1() {
         System.out.println("return statement");
         return "after return";
     }

     //什么时候不会执行finally？
     //在try之前程序出错，或者在任何地方执行finally之前执行了退出程序System.exit(0);
}
