package org.sonar.custom_rules.java.rules;

import org.sonar.check.Rule;
import org.sonar.plugins.java.api.JavaFileScanner;
import org.sonar.plugins.java.api.JavaFileScannerContext;
import org.sonar.plugins.java.api.tree.*;

@Rule(key = "AvoidLoopsWithBigNestingLevel")
public class AvoidLoopsWithBigNestingLevelRule extends BaseTreeVisitor implements JavaFileScanner {
    private static final int MAX_NESTING_LEVEL = 3;
    private JavaFileScannerContext context;
    private int currNestingLevel;

    @Override
    public void visitForStatement(ForStatementTree tree) {
        currNestingLevel++;
        checkNesting(tree);
        visit(tree);
        currNestingLevel--;
    }

    @Override
    public void visitWhileStatement(WhileStatementTree tree) {
        currNestingLevel++;
        checkNesting(tree);
        visit(tree);
        currNestingLevel--;
    }

    @Override
    public void visitForEachStatement(ForEachStatement tree) {
        currNestingLevel++;
        checkNesting(tree);
        visit(tree);
        currNestingLevel--;
    }

    @Override
    public void visitDoWhileStatement(DoWhileStatementTree tree) {
        currNestingLevel++;
        checkNesting(tree);
        visit(tree);
        currNestingLevel--;
    }


    @Override
    public void scanFile(JavaFileScannerContext javaFileScannerContext) {
        this.context = javaFileScannerContext;
        this.currNestingLevel = 0;
        scan(context.getTree());
    }

    private void checkNesting(Tree tree) {
        if (currNestingLevel > MAX_NESTING_LEVEL) {
            context.reportIssue(this, tree, "The nesting level of the loops is too big.");
        }
    }

    private void visit(Tree tree) {
        switch (tree.kind()) {
            case WHILE_STATEMENT:
                WhileStatementTree whileStatementTree = (WhileStatementTree) tree;
                scan(whileStatementTree.statement());
                break;
            case DO_STATEMENT:
                DoWhileStatementTree doWhileStatementTree = (DoWhileStatementTree) tree;
                scan(doWhileStatementTree.statement());
                break;
            case FOR_STATEMENT:
                ForStatementTree forStatementTree = (ForStatementTree) tree;
                scan(forStatementTree.statement());
                break;
            case FOR_EACH_STATEMENT:
                ForEachStatement forEachStatement = (ForEachStatement) tree;
                scan(forEachStatement.statement());
                break;
            default:
                break;
        }
    }
}
