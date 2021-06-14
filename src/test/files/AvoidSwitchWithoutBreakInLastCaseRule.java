class ClassForTest {
    public void method() {
        int variable = 0;
        switch (variable) {
            case 0: // Compliant
                variable = 0;
            case 1: // Compliant
                System.out.println();
            case 2: // Compliant
                variable = -2;
            case 3: // Compliant
                break;
        }

        switch (variable) {
            case 0: // Compliant
                System.out.println();
                break;
            case 1: // Compliant
                variable = -1;
            case 2: // Compliant
                System.out.println();
                break;
            case 3: // Noncompliant
                System.out.println();
        }

        switch (variable) { // Compliant
        }
    }
}