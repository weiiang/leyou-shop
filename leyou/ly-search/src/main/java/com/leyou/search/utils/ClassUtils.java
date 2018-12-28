package com.leyou.search.utils;

import com.leyou.search.vo.ClassFileVO;

import java.lang.reflect.AnnotatedType;
import java.util.List;

/**
 * 解析类的信息
 * 字段名称  类型  字段上的注解
 * 方法名称   返回值  方法上的注解
 */
public class ClassUtils {

    public static void main(String[] args) throws ClassNotFoundException {
        ReflectUtils reflectUtils = new ReflectUtils();
        String totalPath = reflectUtils.resovlePackagePath("com.leyou");
        System.out.println(totalPath);
        List<ClassFileVO> classFileVOList = reflectUtils.parseClassName(totalPath, "com.leyou");

        ClassUtils classUtils = new ClassUtils();
        List<ClassFileVO> classFileVOList1 = classUtils.getClassDetails(classFileVOList);
    }


    public List<ClassFileVO> getClassDetails(List<ClassFileVO> classFileVOList) throws ClassNotFoundException {

        for (ClassFileVO cl: classFileVOList) {
            String qualifiedName = cl.qualifiedName;
            Class<?> aClass = Class.forName(qualifiedName);
            System.out.println(aClass.getSimpleName());
            AnnotatedType[] annotatedInterfaces = aClass.getAnnotatedInterfaces();

            for (int i = 0; i < annotatedInterfaces.length; i++) {
                System.out.println(annotatedInterfaces[i].getDeclaredAnnotations());
                System.out.println(annotatedInterfaces[i].getType());
            }
            System.out.println();
        }
        return classFileVOList;
    }
}
