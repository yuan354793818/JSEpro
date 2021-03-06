package gc;

public class AbstractClsTest {
    public static void main(String[] args) {
        System.out.println(AbstractClsTest.class.getClassLoader());
        System.out.println(AbstractClsTest.class.getClassLoader().getParent());

        ClassLoader classLoader=new ClassLoader(AbstractClsTest.class.getClassLoader().getParent()) {


            /**
             * Finds the class with the specified <a href="#name">binary name</a>.
             * This method should be overridden by class loader implementations that
             * follow the delegation model for loading classes, and will be invoked by
             * the {@link #loadClass <tt>loadClass</tt>} method after checking the
             * parent class loader for the requested class.  The default implementation
             * throws a <tt>ClassNotFoundException</tt>.
             *
             * @param name The <a href="#name">binary name</a> of the class
             * @return The resulting <tt>Class</tt> object
             * @throws ClassNotFoundException If the class could not be found
             * @since 1.2
             */
            @Override
            protected Class<?> findClass(String name) throws ClassNotFoundException {
                return super.findClass(name);
            }
        };

        System.out.println(classLoader.getParent());


    }
}
