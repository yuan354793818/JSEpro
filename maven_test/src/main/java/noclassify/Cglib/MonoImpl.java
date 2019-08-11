package noclassify.Cglib;

public class MonoImpl extends AbstractMono {
    @Override
    public void run() {
        System.out.println("monoIMP");
    }

    @Override
    void absRun() {
        System.out.println("asbmonoIMP");
    }
}
