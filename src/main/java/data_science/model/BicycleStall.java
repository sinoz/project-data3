package data_science.model;

/**
 * A single bicycle stall.
 * @author I.A
 */
public final class BicycleStall {
	/**
	 * The street name the stall is located at.
	 */
	private final String name;

	/**
	 * The name of the area of the stall.
	 */
	private final String area;

	/**
	 * The coordinates of the stall on the map.
	 */
	private final float latitude, longitude;

	/**
	 * Creates a new {@link BicycleStall}.
	 */
	public BicycleStall(String name, String area, float latitude, float longitude) {
		this.name = name;
		this.area = area;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public String getArea() {
		return area;
	}

	public float getLatitude() {
		return latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "BicycleStall(" + name + ", " + latitude + ", " + longitude + ")";
	}
}
