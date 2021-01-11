package HKU2021;

/**
 * 478. Generate Random Point in a Circle
 */
public class RandomPointInCircle {
    private double radius;
    private double x_center;
    private double y_center;

    public RandomPointInCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double[] randomPoint = getRandomPoint();
        double[] center = {x_center, y_center};
        while (!calculateDis(center, randomPoint, radius)) {
            randomPoint = getRandomPoint();
        }
        return randomPoint;
    }

    private double[] getRandomPoint() {
        return new double[]{Math.random() * radius * 2 + x_center - radius, Math.random() * radius * 2 + y_center - radius};
    }

    private boolean calculateDis(double[] center, double[] point, double radius) {
        double distance = 0;

        for (int i = 0; i < 2; i++) {
            double temp = Math.pow((center[i] - point[i]), 2);
            distance += temp;
        }
        distance = Math.sqrt(distance);

        return distance < radius;
    }

    /**
     * 极坐标
     * x = r * cosO, y = r * sinO
     * https://zhuanlan.zhihu.com/p/203377553
     * @return
     */
    public double[] randPointBetter() {
        double randomR = radius * Math.sqrt(Math.random());
        double theta = Math.random() * Math.PI * 2;

        return new double[]{Math.cos(theta) * randomR + x_center, Math.sin(theta) * randomR + y_center};
    }

    public static void main(String[] args) {
        RandomPointInCircle randomPointInCircle = new RandomPointInCircle(1, 0, 0);
        double[] randomPoint = randomPointInCircle.randPoint();
        System.out.println(randomPoint[0]);
        System.out.println(randomPoint[1]);
    }
}
