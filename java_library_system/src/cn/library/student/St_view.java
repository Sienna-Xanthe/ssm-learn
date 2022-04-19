package cn.library.student;

import cn.library.jdbctemplate.studentjdbc;

import java.util.List;
import java.util.Scanner;

public class St_view {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        studentjdbc stu = new studentjdbc();

        while (true){
            System.out.println("\n-------登录(输入1)-------\n-------注册(输入2)-------\n-------退出(输入3)-------");
            System.out.print("请输入：");
            String aa = sc.next();
            if(aa.equals("1")){
                System.out.println("----------------登录----------------");
                System.out.println("请输入你的学号：");
                String number = sc.next();
                System.out.println("请输入你的手机号：");
                String phone = sc.next();
                Long count = stu.denglu(number,phone);
                if(count == 1)
                {
                    System.out.println("登录成功！");
                    List<Student> list = stu.stuid(number);
                    Student student1 = list.get(0);
                    System.out.println("学生信息为：" + student1.toString());
                    String chose = "0";

                    while (! chose.equals("5")){
                        System.out.println("--------------------------------------");
                        System.out.println("请选择以下操作：");
                        System.out.println("        1.借书");
                        System.out.println("        2.还书");
                        System.out.println("        3.查看个人借阅历史");
                        System.out.println("        4.查询图书");
                        System.out.println("        5.退出登录");
                        System.out.println("--------------------------------------");
                        System.out.print("请输入的你的操作：");
                        chose = sc.next();
                        if(chose.equals("1")){
                            System.out.println("#############################");
                            System.out.print("请输入你要借书的书号：");
                            String bk_id = sc.next();
                            int count1 = stu.jieshu(bk_id ,student1.getId());
                            if(count1 == 1)
                            {
                                System.out.println("########  借书成功！  ########");
                            }
                            else{
                                System.out.println("########  借书失败！  ########");
                            }
                        }
                        else if(chose.equals("2")){
                            System.out.println("#############################");
                            System.out.print("请输入你要还书的书号：");
                            String bk_id = sc.next();
                            int count1 = stu.huanshu(bk_id ,student1.getId());
                            if(count1 == 1)
                            {
                                System.out.println("########  还书成功！  ########");
                            }
                            else{
                                System.out.println("########  还书失败！  ########");
                            }
                        }
                        else if(chose.equals("3")){
                            System.out.println("#############################");
                            System.out.println("************个人借阅历史************");
                            stu.chakanjieyue(student1.getId());
                            System.out.println("***************END****************");
                        }
                        else if(chose.equals("4")){
                            while (true){
                                System.out.println("###############查询图书###############");
                                System.out.println("            1.全部查询");
                                System.out.println("            2.书号id查询");
                                System.out.println("            3.书名查询");
                                System.out.println("            4.作者查询");
                                System.out.println("            5.退出查询");
                                System.out.println("####################################");
                                System.out.print("请选择您的操作：");
                                String cho = sc.next();
                                if(cho.equals("1")){
                                    System.out.println("***************全部查询****************");
                                    stu.quanbuchaxun();
                                    System.out.println("**************************************");
                                }
                                else if(cho.equals("2")){
                                    System.out.println("*************书号id查询*****************");
                                    System.out.print("请输入您要查询的书号id：");
                                    String bk_id = sc.next();
                                    stu.idchaxun(bk_id);
                                    System.out.println("**************************************");
                                }
                                else if(cho.equals("3")){
                                    System.out.println("***************书名查询*****************");
                                    System.out.print("请输入您要查询的书名：");
                                    String bk_name = sc.next();
                                    stu.bknamechaxun(bk_name);
                                    System.out.println("***************************************");

                                }
                                else if(cho.equals("4")){
                                    System.out.println("***************作者查询*****************");
                                    System.out.print("请输入您要查询的作者：");
                                    String author = sc.next();
                                    stu.authorchaxun(author);
                                    System.out.println("***************************************");
                                }
                                else if(cho.equals("5")){
                                    break;
                                }
                                else{
                                    System.out.println("您的输入非法！！ *请重新输入!");
                                }
                            }

                        }
                        else if(chose.equals("5")){
                            break;
                        }
                        else{
                            System.out.println("您的输入非法！！！\n\n");
                        }
                    }

                }
                else{
                    System.out.println("登录失败！  学号或手机号错误！");
                }
            }
            else if(aa.equals("2")){
                System.out.println("--------------注册--------------");
                System.out.println("请输入你的姓名：");
                String name = sc.next();
                System.out.println("请输入你的学号：");
                String number = sc.next();
                System.out.println("请输入你的手机号：");
                String phone = sc.next();
                int count = stu.zhuce(name,number,phone);
                if(count == 1)
                {
                    System.out.println("注册成功！");
                }
                else{
                    System.out.println("注册失败！");
                }

            }
            else if(aa.equals("3"))
            {
                break;
            }
            else{
                System.out.println("您的输入非法！！");
            }
        }





    }
}
