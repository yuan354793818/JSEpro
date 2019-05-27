package hacksys;

public class HotSwapClassloader extends ClassLoader{

    public HotSwapClassloader() {
        super(HotSwapClassloader.class.getClassLoader()); //如果不指定，则为系统类加载器，加载不到
        //System.out.println(" hot "+HotSwapClassloader.class.getClassLoader().getParent()); 暂定ParallelWebappClassLoader不委托parent
    }

    public Class loadByte(byte[] classByte) {
        return defineClass(null, classByte, 0, classByte.length);
    }
}
