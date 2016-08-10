package main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.exceptions.SwipeInException;
import main.model.Card;
import main.model.DaysEnum;
import main.model.FairCalcDM;
import main.model.Station;
import main.model.Travel;
import main.services.ServiceIntf;
import main.services.impl.CalcService;

public class TravelController {

	private List<Card> cardList;
	private List<Station> stationList;
	private List<Travel> travelList;
	private Map<Card,Travel> currentTravelsMap;
	private DaysEnum day;
	private ServiceIntf<Double, FairCalcDM> service; 

	public TravelController() {
		cardList = new ArrayList<>();
		stationList = new ArrayList<>();
		travelList = new ArrayList<>();
		currentTravelsMap = new HashMap<>();
		service = CalcService.getCalcService();
	}

	public TravelController(DaysEnum day) {
		this();
		this.day = day;
	}

	public void swipeIn(Card card, Station fromStation) {
		if (card.getBalance() < 50) {
			SwipeInException exc = new SwipeInException.Builder().withCard(card).withStation(fromStation).build();
			throw exc;
		}
		Travel travel = new Travel(card, fromStation);
		travelList.add(travel);
		currentTravelsMap.put(card, travel);
	}
	
	public void swipeOut(Card card, Station toStation) {
		
		Travel travel = currentTravelsMap.get(card);
		FairCalcDM inputDm = new FairCalcDM.Builder().withCard(card).withFromStation(travel.getFromStation()).withToStation(toStation).withDay(day).build();
		double fare = service.execute(inputDm);
		travel.setFare(fare);
		card.setBalance(card.getBalance() - fare);
		currentTravelsMap.remove(card);
	}

	
	public void addCard(Card card) {
		this.cardList.add(card);
	}

	public void addStation(Station station) {
		this.stationList.add(station);
	}

	public void addTravel(Travel travel) {
		this.travelList.add(travel);
	}

	public List<Card> getCardList() {
		return cardList;
	}

	public void setCardList(List<Card> cardList) {
		this.cardList = cardList;
	}

	public List<Station> getStationList() {
		return stationList;
	}

	public void setStationList(List<Station> stationList) {
		this.stationList = stationList;
	}

	public List<Travel> getTravelList() {
		return travelList;
	}

	public void setTravelList(List<Travel> travelList) {
		this.travelList = travelList;
	}

	public DaysEnum getDay() {
		return day;
	}

	public void setDay(DaysEnum day) {
		this.day = day;
	}

}
