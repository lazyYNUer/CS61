/**
 * Test the planet
 */
public class TestPlanet {
    public static void main(String[] args) {
        Planet[] planets = new Planet[2];//create two planets
        planets[0] = new Planet(0, 0, 0, 0, 1e20, "firstPlanet");
        planets[1] = new Planet(10, 10, 10, 10, 1e20, "secondPlanet");
        System.out.println("The pairwise force between these two planets is " + planets[0].calcForceExertedBy(planets[1]));
    }
}
