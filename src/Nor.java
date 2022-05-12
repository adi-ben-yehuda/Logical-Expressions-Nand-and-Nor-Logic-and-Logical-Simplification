import java.util.Map;

/**
 * @author Adi Ben Yehuda 211769757
 * @since 2022-04-27
 */
public class Nor extends BinaryExpression implements Expression {
    /**
     * The function constructs a new nor expression.
     *
     * @param firstExpression
     * @param secondExpression
     */
    public Nor(Expression firstExpression, Expression secondExpression) {
        super.setFirstExpression(firstExpression);
        super.setSecondExpression(secondExpression);
    }

    /**
     * The function gets the two parts of the expression, simplifies it and
     * returns the new expression.
     *
     * @param firstExpression
     * @param secondExpression
     * @return a new expression.
     */
    private Expression tempSimplify(Expression firstExpression,
                                    Expression secondExpression) {
        // That is, the first expression and the second expression are equal.
        if (firstExpression.toString().equals(secondExpression.toString())) {
            if (firstExpression.getVariables().size() > 0) {
                return new Not(firstExpression); // (x V x) = ~(x)
            } else if (firstExpression.toString().equals("F")) {
                return new Val(true); // (F V F) = T
            }
            return new Val(false); // (T V T) = F
        } else if (firstExpression.getVariables().size() == 0
                && secondExpression.getVariables().size() > 0) {
            /* That is, the first expression is T or F and the second includes
             variables.*/
            if (firstExpression.toString().equals("F")) { // The first is F
                return new Not(secondExpression); // (x V F) = ~(x)
            }
            return new Val(false); // (x V T) = F
        } else if (secondExpression.getVariables().size() == 0
                && firstExpression.getVariables().size() > 0) {
             /* That is, the second expression is T or F and the first includes
             variables.*/
            if (secondExpression.toString().equals("F")) { // The second is F
                return new Not(firstExpression); // (F V x) = ~(x)
            }
            return new Val(false); // (T V x) = F
        } else if (firstExpression.getVariables().size() == 0
                && secondExpression.getVariables().size() == 0) {
            // That is, the first and second expressions are T or F.
            if (firstExpression.toString().equals("F")
                    && secondExpression.toString().equals("T")) {
                return new Val(false); // (F V T) = F
            } else if (firstExpression.toString().equals("T")
                    && secondExpression.toString().equals("F")) {
                return new Val(false); // (T V F) = F
            }
        }
        return null;
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
            // Return true if both expressions are incorrect.
            if (!super.getFirstExpression().evaluate(assignment)
                    && !super.getSecondExpression().evaluate(assignment)) {
                return true;
            }

            return false;
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
        Nor nor = new Nor(null, null);
        return super.assignByType(var, expression, nor);
    }

    /**
     * The function returns the expression tree resulting from converting all
     * the operations to the logical Nand operation.
     *
     * @return a new expression.
     */
    @Override
    public Expression nandify() {
        Expression e1 = null, e2 = null, firstPart, secondPart, part;

        // Check if the first expression includes an expression.
        if (super.getFirstExpression().toString().contains("(")) {
            e1 = super.getFirstExpression().nandify();
        }

        // Check if the second expression includes an expression.
        if (super.getSecondExpression().toString().contains("(")) {
            e2 = super.getSecondExpression().nandify();
        }

        // That is, both expressions are variable or value.
        if (e1 == null && e2 == null) {
            firstPart = new Nand(super.getFirstExpression(),
                    super.getFirstExpression()); // (A NAND A)
            secondPart = new Nand(super.getSecondExpression(),
                    super.getSecondExpression()); // (B NAND B)
        } else {
            firstPart = new Nand(e1, e1); // (A NAND A)
            secondPart = new Nand(e2, e2); // (B NAND B)
        }

        part = new Nand(firstPart, secondPart); // (A NAND A) NAND (B NAND B)
        // The calculation is: for A and B, return
        // ((A NAND A) NAND (B NAND B)) NAND ((A NAND A) NAND (B NAND B))
        return new Nand(part, part);
    }

    /**
     * The function returns the expression tree resulting from converting all
     * the operations to the logical Nor operation.
     *
     * @return a new expression.
     */
    @Override
    public Expression norify() {
        Expression e1 = null, e2 = null, firstPart, secondPart, part;

        // Check if the first expression includes an expression.
        if (super.getFirstExpression().toString().contains("(")) {
            e1 = super.getFirstExpression().norify();
        }

        // Check if the second expression includes an expression.
        if (super.getSecondExpression().toString().contains("(")) {
            e2 = super.getSecondExpression().norify();
        }

        // That is, both expressions are variable or value.
        if (e1 == null && e2 == null) {
            e1 = super.getFirstExpression();
            e2 = super.getSecondExpression();
        } else if (e1 == null) {
            e1 = super.getFirstExpression();
        } else if (e2 == null) {
            e2 = super.getSecondExpression();
        }

        return new Nor(e1, e2);
    }

    /**
     * The function returns a simplified version of the current expression.
     *
     * @return a new expression.
     */
    @Override
    public Expression simplify() {
        Expression e1 = null, e2 = null, tempExp;

        // Check if the first expression includes an expression.
        if (super.getFirstExpression().toString().contains("(")) {
            e1 = super.getFirstExpression().simplify();
        }

        // Check if the second expression includes an expression.
        if (super.getSecondExpression().toString().contains("(")) {
            e2 = super.getSecondExpression().simplify();
        }

        // That is, both expressions are variable or value.
        if (e1 == null && e2 == null) {
            e1 = super.getFirstExpression();
            e2 = super.getSecondExpression();
        } else if (e1 == null) {
            e1 = super.getFirstExpression();
        } else if (e2 == null) {
            e2 = super.getSecondExpression();

        }
        tempExp = tempSimplify(e1, e2); // Simplify the expression.

        if (tempExp == null) {
            return new Nor(e1, e2);
        }
        return tempExp;
    }

    /**
     * The function returns a nice string representation of the expression.
     *
     * @return the expression.
     */
    @Override
    public String toString() {
        return "(" + super.getFirstExpression().toString() + " V "
                + super.getSecondExpression().toString() + ")";
    }
}
