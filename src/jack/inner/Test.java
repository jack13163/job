package jack.inner;

import jack.outer.Outter;

public class Test {
    public static void main(String[] args)  {
        Outter outter = new Outter();
        outter.new Inner().print();
    }
}