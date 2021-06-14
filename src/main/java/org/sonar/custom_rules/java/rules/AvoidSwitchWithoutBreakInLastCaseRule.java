package org.sonar.custom_rules.java.rules;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.IssuableSubscriptionVisitor;
import org.sonar.plugins.java.api.tree.*;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;

@Rule(key = "AvoidSwitchWithoutBreakInLastCase")
public class AvoidSwitchWithoutBreakInLastCaseRule extends IssuableSubscriptionVisitor {

    @Override
    public List<Tree.Kind> nodesToVisit() {
        return Collections.singletonList(Tree.Kind.SWITCH_STATEMENT);
    }

    @Override
    public void visitNode(@Nonnull Tree tree) {
        SwitchStatementTree switchStatementTree = (SwitchStatementTree) tree;
        List<CaseGroupTree> allCaseBlocks = switchStatementTree.cases();
        if (!allCaseBlocks.isEmpty()) {
            CaseGroupTree lastCase = allCaseBlocks.get(allCaseBlocks.size() - 1);
            boolean isCaseHasBreakBlock = lastCase.body().stream()
                    .anyMatch(statementTree -> statementTree.is(Tree.Kind.BREAK_STATEMENT));
            if (!isCaseHasBreakBlock) {
                reportIssue(lastCase, "The last case block does not contain an unconditional break statement");
            }
        }
    }
}
