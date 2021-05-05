package com.travel;

import org.testng.annotations.Test;

import com.base.Base;
import com.base.Driver;
import com.pages.HomePage;
import com.pages.ReservePage;

public class FlightsTest extends Base {
	@Test
	public void purchageFlight() {
		Driver.initDriver("chrome");
		openUrl();
		String id = new HomePage().clickDestinationLink().clickWorldLink().setDepartureCity("Rome")
				.setDestinationCity("Dublin").clickFindFlights().chooseThisFlight(new ReservePage().getMinimumPrice())
				.clickPurchaseFlightBtn().getPaymentId();
		System.out.println(id);
		tearDown();
	}
}
