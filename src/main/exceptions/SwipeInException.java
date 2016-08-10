package main.exceptions;

import main.model.Card;
import main.model.Station;

public class SwipeInException extends RuntimeException {

	private static final long serialVersionUID = -5724037790889811560L;
	private final Card card;
	private final Station station;

	public SwipeInException(Builder builder) {
		this.card = builder.card;
		this.station = builder.station;
	}

	public static class Builder { // remember to keep this static
		private Card card;
		private Station station;

		public Builder withCard(Card card) {
			this.card = card;
			return this;
		}

		public Builder withStation(Station station) {
			this.station = station;
			return this;
		}

		public SwipeInException build() {
			return new SwipeInException(this);
		}
	}

	public Card getCard() {
		return card;
	}

	public Station getStation() {
		return station;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Swipe in exception at station ");
		sb.append(station.getName());
		sb.append(" for card no. ");
		sb.append(card.getCardNo());
		sb.append(" as the balance : ");
		sb.append(card.getBalance());
		sb.append(" is less than Rs. 50");
		return sb.toString();
	}

}
