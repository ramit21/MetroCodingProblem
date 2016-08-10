package main.model;

public class Station {

	private final String name;
	private final int index;

	private Station(Builder builder) {
		name = builder.name;
		index = builder.index;
	}

	public static class Builder {

		private String name;
		private int index;

		public Builder withName(String name) {
			this.name = name;
			return this;
		}

		public Builder withIndex(int index) {
			this.index = index;
			return this;
		}

		public Station build() {
			return new Station(this);
		}
	}

	public String getName() {
		return name;
	}

	public int getIndex() {
		return index;
	}

	@Override
	public String toString() {
		return "Station: " + name;
	}
}
