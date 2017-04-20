package data_science.model;

/**
 * TODO
 * @author Whis
 */
public final class StallTheft {
	/**
	 * TODO
	 */
	private final BicycleStall stall;

	/**
	 * The amount of times this stall was stolen from.
	 */
	private final int theftCount;

	/**
	 * TODO
	 */
	public StallTheft(BicycleStall stall, int theftCount) {
		this.stall = stall;
		this.theftCount = theftCount;
	}

	public BicycleStall getStall() {
		return stall;
	}

	public int getTheftCount() {
		return theftCount;
	}
}
