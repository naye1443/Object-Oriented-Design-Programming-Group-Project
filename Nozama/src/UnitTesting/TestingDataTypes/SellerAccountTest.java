package UnitTesting.TestingDataTypes;

import NozamaGui.Screens.SellerDashboard;
import ReadWrite.Json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
// Test Class
import DataTypes.SellerAccount;

import static org.junit.jupiter.api.Assertions.*;

class SellerAccountTest {

	private String userName;
	private float profit, revenues, costs;
	SellerAccount TestSeller;

	@BeforeEach
	void setUp() {
		this.userName = "seller1";
		this.profit = 264.0f;
		this.revenues = 475.0f;
		this.costs = 211.0f;
		this.TestSeller = new SellerAccount("seller1",264.0f,475.0f,211.0f);
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void onLogIn() {
		// Initializes SellerDashboard view in NozamaGui.Screens
		SellerDashboard sellerDashboard = new SellerDashboard(this.TestSeller);
	}

	@Test
	void toJSONObject() {
		JSONObject data = new JSONObject();
		data.put("profit", String.valueOf(this.profit));
		data.put("revenues", String.valueOf(this.revenues));
		data.put("costs", String.valueOf(this.costs));

		JSONObject header = new JSONObject();
		header.put(this.userName, data);

		JSONObject ExpectedJSONObject = header;
		System.out.println(ExpectedJSONObject);
		System.out.println(TestSeller.toJSONObject());

		assertEquals(ExpectedJSONObject, TestSeller.toJSONObject());
	}

	@Test
	void getUserName() {
		assertEquals(this.userName,TestSeller.getUserName());
	}

	@Test
	void testToString() {
		String TestString = "SellerAccount{" +
		"userName='" + "seller1" + '\'' +
		", profit=" + 264.0f +
		", revenues=" + 475.0f +
		", costs=" + 211.0f + '}';
		assertEquals(TestString, TestSeller.toString());
	}

	@Test
	void getProfit() {
		assertEquals(this.profit, TestSeller.getProfit());
	}

	@Test
	void getRevenues() {
		assertEquals(this.revenues, TestSeller.getRevenues());
	}

	@Test
	void getCosts() {
		assertEquals(this.costs, TestSeller.getCosts());
	}

	@Test
	void testEquals() {
		assertAll("equals",() -> {assertEquals(this.userName,TestSeller.getUserName());},
				() -> {assertEquals(this.profit,TestSeller.getProfit());},
				() -> {assertEquals(this.revenues, TestSeller.getRevenues());},
				() -> {assertEquals(this.costs, TestSeller.getCosts());});
	}

	@Test
	void testHashCode() {
		SellerAccount Test2Seller = new SellerAccount("seller1",264.0f,475.0f,211.0f);
		assertEquals(Test2Seller.hashCode(), TestSeller.hashCode());
	}

	@Test
	void addToRevenues() {
		float TestVal = 10.0f;
		this.revenues = this.revenues + TestVal;
		TestSeller.addToRevenues(TestVal);
		assertEquals(this.revenues,TestSeller.getRevenues());
	}

	@Test
	void addToCosts() {
		float TestVal = 10.0f;
		this.costs = this.costs + TestVal;
		TestSeller.addToCosts(TestVal);
		assertEquals(this.costs, TestSeller.getCosts());
	}

	@Test
	void calculateProfit() {
		this.profit = this.revenues - this.costs;
		assertEquals(this.profit, TestSeller.getProfit());
	}
}