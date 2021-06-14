package org.sonar.custom_rules.java;

import org.sonar.api.Plugin;

public class SonarQubeCustomRulesPlugin implements Plugin {

    @Override
    public void define(Context context) {
        context.addExtension(SonarQubeCustomRulesDefinition.class);
        context.addExtension(SonarQubeCustomRulesRegistrar.class);
    }
}
