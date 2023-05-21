package edu.towson.cis.cosc442.project2.rectangle;

/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The p2. */
	private Point p1, p2;
	
	/**
	 * Instantiates a new rectangle.
	 *	@param x1 The x coordinate of the first point.
	 *	@param y1 The y coordinate of the first point.
	 *	@param x2 The x coordinate of the second point.
	 *	@param y2 The y coordinate of the second point.
	 */
	Rectangle(double x1, double y1, double x2, double y2) {
		this.p1 = new Point(x1, y1);
		this.p2 = new Point(x2, y2);
	}
	
	/**
	 * Gets the area.
	 *
	 * @return the area
	 */
	public Double getArea() {
		return Math.abs((p2.x - p1.x) * (p2.y - p1.y));
	}
	
	/**
	 * Gets the diagonal.
	 *
	 * @return the diagonal
	 */
	public Double getDiagonal() {
		return Math.sqrt(Math.pow((p2.x - p1.x), 2) + Math.pow((p2.y - p1.y), 2));
	}
}
