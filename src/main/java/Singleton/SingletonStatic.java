package Singleton;

/**
 * Created by mi on 2017/12/5.
 */
public class SingletonStatic {
    private static SingletonStatic instance = new SingletonStatic();
    private SingletonStatic(){

    }
    public static SingletonStatic getInstance(){
        return instance;
    }

    public int add(int a, int b){
        return a+b;
    }
}
