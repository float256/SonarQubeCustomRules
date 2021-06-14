package org.sonar.custom_rules.java;

import org.sonar.plugins.java.api.CheckRegistrar;
import org.sonarsource.api.sonarlint.SonarLintSide;

@SonarLintSide
public class SonarQubeCustomRulesRegistrar implements CheckRegistrar {

    @Override
    public void register(RegistrarContext registrarContext) {
        registrarContext.registerClassesForRepository(
                SonarQubeCustomRulesDefinition.REPOSITORY_KEY, RulesList.getJavaChecks(), RulesList.getTestChecks());
    }
}
