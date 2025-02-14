public interface DifferentialEquation {
    //Represents a differential equation in the form dy/dt = f(t,y)
    //returns f(t,y) for given t and y
    double slopeFunction(double t, double y);
}
