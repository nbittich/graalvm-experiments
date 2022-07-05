import java.util.ArrayList;

public class TestJava {
    public static void main(String[] args) {
        var list = new ArrayList<>();
        for (int i = 0; i < 70_000_000; i++) {
            var v = new X("Hello " + i);
            list.add(v);
        }
        System.out.println("len: " + list.size());
    }

    static class X {
        private String v;

        public X(String v) {
            this.v = v;
        }
    }
}
