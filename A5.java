import org.apache.commons.math3.optim.*;
import org.apache.commons.math3.optim.linear.*;
import org.apache.commons.math3.optim.nonlinear.scalar.GoalType;
import org.apache.commons.math3.optim.nonlinear.scalar.ObjectiveFunction;
import org.apache.commons.math3.optim.nonlinear.scalar.constraint.*;

public class A5 {
    public static void main(String[] args) {
        int N = 5; // number of locations
        double[][] c = {{0, 2, 3, 4, 1},
                        {2, 0, 1, 3, 2},
                        {3, 1, 0, 2, 3},
                        {4, 3, 2, 0, 1},
                        {1, 2, 3, 1, 0}}; // transportation costs
        LinearObjectiveFunction f = new LinearObjectiveFunction(new double[N*N], 0); // objective function
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                f.setCoefficient(i*N+j, c[i][j]-1); // market price minus transportation cost
            }
        }
        LinearConstraintSet constraints = new LinearConstraintSet(); // constraints
        for (int i = 0; i < N; i++) {
            double[] coeffs = new double[N*N];
            for (int j = 0; j < N; j++) {
                coeffs[i*N+j] = 1; // production constraint
                coeffs[j*N+i] = 1; // consumption constraint
            }
            constraints.addConstraint(new LinearConstraint(coeffs, Relationship.LEQ, 1));
        }
        constraints.addConstraint(new LinearConstraint(new double[N*N], Relationship.GEQ, 0)); // non-negativity constraint
        SimplexSolver solver = new SimplexSolver(); // linear programming solver
        PointValuePair solution = solver
