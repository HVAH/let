package com.vah.let.designPattern.singleton;

/**
 * @Description 单例模式  双层校验
 * @Author Jiang
 * @Date 2021/9/2 4:25 下午
 **/
public class DoubleValid {
    private volatile static DoubleValid instance;

    private DoubleValid(){};

    public static DoubleValid getDoubleValid() {
        if (instance == null) {
            synchronized (DoubleValid.class) {
                if (instance == null) {
                    instance = new DoubleValid();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        DoubleValid.getDoubleValid();
    }
}
