package org.sonar.custom_rules.java;

import org.junit.jupiter.api.Test;
import org.sonar.custom_rules.java.rules.AvoidMethodsWithTooManyParametersRule;
import org.sonar.java.checks.verifier.CheckVerifier;

class AvoidMethodsWithTooManyParametersRuleTests {

    @Test
    void test() {
        CheckVerifier.newVerifier()
                .onFile("src/test/files/AvoidMethodsWithTooManyParametersRule.java")
                .withCheck(new AvoidMethodsWithTooManyParametersRule())
                .verifyIssues();
    }
}
