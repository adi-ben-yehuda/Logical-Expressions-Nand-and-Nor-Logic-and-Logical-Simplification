import java.util.ArrayList;
import java.util.List;

/**
 * @author Adi Ben Yehuda 211769757
 * @since 2022-04-27
 */
public abstract class BinaryExpression extends BaseExpression {
    private Expression firstExpression;
    private Expression secondExpression;

    /**
     * The function puts all the variables of the expression in the list of
     * variables.
     *
     * @param varList
     * @param expression
     */
    private void getVariablesOfExpression(List<String> varList,
                                          Expression expression) {
        String var;

        if (expression != null) {
            for (int i = 0; i < expression.getVariables().size(); i++) {
                var = expression.getVariables().get(i);

                // Check if the variable doesn't exist in the variables list.
                if (varList.indexOf(var) == -1) {
                    varList.add(var);
                }
            }
        }
    }

    /**
     * The function updates the first expression.
     *
     * @param firstExpression
     */
    public void setFirstExpression(Expression firstExpression) {
        this.firstExpression = firstExpression;
    }

    /**
     * The function updates the second expression.
     *
     * @param secondExpression
     */
    public void setSecondExpression(Expression secondExpression) {
        this.secondExpression = secondExpression;
    }

    /**
     * The function returns the first expression.
     *
     * @return the first expression.
     */
    public Expression getFirstExpression() {
        return firstExpression;
    }

    /**
     * The function returns the second expression.
     *
     * @return the second expression.
     */
    public Expression getSecondExpression() {
        return secondExpression;
    }

    /**
     * The function returns the variables of the expression.
     *
     * @return the variables of the expression.
     */
    @Override
    public List<String> getVariables() {
        List<String> varList = new ArrayList<>();

        getVariablesOfExpression(varList, firstExpression);
        getVariablesOfExpression(varList, secondExpression);

        return varList;
    }

    /**
     * The function returns a new expression in which all occurrences of the
     * variable var are replaced with the provided expression (Does not modify
     * the current expression).
     *
     * @param expression
     * @param var
     * @param type       The type of expression that called this function.
     * @return a new expression.
     */
    public Expression assignByType(String var, Expression expression,
                                   BinaryExpression type) {
        List<String> firstVarList = firstExpression.getVariables();
        List<String> secondVarList = secondExpression.getVariables();

        // Check if the var is one of the variables of the firstVarList.
        if (firstVarList.contains(var)) {
            type.setFirstExpression(firstExpression.assign(var, expression));
        }

        // Check if the var is one of the variables of the secondVarList.
        if (secondVarList.contains(var)) {
            type.setSecondExpression(secondExpression.assign(var, expression));
        }

        // Check if the expression include T or F.
        if (expression.toString().equals("T")
                || expression.toString().equals("F")) {
            // Check if the first expression equals to the var.
            if (firstExpression.toString().equals(var)) {
                type.setFirstExpression(expression);
            }

            // Check if the first expression equals to the var.
            if (secondExpression.toString().equals(var)) {
                type.setSecondExpression(expression);
            }
        }

        // Check if the first expression is null
        if (type.getFirstExpression() == null) {
            type.setFirstExpression(firstExpression);
        }

        // Check if the second expression is null
        if (type.getSecondExpression() == null) {
            type.setSecondExpression(secondExpression);
        }

        return type;
    }
}
