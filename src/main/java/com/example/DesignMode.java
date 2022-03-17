package com.example;

import cn.hutool.core.bean.BeanUtil;
import java.util.Calendar;

/**
 * @className: DesignMode
 * @description: TODO 类描述
 * @author: lemdeng
 * @date: 2022/2/24
 **/
public class DesignMode {

    public static void main(String[] args) {
//        animal animaltest = new bird();
//        animaltest.action();

        USB usb = new MouseAdapter();

        usb.drive();
    }
}



interface animal{
    void action();
}

class bird implements animal{

    @Override
    public void action() {
        System.out.println("飞行");
    }
}

class snake implements animal{

    @Override
    public void action() {
        System.out.println("爬行");
    }
}

interface USB{
    void drive();
}

class Mouse{


    public void insert() {
        System.out.println("鼠标插入");
    }
}

class Keyborad{
    public void insert() {
        System.out.println("键盘插入");
    }
}

class MouseAdapter implements USB{

    private Mouse mouse;

    public MouseAdapter(){
        mouse = new Mouse();
    }

    @Override
    public void drive() {
        mouse.insert();
    }

}

class KeyboradAdapter implements USB{

    private Keyborad keyborad;

    public KeyboradAdapter(){
        keyborad = new Keyborad();
    }
    @Override
    public void drive() {
        keyborad.insert();
    }
}
