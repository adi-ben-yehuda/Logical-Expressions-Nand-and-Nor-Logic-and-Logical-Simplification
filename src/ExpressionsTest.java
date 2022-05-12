import java.util.Map;
import java.util.TreeMap;

/**
 * @author Adi Ben Yehuda 211769757
 * @since 2022-04-30
 */
public class ExpressionsTest {
    /**
     * The function creates an expression and prints the expression,
     * his value, the Nandified, Norified and simplified version of the
     * expression.
     *
     * @param args an array of sizes of balls.
     */
    public static void main(String[] args) throws Exception {
        Map<String, Boolean> assign = new TreeMap<>();
        assign.put("x", true);
        assign.put("y", false);
        Expression e1 = new Not(new Not(new And(new Var("x"),
                new Var("y"))));

        System.out.println(e1);
        System.out.println(e1.evaluate(assign).toString());
        System.out.println(e1.nandify().toString());
        System.out.println(e1.norify().toString());
        System.out.println(e1.simplify().toString());
    }
}
