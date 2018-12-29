package com.leyou.search.utils;

import com.leyou.search.vo.ClassFileVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ReflectUtils
 * @Description 反射工具类
 * @Author wq
 * @Date 2018/12/27 11:18
 * @Version 1.0.0
 */
public class ReflectUtils {
    /**
     * 参数： 包名/类名
     * 列表：
     * 一级：实体类信息  操作：已创建索引=》删除索引     未创建索引=>创建索引
     * 二级：每个实体类的字段信息以及上面的注解信息
     */

    private Logger logger = LoggerFactory.getLogger(ReflectUtils.class);
    private  String packageName = "com.leyou.search.pojo";

    public static void main(String[] args) throws ClassNotFoundException {
        ReflectUtils reflectUtils = new ReflectUtils();
        String totalPath = reflectUtils.resovlePackagePath("com.leyou");
        System.out.println(totalPath);
//        reflectUtils.parseClassName(totalPath, "com.leyou").forEach(System.out::println);

        ClassUtils.getClassDetails(reflectUtils.parseClassName(totalPath, "com.leyou"));
    }

    /**
     * @param packagePath 字节码+包名(参数)的绝对路径
     * @param webPackage  包名(参数)
     * @return
     */
    public List<ClassFileVO> parseClassName(String packagePath, String webPackage) {
        //调用一次产生一个list存放包名列表，避免在全局变量引发逐次增加重复数据的情况
        List<ClassFileVO> array = new ArrayList<>();
        File root = new File(packagePath);
        resolveFile(root, webPackage, array);
        return array;
    }

    /**
     * @param root       字节码+包名(参数)的绝对路径=>File形式
     * @param webPackage 参数(com.leyou)
     * @param classNames 存放返回值的变量
     */
    private void resolveFile(File root, String webPackage, List<ClassFileVO> classNames) {
        if (!root.exists()) {
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
                        long length = child.length();
                        long time = child.lastModified();
                        ClassFileVO vo = new ClassFileVO(new Date(time), length, child.getName().replaceAll(".class", ""), className, child.getAbsolutePath());
                        classNames.add(vo);
                    }
                }
            }
        }
    }

    /**
     * 返回字节码的绝对路径
     *
     * @param webPackage 加载的包名成
     * @return
     */
    public String resovlePackagePath(String webPackage) {
        if (!StringUtils.isNotBlank(webPackage)){
            webPackage = this.packageName;
        }
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
