package data_science.model;

/**
 * A single category with its corresponding theft count.
 * @author I.A
 */
public final class TheftCategory {
	/**
	 * The name of the category.
	 */
	private final String name;

	/**
	 * The theft count.
	 */
	private final int count;

	/**
	 * Creates a new theft category.
	 */
	public TheftCategory(String name, int count) {
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	@Override
	public String toString() {
		return "TheftCategory(" + name + ", " + count + ")";
	}
}
