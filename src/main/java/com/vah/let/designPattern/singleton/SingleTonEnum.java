package com.vah.let.designPattern.singleton;

/**
 * @Description 单例模式 枚举实现
 * @Author Jiang
 * @Date 2021/9/2 4:22 下午
 **/
public enum SingleTonEnum {
    INSTANCE;

    public void add() {

    }

    public static void main(String[] args) {
        SingleTonEnum.INSTANCE.add();
    }
}
