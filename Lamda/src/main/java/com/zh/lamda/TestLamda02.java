package com.zh.lamda;

/**
 * @author Beloved
 * @date 2020/9/23 0:27
 */
public class TestLamda02 {

    public static void main(String[] args) {

        // Lamda简化
        ILove love = (String name)->{
            System.out.println("I Love " + name);
        };

        // 简化：去除参数类型
        love = (name)->{
            System.out.println("I Love " + name);
        };

        // 简化：去除括号
        love = name->{
            System.out.println("I Love " + name);
        };

        // 简化：去除花括号
        love = name-> System.out.println("I Love " + name);

        love.love("Java");

    }
}

interface ILove{
    void love(String name);
}

