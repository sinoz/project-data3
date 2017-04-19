package data_science.model;

/**
 * TODO
 * @author I.A
 */
public final class TheftTimestamp {
	/**
	 * The amount of times thefts have been committed on this timestamp.
	 */
	private final int count;

	/**
	 * The timestamp.
	 */
	private final String timestamp;

	/**
	 * Creates a new {@link TheftTimestamp}.
	 */
	public TheftTimestamp(int count, String timestamp) {
		this.count = count;
		this.timestamp = timestamp;
	}

	public int getCount() {
		return count;
	}

	public String getTimestamp() {
		return timestamp;
	}
}
