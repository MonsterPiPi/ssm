package com.example.util;

import org.junit.Test;

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

    @Test
    public void TestSaveBlog() throws IOException {
       //saveBlog("test","test the save blog");
        //newFolder(directory);
        //delFile(directory+"test.txt");
        //delFolder(directory);
    }

    /**
     * 新建目录
     */
    public static void newFolder(String folderPath) {
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            if(!myFilePath.exists()) {
                myFilePath.mkdir();
            }
            System.out.println("新建目录操作 成功执行");
    }

    public  static  void newFile(String FileName,String FileText) throws IOException {
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
        File file=new File(directory,FileName+".txt");
        if (!file.exists()) {
            file.createNewFile();
        }
            //向指定文件中写入文字
            FileWriter fileWriter;
            fileWriter = new FileWriter(directory+FileName+".txt");
            //使用缓冲区比不使用缓冲区效果更好，因为每趟磁盘操作都比内存操作要花费更多时间。
            //通过BufferedWriter和FileWriter的连接，BufferedWriter可以暂存一堆数据，然后到满时再实际写入磁盘
            //这样就可以减少对磁盘操作的次数。如果想要强制把缓冲区立即写入,只要调用writer.flush();这个方法就可以要求缓冲区马上把内容写下去
            BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
            bufferedWriter.write(FileText);
            bufferedWriter.close();
            System.out.println("保存成功 成功执行");
    }

    /**
     * 删除文件
     */
    public  static void deleteFile(String fileName) {
            String filePath = directory+fileName+".txt";
            filePath = filePath.toString();
            File myDelFile = new File(filePath);
            myDelFile.delete();
            System.out.println("删除文件操作 成功执行");
    }
    /**
     * 删除文件夹
     */
    public void delFolder(String folderPath) {
            delAllFile(folderPath); //删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            if(myFilePath.delete()) { //删除空文件夹
                System.out.println("删除文件夹" + folderPath + "操作 成功执行");
            } else {
                System.out.println("删除文件夹" + folderPath + "操作 执行失败");
            }
    }
    /**
     * 删除文件夹里面的所有文件
     */
    public static void delAllFile(String path) {
        File file = new File(path);
        if(!file.exists()){
            return;
        }
        if(!file.isDirectory()) {
            return;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++){
            if(path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }

            if (temp.isDirectory()) {
                //delAllFile(path+"/"+ tempList[i]);//先删除文件夹里面的文件
                deleteFile(path+ File.separatorChar + tempList[i]);//再删除空文件夹
            }
        }
        System.out.println("删除文件操作 成功执行");
    }


}
