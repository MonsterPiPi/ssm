package com.example.util;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User : 51103942@qq.com
 * Date : 2018/1/5
 * Time : 14:02
 * Talk is cheap. Show me the code.
 */
public class FileUtil {

    final static String directory="src/main/webapp/WEB-INF/statics/blog/";
    public static void main(String[] args) {
       saveBlog("test","test the save blog");

    }

    public  static  void saveBlog(String blogName,String blogText){
        //注释掉的为方法一
    /*File file=new File(directory,filename);
    if (file.exists()) {
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
    }else {
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }*/
        //此为方法二：
        File file=new File(directory);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2=new File(directory,blogName+".txt");
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        //向指定文件中写入文字
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(directory+blogName+".txt");
            //使用缓冲区比不使用缓冲区效果更好，因为每趟磁盘操作都比内存操作要花费更多时间。
            //通过BufferedWriter和FileWriter的连接，BufferedWriter可以暂存一堆数据，然后到满时再实际写入磁盘
            //这样就可以减少对磁盘操作的次数。如果想要强制把缓冲区立即写入,只要调用writer.flush();这个方法就可以要求缓冲区马上把内容写下去
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(blogText);
            bufferedWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
