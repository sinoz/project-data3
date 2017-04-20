package data_science.model;

/**
 * Describes the amount of thefts that have been committed from a {@link BicycleStall}.
 * @author I.A
 */
public final class StallTheft {
	/**
	 * The {@link BicycleStall} that was stolen from.
	 */
	private final BicycleStall stall;

	/**
	 * The amount of times this stall was stolen from.
	 */
	private final int theftCount;

	/**
	 * Creates a new {@link StallTheft}.
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

	@Override
	public String toString() {
		return "StallTheft(" + stall + ", " + theftCount + ")";
	}
}
