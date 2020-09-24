package com.zh.proxy;

/**
 * @author Beloved
 * @date 2020/9/22 23:02
 *
 * 静态代理模式总结：
 *   真实对象和代理对象都要实现同一接口
 *   代理对象要代理真实角色
 * 好处：
 *   代理对象可以做很多真实对象做不到的事情
 *   真实对象专注做自己的事
 */
public class StaticProxy {

    public static void main(String[] args) {
//        WeddingCompany company = new WeddingCompany(new You());
//
//        company.HappyMarry();

        new Thread( ()-> System.out.println("你好")).start();

        new WeddingCompany(new You()).HappyMarry();
    }

}

// 功能接口
interface Marry{
    void HappyMarry();
}


// 真实角色
class You implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("开心的结婚");
    }
}

// 代理角色 婚庆公司
class WeddingCompany implements Marry{

    private Marry target;

    public WeddingCompany(Marry target){
        this.target = target;
    }

    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("结婚之后：收尾款");
    }

    private void before() {
        System.out.println("结婚之前：布置会场");
    }
}
