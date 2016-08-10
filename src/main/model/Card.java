package main.model;

public class Card {

	private final long cardNo;
	private double balance;

	public Card(long cardNo, double balance) {
		this.cardNo = cardNo;
		this.balance = balance;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public long getCardNo() {
		return cardNo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Card))
			return false;
		Card rhs = (Card) obj;
		return this.cardNo == rhs.getCardNo();
	}

	@Override
	public int hashCode() {
		return Long.valueOf(cardNo).hashCode(); // converting long to int
												// hashcode
	}

	@Override
	public String toString() {
		return "Card no. " + cardNo;
	}

}
