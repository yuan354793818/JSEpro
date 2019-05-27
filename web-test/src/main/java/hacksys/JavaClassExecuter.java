package hacksys;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class JavaClassExecuter {
    public static String execute(byte[] classByte) {
        HackSystem.clearBuffer();
        ClassModify cm = new ClassModify(classByte);
        byte[] modiBytes=cm.modifyUTF8Constant("java/lang/System","hacksys/HackSystem");
        HotSwapClassloader loader = new HotSwapClassloader();
        Class clazz = loader.loadByte(modiBytes);
        try {
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, new String[]{null});
        } catch (Throwable e) {
            e.printStackTrace(HackSystem.out);
        }
        return HackSystem.getBufferString();
    }
     /* 如果hotswap不指定为
        public HotSwapClassloader() {
            super(HotSwapClassloader.class.getClassLoader()); //ParallelWebappClassLoader
         }
        则hotswap用AppClassLoader加载出clazz，main中的HackSystem也由其加载
        JavaClassExecuter中的HackSystem由tomcat ParallelWebappClassLoader 加载出
        加载器不一致相当于两个不同类   符号变量不一致

        ParallelWebappClassLoader 找不到由 AppClassLoader 加载出的HackSystem
        因为ParallelWebappClassLoader和AppClassLoader都继承于URLClassLoader，属于同一级

    */

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\JavaEEworkspace\\JSEpro\\web-test\\target\\classes\\com\\test\\Main.class");
        byte[] b = new byte[is.available()];
        is.read(b);
        is.close();

        System.out.println(execute(b));
    }
}
