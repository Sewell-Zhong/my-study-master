package com;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @author : Mr-Z
 * @date : 2020/11/16 21:36
 */
public class DemoTest {

    @Test
    public void test() throws UnsupportedEncodingException {
//        Integer a = new Integer(3);
//        Integer b = 3; // 将3自动装箱成Integer类型
//        int c = 3;
//        int e = 3;
//        Integer d = 3;
//        System.out.println(a == b); // false 两个引用没有引用同一对象
//        System.out.println(a == c); // true a自动拆箱成int类型再和c比较
//        System.out.println(b == d);
//        ArrayList<String> l =new ArrayList <>();
//        System.out.println(l.toArray().getClass());
//        String[] original = new String[]{};
//        Integer[] original2 = new Integer[]{};
//        System.out.println(Arrays.copyOf(original, 1, Integer[].class).getClass());
//        System.out.println(Arrays.asList(original2).getClass());

//        int a=1;
//        System.out.println((~a)+1);
//        Class cls = HashMap.class;
//        Type[] genericInterfaces = cls.getGenericInterfaces();
//        for (Type genericInterface : genericInterfaces) {
//            System.out.println(genericInterface);
//        }
        System.out.println(0x7fffffff);
        System.out.println((int)Math.pow(2,30));
    }

    class Test22 implements Comparable<String>{

        @Override
        public int compareTo(String o) {
//            ConcurrentHashMap
//            ArrayBlockingQueue
//            LockSupport.park()
            return 0;
        }
    }
}
