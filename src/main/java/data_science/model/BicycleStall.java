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
	 * The coordinates of the stall on the map.
	 */
	private final float latitude, longitude;

	/**
	 * Creates a new {@link BicycleStall}.
	 */
	public BicycleStall(String name, float latitude, float longitude) {
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public String getName() {
		return name;
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
