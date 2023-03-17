import java.util.List;
import java.util.Map;

/**
 * @author Adi Ben Yehuda
 * @since 2022-04-27
 */
public interface Expression {
    /**
     * The function evaluates the expression using the variable values provided
     * in the assignment, and return the result. If the expression
     * contains a variable which is not in the assignment, an exception is
     * thrown.
     *
     * @param assignment
     * @return the result of the calculation.
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * The function evaluates the expression through an empty assignment.
     *
     * @return the result of the calculation.
     */
    Boolean evaluate() throws Exception;

    /**
     * The function returns the variables of the expression.
     *
     * @return the variables of the expression.
     */
    List<String> getVariables();

    /**
     * The function returns a nice string representation of the expression.
     *
     * @return the expression.
     */
    String toString();

    /**
     * The function returns a new expression in which all occurrences of the
     * variable var are replaced with the provided expression (Does not modify
     * the current expression).
     *
     * @param expression
     * @param var
     * @return a new expression.
     */
    Expression assign(String var, Expression expression);

    /**
     * The function returns the expression tree resulting from converting all
     * the operations to the logical Nand operation.
     *
     * @return a new expression.
     */
    Expression nandify();

    /**
     * The function returns the expression tree resulting from converting all
     * the operations to the logical Nor operation.
     *
     * @return a new expression.
     */
    Expression norify();

    /**
     * The function returns a simplified version of the current expression.
     *
     * @return a new expression.
     */
    Expression simplify();
}
