package it.pagopa.pn.radd.bff.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class MaskDataUtilsTest {
	/**
	 * Method under test: {@link MaskDataUtils#maskUri(String)}
	 */
	@Test
	void testMaskUri () {
		// Arrange, Act and Assert
		assertEquals("Data", MaskDataUtils.maskUri("Data"));
		assertEquals("/by-internalId/U**", MaskDataUtils.maskUri("/by-internalId/UUU"));
		assertEquals("recipientTaxId=*", MaskDataUtils.maskUri("recipientTaxId=U"));
		assertNull(MaskDataUtils.maskUri(null));
		assertEquals("/by-internalId/U*****************UUU",
				MaskDataUtils.maskUri("/by-internalId/UUU/by-internalId/UUU"));
	}

	/**
	 * Method under test: {@link MaskDataUtils#maskBody(String)}
	 */
	@Test
	void testMaskBody () {
		// Arrange, Act and Assert
		assertEquals("*", MaskDataUtils.maskBody("Data"));
		assertEquals("*", MaskDataUtils.maskBody("U"));
		assertEquals("\"*******************UU\"", MaskDataUtils.maskBody("\"recipientTaxId\" : \"UU\""));
		assertEquals("", MaskDataUtils.maskBody(""));
		assertNull(MaskDataUtils.maskBody(null));
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
		assertEquals("*", MaskDataUtils.maskString("4242"));
	}
}

