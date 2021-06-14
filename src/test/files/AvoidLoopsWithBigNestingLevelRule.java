import java.util.Arrays;
import java.util.List;

class ClassForTests {
    public void method() {
        for (; ; ) { // Compliant
            for (; ; ) { // Compliant
                for (; ; ) { // Compliant
                    for (; ; ) { // Noncompliant
                        System.out.println();
                    }
                }
            }
        }

        while (false) { // Compliant
            List<Integer> list = Arrays.asList(1, 2, 3);
            for (int num : list) { // Compliant
                do { // Compliant
                    while (true) { // Noncompliant
                        System.out.println(num);
                        for (; ; ) { // Noncompliant
                            System.out.println();
                        }
                        for (; ; ) { // Noncompliant
                            System.out.println();
                        }
                        for (; ; ) { // Noncompliant
                            System.out.println();
                        }
                    }
                } while (false);
            }
        }
    }
}