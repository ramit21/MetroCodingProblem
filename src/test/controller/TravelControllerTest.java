package test.controller;

import junit.framework.Assert;
import main.controller.TravelController;
import main.exceptions.SwipeInException;
import main.exceptions.SwipeOutException;
import main.model.Card;
import main.model.DaysEnum;
import main.model.Station;

import org.junit.Before;
import org.junit.Test;

public class TravelControllerTest {

	private TravelController controller;
	private Card card1;
	private Card card2;
	private Card card3;
	private Card card4;

	private Station station1;
	private Station station2;
	private Station station3;
	private Station station4;
	private Station station5;
	private Station station6;
	private Station station7;
	private Station station8;
	private Station station9;
	private Station station10;

	@Before
	public void setup() {
		controller = new TravelController(DaysEnum.FRI);

		card1 = new Card(1111, 100);
		card2 = new Card(2222, 40);
		card3 = new Card(3333, 51);
		card4 = new Card(4444, 300);

		controller.addCard(card1);
		controller.addCard(card2);
		controller.addCard(card3);
		controller.addCard(card4);

		station1 = new Station.Builder().withName("A1").withIndex(1).build();
		station2 = new Station.Builder().withName("A2").withIndex(2).build();
		station3 = new Station.Builder().withName("A3").withIndex(3).build();
		station4 = new Station.Builder().withName("A4").withIndex(4).build();
		station5 = new Station.Builder().withName("A5").withIndex(5).build();
		station6 = new Station.Builder().withName("A6").withIndex(6).build();
		station7 = new Station.Builder().withName("A7").withIndex(7).build();
		station8 = new Station.Builder().withName("A8").withIndex(8).build();
		station9 = new Station.Builder().withName("A9").withIndex(9).build();
		station10 = new Station.Builder().withName("A10").withIndex(10).build();

		controller.addStation(station1);
		controller.addStation(station2);
		controller.addStation(station3);
		controller.addStation(station4);
		controller.addStation(station5);
		controller.addStation(station6);
		controller.addStation(station7);
		controller.addStation(station8);
		controller.addStation(station9);
		controller.addStation(station10);

	}

	@Test
	public void testSwipeIn() {
		controller.swipeIn(card1, station1);
		Assert.assertEquals(controller.getTravelList().size(), 1);
	}
	
	@Test(expected=SwipeInException.class)
	public void testSwipeInLessBalance() {
		controller.swipeIn(card2, station2);
	}
	
	@Test 
	public void testFareCalcOnWeekDay(){
		controller.swipeIn(card1, station4);
		controller.swipeOut(card1, station1);
		Assert.assertEquals(card1.getBalance(), 79.0);
	}
	
	@Test 
	public void testFareCalcOnWeekEnd(){
		controller.setDay(DaysEnum.SUN);
		controller.swipeIn(card1, station4);
		controller.swipeOut(card1, station1);
		Assert.assertEquals(card1.getBalance(), 83.5);
	}
	
	@Test(expected=SwipeOutException.class)
	public void testSwipeOutLessBalance() {
		controller.swipeIn(card3, station2);
		controller.swipeOut(card3, station10);
	}
	
}
