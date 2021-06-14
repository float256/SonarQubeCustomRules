package org.sonar.custom_rules.java;

import org.junit.jupiter.api.Test;
import org.sonar.custom_rules.java.rules.AvoidCaseBlocksWithALotOfStatementsRule;
import org.sonar.java.checks.verifier.CheckVerifier;

class AvoidCaseBlocksWithALotOfStatementsRuleTests {

    @Test
    void test() {
        CheckVerifier.newVerifier()
                .onFile("src/test/files/AvoidCaseBlocksWithALotOfStatementsRule.java")
                .withCheck(new AvoidCaseBlocksWithALotOfStatementsRule())
                .verifyIssues();
    }
}
