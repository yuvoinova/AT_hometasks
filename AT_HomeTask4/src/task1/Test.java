package task1;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		double rectangleLenght, rectangleBreadth, squareSide, circleRadius;
		Scanner scan = new Scanner(System.in);
		Area area = new Area();

		do {
			rectangleLenght = utils.Utils.scanDouble(scan,
					"Enter a length of a rectangle. It has to be a number greater than 0", "length=");
		} while (rectangleLenght <= 0);
		do {
			rectangleBreadth = utils.Utils.scanDouble(scan,
					"Enter a breadth of a rectangle. It has to be a number greater than 0", "breadth=");
		} while (rectangleBreadth <= 0);
		System.out.println(
				"Rectangle area is " + utils.Utils.doubleView(area.rectangleArea(rectangleLenght, rectangleBreadth)));

		do {
			squareSide = utils.Utils.scanDouble(scan, "Enter a side of a square. It has to be a number greater than 0",
					"side=");
		} while (squareSide <= 0);
		System.out.println("Square area is " + utils.Utils.doubleView(area.squareArea(squareSide)));

		do {
			circleRadius = utils.Utils.scanDouble(scan,
					"Enter a radius of a circle. It has to be a number greater than 0", "radius=");
		} while (circleRadius <= 0);
		System.out.println("Circle area is " + utils.Utils.doubleView(area.circleArea(circleRadius)));
	}

}
