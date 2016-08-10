package main.exceptions;

import main.model.Card;
import main.model.Station;

public class SwipeOutException extends RuntimeException {

	private static final long serialVersionUID = 4849584525157479310L;
	private final Card card;
	private final Station station;
	private final Double fare;

	public SwipeOutException(Builder builder) {
		this.card = builder.card;
		this.station = builder.station;
		this.fare = builder.fare;
	}

	public static class Builder {
		private Card card;
		private Station station;
		private Double fare;

		public Builder withCard(Card card) {
			this.card = card;
			return this;
		}

		public Builder withStation(Station station) {
			this.station = station;
			return this;
		}

		public Builder withFare(Double fare) {
			this.fare = fare;
			return this;
		}
		
		public SwipeOutException build() {
			return new SwipeOutException(this);
		}
	}

	public Card getCard() {
		return card;
	}

	public Station getStation() {
		return station;
	}

	public Double getFare() {
		return fare;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Swipe out exception at station ");
		sb.append(station.getName());
		sb.append(" for card no. ");
		sb.append(card.getCardNo());
		sb.append(" as the balance : ");
		sb.append(card.getBalance());
		sb.append(" is less than the fare : ");
		sb.append(fare);
		return sb.toString();
	}

}
