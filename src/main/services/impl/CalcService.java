package main.services.impl;

import main.exceptions.SwipeOutException;
import main.model.DaysEnum;
import main.model.FairCalcDM;
import main.services.ServiceIntf;

public class CalcService implements ServiceIntf<Double, FairCalcDM> {

	private CalcService() {
	}

	private static CalcService service = new CalcService();

	public static CalcService getCalcService() {
		return service;
	}

	@Override
	public Double execute(FairCalcDM inputDm) {
		double fare = 0;

		if ((inputDm.getDay() == DaysEnum.SAT) || (inputDm.getDay() == DaysEnum.SUN)) {
			fare = 5.5;
		} else {
			fare = 7;
		}

		int stationsTravelled = Math.abs(inputDm.getFromStation().getIndex() - inputDm.getToStation().getIndex());
		fare *= stationsTravelled;
		if (inputDm.getCard().getBalance() < fare) {
			throw new SwipeOutException.Builder().withCard(inputDm.getCard()).withFare(fare).build();
		}
		return fare;
	}
}
