package org.sonar.custom_rules.java.rules;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.CaseGroupTree;
import org.sonar.plugins.java.api.tree.SwitchStatementTree;
import org.sonar.plugins.java.api.tree.Tree;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

@Rule(key = "AvoidCaseBlocksWithALotOfStatements")
public class AvoidCaseBlocksWithALotOfStatementsRule extends IssuableSubscriptionVisitor {

    private static final int MAX_NUMBER_IF_STATEMENTS = 4;

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.SWITCH_STATEMENT);
    }

    @Override
    public void visitNode(@Nonnull Tree tree) {
        SwitchStatementTree switchStatementTree = (SwitchStatementTree) tree;
        List<CaseGroupTree> allCaseBlocks = switchStatementTree.cases();
        allCaseBlocks.forEach(caseGroupTree -> {
            if (caseGroupTree.body().size() > MAX_NUMBER_IF_STATEMENTS) {
                reportIssue(caseGroupTree, "Case block contains too many expressions");
            }
        });
    }
}
