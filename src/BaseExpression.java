/**
 * @author Adi Ben Yehuda 211769757
 * @since 2022-04-30
 */
public abstract class BaseExpression implements Expression {
    /**
     * The function evaluates the expression through an empty assignment.
     *
     * @return the result of the calculation.
     */
    @Override
    public Boolean evaluate() throws Exception {
        return evaluate(null);
    }
}
