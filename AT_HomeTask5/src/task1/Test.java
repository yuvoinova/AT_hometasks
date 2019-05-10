package task1;

import java.util.Scanner;

import utils.Utils;

public class Test {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		double x1 = Utils.scanDouble(scan, "Enter x1. It has to be a real number", "x1=");
		double y1 = Utils.scanDouble(scan, "Enter y1. It has to be a real number", "y1=");
		double x2 = Utils.scanDouble(scan, "Enter x2. It has to be a real number", "x2=");
		double y2 = Utils.scanDouble(scan, "Enter y2. It has to be a real number", "y2=");
		double x3 = Utils.scanDouble(scan, "Enter x3. It has to be a real number", "x3=");
		double y3 = Utils.scanDouble(scan, "Enter y3. It has to be a real number", "y3=");
		if (scan != null) {
			scan.close();
		}

		Triangle t1 = new Triangle(x1, y1, x2, y2, x3, y3);
		System.out.println(t1);
		try {
			System.out.println("area=" + Utils.doubleView(t1.calculateArea()));
		} catch (TriangleIsSelfIntersectingException e) {
			System.out.println("Exception! The triangle is self-intersecting");
		}
	}

}
