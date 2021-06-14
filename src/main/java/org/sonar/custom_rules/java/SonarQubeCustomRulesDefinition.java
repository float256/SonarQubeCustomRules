package org.sonar.custom_rules.java;

import org.sonar.api.server.rule.RulesDefinition;
import org.sonarsource.analyzer.commons.RuleMetadataLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class SonarQubeCustomRulesDefinition implements RulesDefinition {

    private static final String RESOURCE_BASE_PATH = "org/sonar/l10n/java/rules/java";
    public static final String REPOSITORY_KEY = "custom-rules-java";
    private static final Set<String> RULE_TEMPLATES_KEY = Collections.emptySet();

    @Override
    public void define(Context context) {
        NewRepository repository = context.createRepository(REPOSITORY_KEY, "java")
                .setName("Custom Rules Repository");
        RuleMetadataLoader ruleMetadataLoader = new RuleMetadataLoader(RESOURCE_BASE_PATH);
        ruleMetadataLoader.addRulesByAnnotatedClass(repository, new ArrayList<>(RulesList.getChecks()));
        setTemplates(repository);
        repository.done();
    }

    private static void setTemplates(NewRepository repository) {
        RULE_TEMPLATES_KEY.stream()
                .map(repository::rule)
                .filter(Objects::nonNull)
                .forEach(rule -> rule.setTemplate(true));
    }
}
