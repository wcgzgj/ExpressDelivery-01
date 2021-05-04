package top.faroz.util;

import java.io.*;

/**
 * @ClassName FIleUtil
 * @Description 文件工具
 * @Author FARO_Z
 * @Date 2021/5/4 下午7:26
 * @Version 1.0
 **/
public class FileUtil {

    /**
     * 读取被序列化的内容
     * @param fileName
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object readObject(String fileName) throws IOException, ClassNotFoundException {
        fileName+=".txt";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        return o;
    }

    /**
     * 序列化对象，存入指定文件
     * @param obj
     * @param fileName
     * @throws IOException
     */
    public static void writeObject(Object obj,String fileName) throws IOException {
        fileName+=".txt";
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream fos = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);
    }
}
