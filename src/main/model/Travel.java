package main.model;

public class Travel {

	private final Card card;
	private final Station fromStation;
	private Station toStation;
	private double fare;
	private boolean isCompleted;

	public Travel(Card card, Station fromStation) {
		this.card = card;
		this.fromStation = fromStation;
	}

	public Station getToStation() {
		return toStation;
	}

	public void setToStation(Station toStation) {
		this.toStation = toStation;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
		this.isCompleted = true; // trip is completed if the fare has been computed succesfully
	}

	public boolean isCompleted() {
		return isCompleted;
	}

	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}

	public Card getCard() {
		return card;
	}

	public Station getFromStation() {
		return fromStation;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Card = ");
		sb.append(card.getCardNo());
		sb.append(", fromStation = ");
		sb.append(fromStation.getName());
		sb.append(", toStation = ");
		sb.append(toStation.getName());
		return super.toString();
	}

}
