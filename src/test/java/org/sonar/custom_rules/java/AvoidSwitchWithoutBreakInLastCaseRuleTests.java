package org.sonar.custom_rules.java;

import org.junit.jupiter.api.Test;
import org.sonar.custom_rules.java.rules.AvoidMethodsWithTooManyParametersRule;
import org.sonar.custom_rules.java.rules.AvoidSwitchWithoutBreakInLastCaseRule;
import org.sonar.java.checks.verifier.CheckVerifier;

class AvoidSwitchWithoutBreakInLastCaseRuleTests {

    @Test
    void test() {
        CheckVerifier.newVerifier()
                .onFile("src/test/files/AvoidSwitchWithoutBreakInLastCaseRule.java")
                .withCheck(new AvoidSwitchWithoutBreakInLastCaseRule())
                .verifyIssues();
    }
}
