package task1;

import utils.Utils;

public class Triangle {
	private double[] vertex1 = new double[2];
	private double[] vertex2 = new double[2];
	private double[] vertex3 = new double[2];

	public double getX1() {
		return vertex1[0];
	}

	public double getY1() {
		return vertex1[1];
	}

	public void setVertex1(double x, double y) {
		vertex1[0] = x;
		vertex1[1] = y;
	}

	public double getX2() {
		return vertex2[0];
	}

	public double getY2() {
		return vertex2[1];
	}

	public void setVertex2(double x, double y) {
		vertex2[0] = x;
		vertex2[1] = y;
	}

	public double getX3() {
		return vertex3[0];
	}

	public double getY3() {
		return vertex3[1];
	}

	public void setVertex3(double x, double y) {
		vertex3[0] = x;
		vertex3[1] = y;
	}

	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		vertex1[0] = x1;
		vertex1[1] = y1;
		vertex2[0] = x2;
		vertex2[1] = y2;
		vertex3[0] = x3;
		vertex3[1] = y3;
	}

	public String toString() {
		return "Triangle: (" + Utils.doubleView(vertex1[0]) + "," + Utils.doubleView(vertex1[1]) + "); " + "("
				+ Utils.doubleView(vertex2[0]) + "," + Utils.doubleView(vertex2[1]) + "); " + "("
				+ Utils.doubleView(vertex3[0]) + "," + Utils.doubleView(vertex3[1]) + ")";

	}

	private boolean triangleIsSelfIntersecting() {
		if ((vertex1[0] == vertex2[0]) && (vertex2[0] == vertex3[0])) {
			return true;
		} else if ((vertex1[1] == vertex2[1]) && (vertex2[1] == vertex3[1])) {
			return true;
		} else if ((vertex1[0] == vertex2[0]) && (vertex1[1] == vertex2[1])) {
			return true;
		} else if ((vertex1[0] == vertex3[0]) && (vertex1[1] == vertex3[1])) {
			return true;
		} else if ((vertex2[0] == vertex3[0]) && (vertex2[1] == vertex3[1])) {
			return true;
		} else {
			return false;
		}
	}

	public double calculateArea() throws TriangleIsSelfIntersectingException {
		if (triangleIsSelfIntersecting()) {
			throw new TriangleIsSelfIntersectingException();
		} else {
			return Math.abs((vertex2[0] - vertex1[0]) * (vertex3[1] - vertex1[1])
					- (vertex3[0] - vertex1[0]) * (vertex2[1] - vertex1[1])) / 2;
		}
	}

}
