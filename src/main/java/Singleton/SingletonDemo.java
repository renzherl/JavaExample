package Singleton;

/**
 * Created by mi on 2017/12/5.
 */
public class SingletonDemo{
    public static void main(String[] args){
        int c = SingletonStatic.getInstance().add(1,2);
        System.out.println("SingletonDemo c= " + c);
    }
}
