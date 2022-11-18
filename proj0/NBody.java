public class NBody {
    /**
     *
     * @param fileName
     * @return radius of universe
     */
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }

    /**
     *
     * @param fileName
     * @return an array of planets  from the txt file
     */
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int numOfPlanets = in.readInt();
        Planet[] planets = new Planet[numOfPlanets];
        double radius = in.readDouble();
        for (int i = 0; i < numOfPlanets; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double mass = in.readDouble();
            String imgName = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, mass, imgName);
        }
        return planets;
    }

    /**
     * main method to start draw
     * @param args
     */
    public static void main(String[] args) {
        //collect input
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = NBody.readPlanets(filename);
        double radius = NBody.readRadius(filename);

        //prepare for drawing,set universe radius
        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        StdDraw.enableDoubleBuffering();

        //creat animation
        double time = 0;
        while (time != T) {
            //create xForce and yForce array
            double[] xForce = new double[planets.length];
            double[] yForce = new double[planets.length];

            //calculate force on each planet
            for (int i = 0; i < planets.length; i++) {
                xForce[i] = planets[i].calcNetForceExertedByX(planets);
                yForce[i] = planets[i].calcNetForceExertedByY(planets);
            }

            //update condition of each planet
            for (int i = 0; i < planets.length; i++) {
                planets[i].update(dt, xForce[i], yForce[i]);
            }

            //draw background
            StdDraw.picture(0, 0, "images/starfield.jpg");

            //draw all planets
            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

        //draw all the planets
        int count;
        for (count = 0; count < planets.length; count++) {
            planets[count].draw();
            StdDraw.show();
            StdDraw.pause(10);
        }

        //print the universe
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
