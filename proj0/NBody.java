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

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = NBody.readPlanets(filename);
        double radius = NBody.readRadius(filename);
    }
}
