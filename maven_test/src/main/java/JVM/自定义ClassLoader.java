package JVM;

import org.junit.Test;

import java.io.*;

/**
 * 加载应用程序之外的类文件，比如本地D盘下的，或者去加载网络上的某个类文件
 */
public class 自定义ClassLoader {
    @Test
    public void test1() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException {
        MyClassLoader loader = new MyClassLoader("D:\\upload");
        Class<?> aClass = loader.loadClass("JVM.Apple");
       /* Object o = heapOOM.newInstance();
        int price = o.getClass().getField("price").getInt(o); Cast失败解决1： 反射获取属性
        System.out.println(price);*/
        Fruit apple = (Fruit) aClass.newInstance();

        System.out.println( apple.getPrice());

    }



}

 class MyClassLoader extends ClassLoader{

     private String classpath;

     public MyClassLoader(String classpath) {

         this.classpath = classpath;
     }


     @Override
     protected Class<?> findClass(String name) throws ClassNotFoundException {
         byte[] data = new byte[0];
         try {
             data = getData(name);

             if (data == null) {

             }else {
                 return defineClass(name, data, 0, data.length);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }


         return super.findClass(name);
     }

     private byte[] getData(String name) throws IOException {
         String path = classpath + File.separatorChar + name.replace('.', File.separatorChar) + ".class";
         System.out.println(path);
         InputStream in=null;
         ByteArrayOutputStream bout=null;
         try {
             in = new FileInputStream(path);
             bout = new ByteArrayOutputStream();
             byte[] bytes = new byte[1024];
             int len;
             while ((len = in.read(bytes)) != -1) {
                 bout.write(bytes, 0, len);
             }

             return bout.toByteArray();

         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }finally {
             if (in != null) {
                 in.close();
             }
             if (bout != null) {
                 bout.close();
             }
         }
         return null;
     }
 }
