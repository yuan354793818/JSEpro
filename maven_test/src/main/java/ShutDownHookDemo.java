public class ShutDownHookDemo {
    public static void main(String[] args) throws InterruptedException {
       Runtime.getRuntime().addShutdownHook(new Thread(() -> {
           System.out.println("user hook effect");
       }));
       Thread.sleep(3000);
    }
}
