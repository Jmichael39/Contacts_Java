/**
    Represents inclusive integer range.
*/
class Range implements Serializable {

	private static final long serialVersionUID = 1L;

	/** @serial */
	private final int from;
	/** @serial */
	private final int to;

	private void readObject(ObjectInputStream ois) throws Exception {
		ois.defaultReadObject();
		if (from > to) {
			throw new IllegalArgumentException("Start is greater than end");
		}
	}

	/**
	 * Creates Range.
	 * 
	 * @param from start 
	 * @param to end
	 * @throws IllegalArgumentException if start is greater than end. 
	 */
	public Range(int from, int to) {
		if (from > to) {
			throw new IllegalArgumentException("Start is greater than end");
		}
		this.from = from;
		this.to = to;
	}

	public int getFrom() {
		return from;
	}

	public int getTo() {
		return to;
	}

}