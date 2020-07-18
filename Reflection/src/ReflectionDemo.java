/**
 * 反射：就是通过class文件对象去操作该文件中的成员变量 方法 构造方法
 * 1、先得到class文件，也就是Class类的对象
 * Class类 ：
 *      成员变量    Field
 *      构造方法    Constructor
 *      成员方法    Method
 *
 * 获取class文件对象的方法
 * A、Object getClass() 方法
 * B、数据类型的静态属性class
 * C、Class类中的静态方法 public static Class forName(String className)
 *
 * 注意：
 *      1、自己玩
 *          第一种、第二种
 *      2、开发 用第三种
 *          因为第三种传递的是字符串，我们可以把这样的字符串配置到配置文件中
 */
public class ReflectionDemo {


    public static void main(String[] args) throws ClassNotFoundException {
        /*--------方式1--------*/
        Person p = new Person();
        Class c = p.getClass();

        Person p2 = new Person();
        Class c2 = p2.getClass();
        System.out.println(p == p2); //false
        System.out.println(c == c2); //true
        /*--------------------*/

        /*--------方式2--------*/
        Class c3 = Person.class;
        // int.class
        //String.class
        System.out.println(c == c3); //true
        /*--------------------*/

        /*--------方式3--------*/
        //ClassNotFound
        Class c4 = Class.forName("Person");
        System.out.println(c == c4); //true
        /*--------------------*/
    }

}
