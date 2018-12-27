package com.leyou.search.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ReflectUtils
 * @Description 反射工具类
 * @Author wq
 * @Date 2018/12/27 11:18
 * @Version 1.0.0
 */
public class ReflectUtils {

    private Logger logger = LoggerFactory.getLogger(ReflectUtils.class);
    private static String packageName = "com.leyou.search.pojo";

    public static void main(String[] args) {

        ReflectUtils reflectUtils = new ReflectUtils();
        String totalPath = reflectUtils.resovlePackagePath("com.leyou");
        System.out.println(totalPath);

        reflectUtils.parseClassName(totalPath, "com.leyou").forEach(System.out::println);
    }

    /**
     *
     * @param packagePath  字节码+包名(参数)的绝对路径
     * @param webPackage    包名(参数)
     * @return
     */
    public List<String> parseClassName(String packagePath, String webPackage) {
        List<String> array = new ArrayList<>();
        File root = new File(packagePath);
        resolveFile(root, webPackage, array);
        return array;
    }

    /**
     * @param root 字节码+包名(参数)的绝对路径=>File形式
     * @param webPackage 参数(com.leyou)
     * @param classNames   存放返回值的变量
     */
    private void resolveFile(File root, String webPackage, List<String> classNames) {
        if (!root.exists()){
            logger.error("包含包名的字节码的绝对路径不存在!");
            return;
        }
        //递归遍历该文件夹下面的所有文件
        File[] childs = root.listFiles();
        if (childs != null && childs.length > 0) {
            for (File child : childs) {
                if (child.isDirectory()) {
                    String parentPath = child.getParent();
                    String childPath = child.getAbsolutePath();
                    String temp = childPath.replace(parentPath, "");
                    temp = temp.replace("\\", "");
                    resolveFile(child, webPackage + "." + temp, classNames);
                } else {
                    String fileName = child.getName();
                    if (fileName.endsWith(".class")) {
                        String name = fileName.replace(".class", "");
                        String className = webPackage + "." + name;
                        classNames.add(className);
                    }
                }
            }
        }
    }

    /**
     * 返回字节码的绝对路径
     * @param webPackage 加载的包名成
     * @return
     */
    public String resovlePackagePath(String webPackage) {
        // 扫码所有的包并把其放入到访问关系和方法放入到内存中
        File f = new File(getClass().getResource("/").getPath());
        //得到类的绝对路径
        String totalPath = f.getAbsolutePath();
        logger.info("absolute path:{}", totalPath);
        String currentPackagePath = getClass().getPackage().getName().replace(".", "\\");
        logger.info("current package path:{}", currentPackagePath);
        //去除绝对路径中的当前包路径部分
        totalPath = totalPath.replace(currentPackagePath, "");
        //包名改为路径形式
        String packagePath = webPackage.replace(".", "\\");
        logger.info("parameter package absolute path:{}", packagePath);
        totalPath = totalPath + "\\" + packagePath;
        return totalPath;
    }




}
