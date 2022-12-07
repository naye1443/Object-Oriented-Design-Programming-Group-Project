package UnitTesting.TestingDataTypes;

import DataTypes.CustomerAccount;
import DataTypes.IAccount;
import DataTypes.User;
import Model.NozamaSystem;
import ReadWrite.Json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

	private String userID, username, password, accountType;
	private IAccount account;
	User TestUser;

	@BeforeEach
	void setUp() {
		this.userID = "000";
		this.username = "username";
		this.password = "password";
		this.accountType = "customer";

		this.TestUser = new User("000", "username","password", "customer");

		if (accountType.equals("customer"))
			account = new CustomerAccount(TestUser);
		else if (accountType.equals("seller"))
			account = NozamaSystem.getInstance().getSeller(this.username);
	}

	@AfterEach
	void tearDown() {
	}

	@Test
	void toJSONObject() {
		JSONObject data = new JSONObject();
		data.put("username", String.valueOf(this.username));
		data.put("password", String.valueOf(this.password));
		data.put("accountType", String.valueOf(this.accountType));

		JSONObject header = new JSONObject();
		header.put(this.userID, data);

		JSONObject ExpectedJSONObject = header;
		System.out.println(ExpectedJSONObject);
		System.out.println(TestUser.toJSONObject());

		assertEquals(ExpectedJSONObject, TestUser.toJSONObject());
	}

	@Test
	void testToString() {
		String TestString = "DataTypes.User{" +
		"userID='" + "000" + '\'' +
		", username='" + "username" + '\'' +
		", password='" + "password" + '\'' +
		", accountType='" + "customer" + '\'' + '}';
		assertEquals(TestString, TestUser.toString());
	}

	@Test
	void getUsername() {
		assertEquals(this.username, TestUser.getUsername());
	}

	@Test
	void getPassword() {
		assertEquals(this.password, TestUser.getPassword());
	}
	// Test if accounts are equal to eachother
	@Test
	void getAccount() {
		assertEquals(this.account.equals(TestUser.getAccount()), TestUser.getAccount().equals(this.account));
	}
}