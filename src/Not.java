import java.util.List;
import java.util.Map;

/**
 * @author Adi Ben Yehuda
 * @since 2022-04-27
 */
public class Not extends UnaryExpression implements Expression {
    private Expression expression;

    /**
     * The function constructs a new not expression.
     *
     * @param expression
     */
    public Not(Expression expression) {
        this.expression = expression;
    }

    /**
     * The function returns a list that includes the variables in the
     * expression.
     *
     * @returna list that includes the variables in the expression.
     */
    @Override
    public List<String> getVariables() {
        return expression.getVariables();
    }

    /**
     * The function evaluates the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception is
     * thrown.
     *
     * @param assignment
     * @return the result of the calculation
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        try {
            // Return true if the expression is incorrect.
            return !expression.evaluate(assignment);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * The function returns a new expression in which all occurrences of the
     * variable var are replaced with the provided expression (Does not modify
     * the current expression).
     *
     * @param expression
     * @param var
     * @return a new expression.
     */
    @Override
    public Expression assign(String var, Expression expression) {
        if (this.expression.getVariables().contains(var)) {
            return new Not(this.expression.assign(var, expression));
        }

        return this;
    }

    /**
     * The function returns the expression tree resulting from converting all
     * the operations to the logical Nand operation.
     *
     * @return a new expression.
     */
    @Override
    public Expression nandify() {
        Expression e = null;

        if (expression.toString().contains("(")) {
            e = expression.nandify();
        }

        if (e == null) {
            e = expression;
        }
        return new Nand(e, e);
    }

    /**
     * The function returns the expression tree resulting from converting all
     * the operations to the logical Nor operation.
     *
     * @return a new expression.
     */
    @Override
    public Expression norify() {
        Expression e = null;

        if (expression.toString().contains("(")) {
            e = expression.norify();
        }

        if (e == null) {
            e = expression;
        }
        return new Nor(e, e);
    }

    /**
     * The function returns a simplified version of the current expression.
     *
     * @return a new expression.
     */
    @Override
    public Expression simplify() {
        Expression e;

        // Check if there are variables in the expression.
        if (expression.getVariables().size() > 0) {
            return new Not(expression.simplify());
        } else if (expression.toString().equals("F")) {
            return new Val(true); // ~F = T
        } else if (expression.toString().equals("T")) {
            return new Val(false); // ~T = F
        } else {
            // That is, the expression includes an expression that does not
            // include variables.
            e = expression.simplify();
            if (e.toString().equals("F")) {
                return new Val(true); // ~F = T
            }
            return new Val(false); // ~T = F
        }
    }

    /**
     * The function returns a nice string representation of the expression.
     *
     * @return the expression.
     */
    @Override
    public String toString() {
        // That is, there is an expression within the expression.
        if (expression.getVariables() == null) {
            return "~(" + expression.toString() + ")";
        } else if (expression.getVariables().size() > 0) {
            return "~(" + expression.toString() + ")";
        } else {
            return "~(" + expression + ")";
        }
    }
}
