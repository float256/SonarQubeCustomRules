package org.sonar.custom_rules.java;

import org.junit.jupiter.api.Test;
import org.sonar.custom_rules.java.rules.AvoidLoopsWithBigNestingLevelRule;
import org.sonar.java.checks.verifier.CheckVerifier;

class AvoidLoopsWithBigNestingLevelRuleTests {

    @Test
    void test() {
        CheckVerifier.newVerifier()
                .onFile("src/test/files/AvoidLoopsWithBigNestingLevelRule.java")
                .withCheck(new AvoidLoopsWithBigNestingLevelRule())
                .verifyIssues();
    }
}
