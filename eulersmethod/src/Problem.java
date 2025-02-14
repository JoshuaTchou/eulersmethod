public class Problem {

    public DifferentialEquation function;
    final double TOLERANCE_FINAL_T = 0.01; //Problems with determining last timestep with double multiplication

    public Problem(DifferentialEquation d) {
        function = d;
    }

    //Euler's method starting at (t0, y0) ending at t = tf using time step timestep
    //Returns [tcurrent, ycurrent] for the last iteration and prints it to console
    //Requires tf >= t0, (tf-t0) is an integer multiple of timestep
    double[] solveEuler(double t0, double tf, double y0, double timestep) {
        double tcurrent = t0;
        double ycurrent = y0;
        while (tcurrent + timestep <= tf*(1.0+TOLERANCE_FINAL_T)) {
            ycurrent = ycurrent + timestep*function.slopeFunction(tcurrent, ycurrent);
            tcurrent = tcurrent + timestep;
        }
        double[] arr = new double[2];
        arr[0] = tcurrent;
        arr[1] = ycurrent;
        System.out.println("solved equation at tf=" + tf + " using y(" + t0 + ") = " + y0 + " and timestep " + timestep);
        System.out.println("final (t, y) is (" + tcurrent + ", " + ycurrent + ")");
        return arr;
    }

    //Euler's method starting at (t0, y0) ending at t = tf using time step timestep
    //Saves the result of every timestep in an array of size [n][2] if there are n timesteps, and prints it to console
    //Array is in the format [[t0,y0], [t1,y1], ... , [tf,yf]]
    //Requires tf >= t0, (tf-t0) is an integer multiple of timestep
    double[][] solveEulerVerbose(double t0, double tf, double y0, double timestep) {
        double tcurrent = t0;
        double ycurrent = y0;
        int n = 0;
        int nSteps = (int) (((tf-t0)*(TOLERANCE_FINAL_T+1.0)/timestep) + 1);
        double[][] arr = new double[nSteps][2];
        while (tcurrent <= tf*(1.0+TOLERANCE_FINAL_T)) {
            arr[n][0] = tcurrent;
            arr[n][1] = ycurrent;
            ycurrent = ycurrent + timestep*function.slopeFunction(tcurrent, ycurrent);
            tcurrent = tcurrent + timestep;
            n += 1;
        }
        System.out.println("solved equation at tf=" + tf + " using y(" + t0 + ") = " + y0 + " and timestep " + timestep);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("n=" + i + ", t=" + arr[i][0] + ", y=" + arr[i][1]);
        }
        return arr;
    }
}
