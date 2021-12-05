package com.ctm.vessel.tracker.system.rest.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import com.ctm.vessel.tracker.system.rest.service.RestService;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class TrackerTests {
	
	@Mock
	private RestService restService;
	
    @Test
    public void testDouble() {
    	Mockito.when(restService.formatDouble(Mockito.anyDouble())).thenCallRealMethod();
    	double input = 55.123456789;
    	double expected = 55.12346; //after rounding
    	System.out.println("Expected: " + expected + " Input:" +  restService.formatDouble(input));
    	assertEquals(expected, restService.formatDouble(input));
    }
}
