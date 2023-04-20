package it.pagopa.pn.radd.bff.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MaskDataUtilsTest {
	/**
	 * Method under test: {@link MaskDataUtils#maskInfo(String)}
	 */
	@Test
	void testMaskInfo () {
		// Arrange, Act and Assert
		assertEquals("Data", MaskDataUtils.maskInfo("Data"));
		assertEquals("recipientTaxId=*", MaskDataUtils.maskInfo("recipientTaxId=U"));
		assertNull(MaskDataUtils.maskInfo(null));
		assertEquals("recipientTaxId=U*************d=U", MaskDataUtils.maskInfo("recipientTaxId=UrecipientTaxId=U"));
		assertEquals("recipientTaxId=*", MaskDataUtils.maskInfo("recipientTaxId=U,"));
		assertEquals("recipientTaxId=*@recipientTaxId=U", MaskDataUtils.maskInfo("recipientTaxId=U@recipientTaxId=U"));
	}

	/**
	 * Method under test: {@link MaskDataUtils#maskString(String)}
	 */
	@Test
	void testMaskString () {
		// Arrange, Act and Assert
		assertEquals("S****ext", MaskDataUtils.maskString("Str Text"));
		assertEquals("", MaskDataUtils.maskString(""));
		assertEquals("4*", MaskDataUtils.maskString("42"));
		assertEquals("*", MaskDataUtils.maskString(","));
	}
}

