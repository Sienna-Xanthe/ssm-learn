package com.kuang.syn;

//不安全的买票
//线程不安全，有负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station,"我").start();
        new Thread(station,"你").start();
        new Thread(station,"黄牛党").start();

    }
}

class BuyTicket implements Runnable{

    //票
    private int ticketNums = 10;
    boolean flag = true;//外部停止方式

    @Override
    public void run() {
        //买票
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //synchronized线程同步方法
    private synchronized void buy() throws InterruptedException {
        //判断是否有票
        if(ticketNums <= 0){
            flag = false;
            return;
        }
        Thread.sleep(100);

        //买票
        System.out.println(Thread.currentThread().getName() + "拿到了" + ticketNums--);
    }


}
