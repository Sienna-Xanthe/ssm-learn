package cn.library.admin;

import cn.library.jdbctemplate.adminjdbc;
import cn.library.jdbctemplate.studentjdbc;

import java.util.Scanner;

public class Ad_view {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        adminjdbc admin = new adminjdbc();
        studentjdbc stuuu = new studentjdbc();

        while (true){
            System.out.println("\n--------登录(输入1)--------\n--------退出(输入2)--------");
            System.out.print("请输入：");
            String aa = sc.next();
            if(aa.equals("1")){
                System.out.println("----------登录---------");
                System.out.print("请输入用户名：");
                String user_name = sc.next();
                System.out.print("请输入密码：");
                String secret = sc.next();
                Long count = admin.addenglu(user_name,secret);
                if(count == 1)
                {
                    System.out.println("*********登录成功！*********");
                    String chose = "0";

                    while (! chose.equals("5")) {
                        System.out.println("--------------------------------------");
                        System.out.println("请选择以下操作：");
                        System.out.println("        1.添加图书");
                        System.out.println("        2.下架图书");
                        System.out.println("        3.查看借阅历史");
                        System.out.println("        4.查询图书");
                        System.out.println("        5.退出登录");
                        System.out.println("--------------------------------------");
                        System.out.print("请输入的你的操作：");
                        chose = sc.next();
                        if(chose.equals("1")){
                            System.out.println("-----------------添加图书------------------");
                            System.out.println("书名：");
                            String bk_name = sc.next();
                            System.out.println("作者：");
                            String author = sc.next();
                            System.out.println("出版社：");
                            String publish = sc.next();
                            int cou = admin.tianjiatushu(bk_name,author,publish);
                            if(cou == 1)
                            {
                                System.out.println("添加成功！");
                            }
                            else{
                                System.out.println("添加失败！");
                            }
                        }
                        else if(chose.equals("2")){
                            System.out.println("-----------------下架图书-----------------");
                            System.out.print("请输入你要下架的书籍id：");
                            String id = sc.next();
                            int cou1 = admin.xiajiatushu(id);
                            if(cou1 == 1){
                                System.out.println("下架成功！！");
                            }
                            else{
                                System.out.println("下架失败！！");
                            }

                        }
                        else if(chose.equals("3")){
                            System.out.println("-----------------查看借阅历史-----------------");
                            System.out.println("        1.查看个人借阅历史");
                            System.out.println("        2.查看所有借阅历史");
                            System.out.print("请输入的你的操作：");
                            String asd = sc.next();
                            if(asd.equals("1")){
                                System.out.print("请输入你要查询id：");
                                String id = sc.next();
                                System.out.println("-------------------Id查询-----------------");
                                admin.gerenchaxun(id);
                                System.out.println("------------------END-------------------");
                            }
                            else if(asd.equals("2")){
                                System.out.println("-----------------全部查询-----------------");
                                admin.jiluquanbuchaxun();
                                System.out.println("------------------END-------------------");
                            }
                            else{
                                System.out.println("您的输入非法！");
                            }

                        }
                        else if(chose.equals("4")){
                            System.out.println("-----------------查询图书-----------------");
                            stuuu.quanbuchaxun();
                            System.out.println("------------------END-------------------");
                        }
                        else if(chose.equals("5")){
                            break;
                        }
                        else{
                            System.out.println("您的输入非法！！");
                        }
                    }
                }
                else{
                    System.out.println("登录失败！！您的输入的用户名或密码错误！\n");
                }
            }
            else if(aa.equals("2"))
            {
                break;
            }
            else
            {
                System.out.println("您的输入非法！！");
            }

        }


    }
}
