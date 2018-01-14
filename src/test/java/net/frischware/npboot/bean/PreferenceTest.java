package net.frischware.npboot.bean;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
public class PreferenceTest {

	@Test
	public void generateTestdata() throws JsonProcessingException {
		Preference pref = new Preference();
		pref.setAccountNr(2l);
		pref.setAddress("myAddress");
		pref.setChannel("myChannel");
		pref.setChannelName("myChannelName");
		pref.setChannelType("myChannelType");
		pref.setCustomerNr(1l);
		pref.setCreated(Date.valueOf("2000-11-01"));
		pref.setEnabled(Boolean.TRUE);
		pref.setFunctionalId("myFuncId");
		pref.setPartnerNr(3l);
		
		ObjectMapper converter = new ObjectMapper();
		System.out.println(converter.writeValueAsString(pref));
		
		// {"functionalId":"myFuncId","customerNr":1,"partnerNr":3,"accountNr":2,"channel":"myChannel","enabled":true,"address":"myAddress","channelName":"myChannelName","channelType":"myChannelType","created":"2000-11-01"}

	}
	
}
