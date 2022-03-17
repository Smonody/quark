package com.example.aop;

import com.example.ano.TestAno;
import java.lang.reflect.Method;
import java.util.Arrays;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @className: TestAop
 * @description: TODO 类描述
 * @author: lemdeng
 * @date: 2022/3/8
 **/
@TestAno
@Interceptor
public class TestAop {
    Logger log = LoggerFactory.getLogger(getClass());


    @AroundInvoke
    public Object aroundMethod(InvocationContext invocationContext) {
        System.out.println("环绕通知测试");
        Object proceed = null;
        try {
             proceed = invocationContext.proceed();
            System.out.println("反射获取class");
            Class<?> aClass = proceed.getClass();
            Method[] methods = aClass.getDeclaredMethods();
            Arrays.stream(methods).forEach((method -> {
                System.out.print("方法名：" + method.getName() + "  对应参数：" );
                Arrays.stream(method.getParameterTypes()).
                        forEach((field) ->{
                            System.out.print(field);
                        });
                System.out.println();
            }));

        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕通知结束");
        return proceed;
    }
}
