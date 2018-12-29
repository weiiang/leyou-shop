package com.leyou.search.utils;

import com.leyou.search.vo.ClassFileVO;
import com.leyou.search.vo.FileldVO;
import com.leyou.search.vo.MethodVO;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 解析类的信息
 * 字段名称  类型  字段上的注解
 * 方法名称   返回值  方法上的注解
 *
 * @author admin
 */
public class ClassUtils {

    public static List<ClassFileVO> getClassDetails(List<ClassFileVO> classFileVOList) throws ClassNotFoundException {
        for (ClassFileVO cl : classFileVOList) {
            String qualifiedName = cl.qualifiedName;
            Class<?> aClass = Class.forName(qualifiedName);
            //-------------------------------------------------------------------字段处理-----------------------------------------------------------------------------
            Field[] declaredFields = aClass.getDeclaredFields();
            List<FileldVO> fileldVOList = new ArrayList<>();
            for (Field field : declaredFields) {
                FileldVO fVo = new FileldVO();
                fVo.setFiledName(field.getName());
                fVo.setType(field.getGenericType().getTypeName());
                Annotation[] annotations = field.getAnnotations();
                List<String> annoList = new ArrayList<>();
                Arrays.asList(annotations).forEach(a -> {
                    annoList.add(a.annotationType().getName());
                });
                fVo.setAnnotationList(annoList);
                fileldVOList.add(fVo);
            }
            cl.setFiledList(fileldVOList);

            //-------------------------------------------------------------------方法处理-------------------------------------------------------------------------
            List<MethodVO> methodVOList = new ArrayList<>();
            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method m : declaredMethods) {
                MethodVO methodVO = new MethodVO();
                List<String> annoList = new ArrayList<>();
                List<Annotation> annotations = Arrays.asList(m.getAnnotations());
                annotations.forEach(a -> {
                    annoList.add(a.annotationType().getName());
                });
                methodVO.setMethodName(m.getName());
                methodVO.setReturnType(m.getGenericReturnType().getTypeName());

                //-------------------------------------------------------------------方法参数处理-------------------------------------------------------------------------
                Type[] genericParameterTypes = m.getGenericParameterTypes();
                System.out.println("genericParameterTypes:"+genericParameterTypes);
                Parameter[] parameters = m.getParameters();
                for (Parameter p: parameters) {
                    System.out.println( p.getName());
                }
                System.out.println("parameters:"+parameters);
                TypeVariable<Method>[] typeParameters = m.getTypeParameters();
                for (TypeVariable type: typeParameters) {
                    System.out.println(type.getName());
                }
                System.out.println("typeParameters:"+typeParameters);

                methodVOList.add(methodVO);
            }
            cl.setMethodList(methodVOList);

            //--------------------------------------------------------------------获取所有类上注解------------------------------------------------------------------------
            Annotation[] annotations = aClass.getAnnotations();
            //给类上的注解赋值
            List<String> annoList = new ArrayList<>();
            //遍历类上的注解,看是否含有Document注解,是否能创建索引
            for (Annotation anno : annotations) {
                annoList.add(anno.annotationType().getName());
                if (anno.annotationType().getName().equals(ConstUntils.INDEX_ANNOTAON_NAME)) {
                    cl.canCreateIndex = true;
                }
            }
            cl.setAnnotationList(annoList);
        }
        return classFileVOList;
    }
}
