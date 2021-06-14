package org.sonar.custom_rules.java.rules;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.MethodTree;
import org.sonar.plugins.java.api.tree.Tree;

import java.util.Collections;
import java.util.List;

@Rule(key = "AvoidMethodsWithTooManyParameters")
public class AvoidMethodsWithTooManyParametersRule extends IssuableSubscriptionVisitor {

    private static final int MAX_NUMBER_OF_PARAMETERS = 5;

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.METHOD);
    }

    @Override
    public void visitNode(Tree tree) {
        MethodTree methodTree = (MethodTree) tree;
        if (methodTree.parameters().size() > MAX_NUMBER_OF_PARAMETERS) {
            reportIssue(methodTree, "Too many parameters in method!!!");
        }
    }
}
