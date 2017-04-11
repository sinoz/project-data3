package data_science.model;

import com.lynden.gmapsfx.javascript.object.LatLong;

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
	private final LatLong coordinates;

	/**
	 * Creates a new {@link BicycleStall}.
	 */
	public BicycleStall(String name, LatLong coordinates) {
		this.name = name;
		this.coordinates = coordinates;
	}

	public String getName() {
		return name;
	}

	public LatLong getCoordinates() {
		return coordinates;
	}

	@Override
	public String toString() {
		return "BicycleStall(" + name + ", " + coordinates + ")";
	}
}
