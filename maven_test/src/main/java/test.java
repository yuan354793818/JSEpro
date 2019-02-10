
public class test {
    public static void main(String[] args) {
        try {
            try {
                int a=0;
                int i=1/0;
            } catch (Exception e) {
                int i=1/0;
            } finally {

            }
        } catch (Exception e) {

        } finally {
        }
    }
}

class Sample{

}