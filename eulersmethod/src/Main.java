 class Main {
    public static void main(String[] args) {
        //Write your differential equation in the following lambda expression in the form dy/dt = f(t,y)
        DifferentialEquation chap2_7prob2 = (t, y) -> 2*y-1;

        Problem p = new Problem(chap2_7prob2);
        double[][] solution = p.solveEulerVerbose(0.0, 1, 1.0, 0.1);
    }
}