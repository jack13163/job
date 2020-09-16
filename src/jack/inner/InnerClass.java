package jack.inner;

/**
 * java内部类
 */
public class InnerClass {
    private int id;
    private String name;
    private static double secret;

    class Inner {
        private int innerId;
        private double secret;

        public Inner(){
            this.innerId = id;
            this.secret = InnerClass.secret;
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        Inner inner = innerClass.new Inner();
        inner.innerId = 13;
    }
}
