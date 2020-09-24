package com.zh.syn;

/**
 * @author Beloved
 * @date 2020/9/24 8:21
 * 不安全线程模拟
 *  两个人同时去银行取同一个账户的钱
 */
public class UnsafeBank {

    public static void main(String[] args) {
        Account account = new Account(100, "公共账户");

        Drawing drawing1 = new Drawing(account, 50, "张三");
        Drawing drawing2 = new Drawing(account, 100, "李四");

        drawing1.start();
        drawing2.start();
    }
}

// 账户
class Account{
    int money; // 余额
    String name; // 卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 银行 模拟取钱
class Drawing extends Thread{

    // 账户
    Account account;
    // 取了多少钱
    int drawingMoney;
    // 手里的钱
    int nowMoney;

    public Drawing(Account account, int drawingMoney,String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    // 取钱
    @Override
    public void run() {

        // 锁定的对象就是变化的量，需要增删改的
        synchronized(account){
            // 判断有没有钱
            if (account.money - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName()+"--->钱不够，取不了");
                return;
            }

            // 模拟延时  sleep可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 卡内余额 = 余额 - 取得钱
            account.money = account.money - drawingMoney;

            // 手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name+"--->余额为："+account.money);

            System.out.println(this.getName()+"--->手里的钱："+nowMoney);
        }
    }
}
