package _04_class_and_obj_oop.bai_tap;

import java.util.Scanner;

public class QuadraticEquations {
    double a;
    double b;
    double c;

    public QuadraticEquations() {
    }

    public QuadraticEquations(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDelta() {
        double delta;
        return delta = this.b * 2 - 4 * this.a * this.c;
    }

    public double getRoot1() {
        double root1;
        return root1 = (-this.b + Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / 2 * this.a;
    }

    public double getRoot2() {
        double root2;
        return root2 = (-this.b - Math.sqrt(this.b * this.b - 4 * this.a * this.c)) / 2 * this.a;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a");
        double a = input.nextDouble();
        System.out.println("Please enter a");
        double b = input.nextDouble();
        System.out.println("Please enter a");
        double c = input.nextDouble();
        QuadraticEquations quadraticEquations = new QuadraticEquations(a, b, c);
        double delta = quadraticEquations.getDelta();
        if (delta > 0) {
            System.out.println("The equations has two roots:  " + quadraticEquations.getRoot1() + "and " + quadraticEquations.getRoot2());
        } else if (delta == 0) {
            System.out.println("The equations has one root:  " + quadraticEquations.getRoot1());
        } else {
            System.out.println("The equations doesn’t have root");
        }
    }
}
