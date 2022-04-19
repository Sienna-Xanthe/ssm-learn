package com.kuang.lambda;

public class TestLambda2 {

    public static void main(String[] args) {

        //1.lambda表示简化
        ILove love = (int a)->{
            System.out.println("i love you-->" + a);
        };

        //简化1.参数类型
        love = (a)->{
            System.out.println("i love you-->" + a);
        };
        //简化2.简化括号（前提是参数只有一个）
        love = a->{
            System.out.println("i love you-->" + a);
        };
        //简化3.去掉花括号(前提是代码只有一行)
        love = a->
            System.out.println("i love you-->" + a);
        //总结：
            //lambda表达式只能有一行代码的情况下才能简化成为一行，如果有多行，那么就用代码块包裹
            //前提是接口为函数式接口
        //多个参数也是可以去掉参数类型，要去就都去掉，必须加上括号

        love.love(2);
    }
}

interface ILove{
    void love(int a);
}
