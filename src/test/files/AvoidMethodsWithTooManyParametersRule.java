class ClassForTest {
    public void method(int first, int second, String third, Date forth, float fifth, double sixth) { // Noncompliant
        throw new UnsupportedOperationException();
    }

    public void method2(int first, int second, int third, int forth, int fifth) { // Compliant
        throw new UnsupportedOperationException();
    }

    public void method3() { // Compliant
        throw new UnsupportedOperationException();
    }
}