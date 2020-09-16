package jack.basic;

/**
 * java关键字的相关测试
 * final修饰的变量在定义时或者构造器中进行初始化赋值
 */
public class JKeyWord {
    private final static int a = 0;
    private final int b;
    private int c;

    public JKeyWord(int b, int c){
        this.b = b;
        this.c = c;
    }

    public JKeyWord(int b){
        this.b = b;
    }

    public static void main(String[] args) {
        //a = 9;
        JKeyWord jKeyWord = new JKeyWord(12);
    }
}
