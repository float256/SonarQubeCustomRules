package org.sonar.custom_rules.java;

import org.sonar.custom_rules.java.rules.AvoidCaseBlocksWithALotOfStatementsRule;
import org.sonar.custom_rules.java.rules.AvoidSwitchWithoutBreakInLastCaseRule;
import org.sonar.plugins.java.api.JavaCheck;
import org.sonar.custom_rules.java.rules.AvoidMethodsWithTooManyParametersRule;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RulesList {

    private RulesList() { }

    public static List<Class<? extends JavaCheck>> getChecks() {
        List<Class<? extends JavaCheck>> checks = new ArrayList<>();
        checks.addAll(getJavaChecks());
        checks.addAll(getTestChecks());
        return Collections.unmodifiableList(checks);
    }

    public static List<Class<? extends JavaCheck>> getJavaChecks() {
        return Collections.unmodifiableList(Arrays.asList(
                AvoidMethodsWithTooManyParametersRule.class,
                AvoidSwitchWithoutBreakInLastCaseRule.class,
                AvoidCaseBlocksWithALotOfStatementsRule.class));
    }

    public static List<Class<? extends JavaCheck>> getTestChecks() {
        return Collections.emptyList();
    }
}
