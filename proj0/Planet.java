public class Planet {
    /***
     * 6 public instance variables
     */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static final double G = 6.67e-11;


    /**
     * two constructors
     */
    //one of two constructors
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    //the other constructors
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    //calculate distance between two planet
    public double calcDistance(Planet p) {
        return Math.sqrt((p.xxPos - this.xxPos) * (p.xxPos - this.xxPos) + (p.yyPos - this.yyPos) * (p.yyPos - this.yyPos));
    }
    //calculate the force between two planets
    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);//distance
        return G * this.mass * p.mass / (r * r);
    }
    //calculate the force on exerted by x direction
    public double calcForceExertedByX(Planet p) {
        double xDistance = p.xxPos - this.xxPos;
        return calcForceExertedBy(p) * xDistance / calcDistance(p);
    }
    //calculate the force on exerted by y direction
    public double calcForceExertedByY(Planet p) {
        double yDistance = p.yyPos - this.yyPos;
        return calcForceExertedBy(p) * yDistance / calcDistance(p);
    }
    //calculate the force of all planets on exerted by x direction
    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double NetForceExertedByX = 0;
        for (Planet planet : allPlanets) {
            if (this.equals(planet)) continue;
            NetForceExertedByX += this.calcForceExertedByX(planet);
        }
        return NetForceExertedByX;
    }
    //calculate the force of all planets on exerted by y direction
    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double NetForceExertedByY = 0;
        for (Planet planet : allPlanets) {
            if (this.equals(planet)) continue;
            NetForceExertedByY += this.calcForceExertedByY(planet);
        }
        return NetForceExertedByY;
    }
}
