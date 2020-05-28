package ClassLoader;

/**
 * @author raoli <raoli@kuaishou.com>
 * Created on 2020-05-27
 */
public class ClassLoaderExample {
    public static void main(String[] args){
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        ClassLoader cl = ClassLoaderExample.class.getClassLoader();
        System.out.println("ClassLoaderExample class loader is: " + cl.toString());

//        cl = Integer.class.getClassLoader();
//        System.out.println("Integer class loader is: " + cl.toString());

    }

}
