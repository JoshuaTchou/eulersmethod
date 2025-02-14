# eulersmethod
Approximates a differential equation using Explicit Euler's Method.

To approximate a differential equation dy/dt = f(t,y) starting at y(t0)=y0 and using time step timestep:

Implement the DifferentialEquation interface using a lambda expression in the Main class:
DifferentialEquation d = (t,y) -> [f(t,y)];

Create a Problem object:
Problem p = new Problem (d);

The Problem class defines 2 methods.
solveEuler(t0,tf,y0,timestep): double[]
Returns a double[2] with the contents [tf,yf] and prints tf and yf to console.

solveEulerVerbose(t0,tf,y0,timestep): double[]
Returns a double[n][2] where n is the number of timesteps used (includes t=t0), and where the value at [n][0] is t at the nth timestep, and the value at [n][1] is the y at the nth timestep. Prints t and y to console at every timestep.
