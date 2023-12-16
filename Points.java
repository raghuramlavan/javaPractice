package javaPractice;

public class Points {
    private int x;
    private int y;

    private int getX() {
        return x;
    }

    private int getY() {
        return y;
    }

    public Points(int xx, int yy) {
        x = xx;
        y = yy;
    }

    public Double distance(Points y) {
        return Math.sqrt(Math.pow(this.x - y.getX(), 2) + Math.pow((this.y - y.getY()), 2));
    }

    public static void main(String[] argv) {
        Points p1 = new Points(1, 2);
        Points p2 = new Points(1, 4);
        System.out.println(p2.distance(p1));
    }
}
