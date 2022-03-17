package com.example.design;

import javax.transaction.Synchronization;

/**
 * @className: Sigleton
 * @description: 单例模式
 * @author: lemdeng
 * @date: 2022/2/24
 **/
public class SingleTon {

    private SingleTon(){

    }

    private static class SingleTonHoler{
        private static SingleTon INSTANCE = new SingleTon();
    }

    public static SingleTon getInstance(){
        return SingleTonHoler.INSTANCE;
    }

}


class DCLSingleTon{
    public static DCLSingleTon INSTANCE;
    
    private DCLSingleTon(){
        
    }
    
    public static DCLSingleTon getInstance(){
        if(null == INSTANCE){
            synchronized (getInstance()){
                if(null == INSTANCE){
                    INSTANCE = new DCLSingleTon();
                }
            }
        }

        return INSTANCE;
    }
}
