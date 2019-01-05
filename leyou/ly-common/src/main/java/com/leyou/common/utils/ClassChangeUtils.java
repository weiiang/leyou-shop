package com.leyou.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;
import java.util.Map.Entry;

/**
 * @ClassName ClassChangeUtils
 * @Description 类转换工具类
 * Map转为Object <=> Object 转为 Map
 * Map转为JSON <=>   JSON转为 Map
 * Object转为JSON <=> JSON 转 Object
 * @Author wq
 * @Date 2019/1/5 8:49
 * @Version 1.0.0
 */
public class ClassChangeUtils {

    private static Logger logger = LoggerFactory.getLogger(ClassChangeUtils.class);

//    private final ClassChangeUtils<T> classChangeUtils = new ClassChangeUtils<T>();


    public static void main(String[] args) throws IllegalAccessException {
        User ucl = new User(1, "张三", new Date());
        User uc2 = new User(2, "张三1", new Date());

        List l = new ArrayList<>();
        l.add(uc2);
        l.add(ucl);

        List<Map> mList = listToMap(l);
        System.out.println(mList);
        System.out.println(listMapToListObject(mList, new User()));

        Map map = objectToMap(ucl);
        System.out.println(mapToObject(map, new User()));

    }


    /**
     * Map 装换为JSON
     * @param map
     * @return
     */
    public static String mapToJson(Map map){
        String result = "";

        return result;
    }

    /**
     * map 转为 Object
     *
     * @param map
     * @return
     */
    public static Object mapToObject(Map<Object, Object> map, Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            for (Entry<Object, Object> entry : map.entrySet()) {
                Object k = entry.getKey();
                Object v = entry.getValue();
                if (fields[i].getName().equals(k)) {
                    try {
                        fields[i].set(obj, v);
                        break;
                    } catch (IllegalAccessException e) {
                        logger.error("私有属性不可见!");
                        e.printStackTrace();
                    }
                }
            }
        }
        return obj;
    }

    /**
     * Map集合转换为指定的Map对象
     *
     * @param mList
     * @param obj
     * @return
     */
    public static List<Object> listMapToListObject(List<Map> mList, Object obj) {
        List<Object> returnList = new ArrayList<>();
        mList.forEach(map -> {
            Constructor<?> constructor = null;
            try {
                constructor = obj.getClass().getConstructor();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
            Object o = null;
            try {
                o = constructor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            returnList.add(mapToObject(map, o));
        });
        return returnList;
    }

    /**
     * 单个对象转为Map
     *
     * @param obj
     * @return
     */
    public static Map objectToMap(Object obj) {
        Class cl = obj.getClass();
        Field[] objFields = cl.getDeclaredFields();
        Map map = new HashMap(5);
        for (int i = 0; i < objFields.length; i++) {
            objFields[i].setAccessible(true);
            try {
                map.put(objFields[i].getName(), objFields[i].get(obj));
            } catch (IllegalAccessException e) {
                logger.error("私有属性不可见");
                e.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 列表对象转为Map
     * 当List的size很大的时候可以开启多线程
     * 自己写一个线程池
     * 平均分成多少分,就从线程池拿多少个线程并行处理
     *
     * @param objList
     * @return
     */
    public static List<Map> listToMap(List<Object> objList) {
        List<Map> returnList = new ArrayList<>();
        objList.forEach(obj -> {
            returnList.add(objectToMap(obj));
        });
        return returnList;
    }
}
