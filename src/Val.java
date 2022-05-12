import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Adi Ben Yehuda 211769757
 * @since 2022-04-27
 */
public class Val implements Expression {
    private Boolean value;

    /**
     * The function constructs a new value.
     *
     * @param value
     */
    public Val(Boolean value) {
        this.value = value;
    }

    /**
     * The function returns the value.
     *
     * @param assignment
     * @return the value.
     */
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        try {
            return value;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * The function returns the value.
     *
     * @return the value.
     */
    @Override
    public Boolean evaluate() throws Exception {
        try {
            return value;
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * The function returns the variables that include in the value (which is
     * nothing).
     *
     * @return the variables.
     */
    @Override
    public List<String> getVariables() {
        return new ArrayList<>();
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
        // Check if the var is a valid variable.
        if (var.equals("T") || var.equals("F")) {
            if (value) {
                // Check if the expression is a valid variable.
                if (expression.toString().equals("F")
                        || expression.toString().equals("T")) {
                    return expression;
                }
            }
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
        return new Val(value);
    }

    /**
     * The function returns the expression tree resulting from converting all
     * the operations to the logical Nor operation.
     *
     * @return a new expression.
     */
    @Override
    public Expression norify() {
        return new Val(value);
    }

    /**
     * The function returns a simplified version of the current expression.
     *
     * @return a new expression.
     */
    @Override
    public Expression simplify() {
        return new Val(value);
    }

    /**
     * The function returns a nice string representation of the expression.
     *
     * @return the expression.
     */
    @Override
    public String toString() {
        if (value) {
            return "T";
        }

        return "F";
    }
}
