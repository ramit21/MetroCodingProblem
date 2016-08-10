package main.model;

public class FairCalcDM {

	private final Card card;
	private final Station fromStation;
	private final Station toStation;
	private final DaysEnum day;

	private FairCalcDM(Builder builder) {
		this.card = builder.card;
		this.fromStation = builder.fromStation;
		this.toStation = builder.toStation;
		this.day = builder.day;
	}

	public static class Builder {

		private Card card;
		private Station fromStation;
		private Station toStation;
		private DaysEnum day;

		public Builder withCard(Card card) {
			this.card = card;
			return this;
		}

		public Builder withFromStation(Station fromStation) {
			this.fromStation = fromStation;
			return this;
		}

		public Builder withToStation(Station toStation) {
			this.toStation = toStation;
			return this;
		}

		public Builder withDay(DaysEnum day) {
			this.day = day;
			return this;
		}

		public FairCalcDM build() {
			return new FairCalcDM(this);
		}
	}

	public Card getCard() {
		return card;
	}

	public Station getFromStation() {
		return fromStation;
	}

	public Station getToStation() {
		return toStation;
	}

	public DaysEnum getDay() {
		return day;
	}

}
