import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Adi Ben Yehuda
 * @since 2022-04-27
 */
public class Var implements Expression {
    private String variable;

    /**
     * The function constructs a new variable.
     *
     * @param variable
     */
    public Var(String variable) {
        this.variable = variable;
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
            return assignment.get(this.variable);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * The function returns the variables of the expression.
     *
     * @return the variables of the expression.
     */
    @Override
    public Boolean evaluate() throws Exception {
        return evaluate(null);
    }

    /**
     * The function returns a list that includes the variable.
     *
     * @return a list that includes the variable.
     */
    @Override
    public List<String> getVariables() {
        List<String> varList = new ArrayList<>();
        varList.add(variable);
        return varList;
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
        if (var.equals(this.variable)) {
            return expression;
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
        return this;
    }

    /**
     * The function returns the expression tree resulting from converting all
     * the operations to the logical Nor operation.
     *
     * @return a new expression.
     */
    @Override
    public Expression norify() {
        return this;
    }

    /**
     * The function returns a simplified version of the current expression.
     *
     * @return a new expression.
     */
    @Override
    public Expression simplify() {
        return this;
    }

    /**
     * The function returns a nice string representation of the expression.
     *
     * @return the expression.
     */
    @Override
    public String toString() {
        return variable;
    }
}
