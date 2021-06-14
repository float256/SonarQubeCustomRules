class ClassForTest {
    public void method() {
        int a = 1;
        switch (a) {
            case 1: // Noncompliant
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 1: // Noncompliant
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 2: // Compliant
                System.out.println();
                System.out.println();
                System.out.println();
                break;
            case 3: // Compliant
                System.out.println();
                break;
        }
    }
}