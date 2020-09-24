package com.zh.lamda;

/**
 * @author Beloved
 * @date 2020/9/23 0:15
 */
public class TestLamda01 {

    // 3.静态内部类
    static class Like2 implements ILike{

        @Override
        public void lamda() {
            System.out.println("i like lamda--->2");
        }
    }

    public static void main(String[] args) {

        ILike like = new Like();
        like.lamda();

        like = new Like2();
        like.lamda();

        // 4.局部内部类
        class Like3 implements ILike{

            @Override
            public void lamda() {
                System.out.println("i like lamda--->3");
            }
        }
        like = new Like3();
        like.lamda();

        // 5.匿名内部类。 没有类名,必须借助接口或者父类
        like = new ILike() {
            @Override
            public void lamda() {
                System.out.println("i like lamda--->4");
            }
        };
        like.lamda();

        // 6.Lamda简化
        like = ()-> {
            System.out.println("i like lamda--->5");
        };
        like.lamda();
    }

}

// 1.定义一个函数式接口
interface ILike{
    void lamda();
}

// 2.实现类
class Like implements ILike{

    @Override
    public void lamda() {
        System.out.println("i like lamda--->1");
    }
}
