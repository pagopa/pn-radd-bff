package it.pagopa.pn.radd.bff.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaskDataUtils {

    private static final Pattern URI_TAX_ID_1 = Pattern.compile("(recipientTaxId)=([^&]*)");
    private static final Pattern URI_TAX_ID_2 = Pattern.compile("(/by-internalId/)([^-]{2}(?!-).*)");
    private static final Pattern URI_DATA_VAULT = Pattern.compile("(/internal\\?internalId)=(.*)");
    private static final Pattern DATA_VAULT_JSON_RESPONSE_1 = Pattern.compile("(\"taxId\"\\s*:\\s*\")(.*?)(\")");
    private static final Pattern DATA_VAULT_JSON_RESPONSE_2 = Pattern.compile("(\"internalId\"\\s*:\\s*\")(.*?)(\")");
    private static final Pattern DATA_VAULT_ANONYMIZATION_TAX_ID = Pattern.compile("(^)(^(?!\\{|PG-|PF-).*)");
    private static final Pattern BODY_TAX_ID = Pattern.compile("(\"recipientTaxId\"|\"delegateTaxId\")\\s*:\\s*\"(.*?)\"");

    public static String maskUri (String data) {
        if (data == null) {
            return null;
        }
        data = maskMatcher(URI_TAX_ID_2, data);
        data = maskMatcher(URI_TAX_ID_1, data);
        data = maskMatcher(URI_DATA_VAULT, data);

        return data;
    }
    public static String maskBody(String data) {
        if (data == null) {
            return null;
        }
        data = maskMatcher(DATA_VAULT_ANONYMIZATION_TAX_ID, data);
        data = maskMatcher(BODY_TAX_ID, data);
        data = maskMatcher(DATA_VAULT_JSON_RESPONSE_1, data);
        data = maskMatcher(DATA_VAULT_JSON_RESPONSE_2, data);

        return data;
    }

    private static String maskMatcher(Pattern pattern, String dataBuffered) {
        Matcher matcher = pattern.matcher(dataBuffered);
        while (matcher.find()) {
            String toBeMasked = matcher.group(2);
            String valueMasked = mask(toBeMasked);
            if (!toBeMasked.isBlank()) {
                dataBuffered = dataBuffered.replace(toBeMasked, valueMasked);
            }
        }
        return dataBuffered;
    }

    private static String mask(String unmasked) {
        return maskString(unmasked);
    }

    public static String maskString(String strText) {
        int start = 1;
        int end = strText.length() - 3;
        String maskChar = String.valueOf('*');

        if (strText.equals("")) {
            return "";
        }
        if (strText.length() < 4) {
            end = strText.length();
        }
        int maskLength = end - start;
        if (maskLength == 0) {
            return maskChar;
        }
        String sbMaskString = maskChar.repeat(Math.max(0, maskLength));
        return strText.substring(0, start) + sbMaskString + strText.substring(start + maskLength);
    }
}
