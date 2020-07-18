package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射
 *      配合配置文件使用
 *      用class.txt代替
 *      知道两个键
 *          className
 *          methodName
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //原先
//        Student s = new Student();
//        s.love();
//        Teacher t = new Teacher();
//        t.love();
//        Worker w = new Worker();
//        w.love();
        //via reflection
        //load key-value data
        Properties prop = new Properties();
        FileReader fr = new FileReader("Reflection\\src\\test\\class.txt");
        prop.load(fr);
        fr.close();
        //get data
        String className = prop.getProperty("className");
        String methodName = prop.getProperty("methodName");

        //reflection
        Class c = Class.forName("test." + className);
        Constructor constructor = c.getConstructor();
        Object o = constructor.newInstance();
        Method m = c.getDeclaredMethod(methodName);
        m.setAccessible(true);
        m.invoke(o);

    }
}
