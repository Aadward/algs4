package javaTest.reflectProxy;

/**
 * Created by syh20 on 2016/8/6.
 */
public class TargetImpl implements TargetInterface {
    @Override
    public void targetMethod1(int num) {
        System.out.println("调用方法1，num = " + num);
    }

    @Override
    public void targetMethod2(int num) {
        System.out.println("调用方法2，num = " + num);
    }
}
