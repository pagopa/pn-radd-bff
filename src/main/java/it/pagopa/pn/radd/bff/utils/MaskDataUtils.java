package it.pagopa.pn.radd.bff.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaskDataUtils {

    private static final Pattern URI_TAX_ID = Pattern.compile("(recipientTaxId)=([^&]*)");
    private static final Pattern TAX_ID = Pattern.compile("(recipientTaxId)\\s*:\\s*([A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z])");
    private static final Pattern CF_PATTERN = Pattern.compile("/[A-Z]{6}\\d{2}[A-Z]\\d{2}[A-Z]\\d{3}[A-Z]/");

    public static String maskData(String data) {
        if (data == null) {
            return null;
        }
        data = maskMatcher(TAX_ID, data);
        data = maskMatcher(URI_TAX_ID, data);

        return data;
    }
    public static String maskInfo(String data) {
        if (data == null) {
            return null;
        }

        data = maskMatcher(TAX_ID, data);

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
        if (unmasked.contains(",")) {
            return maskAddress(unmasked);
        } else if (unmasked.contains("@")) {
            return maskEmailAddress(unmasked);
        } else {
            return maskString(unmasked);
        }
    }

    private static String maskAddress(String strAddress) {
        String[] parts = strAddress.split(",");
        StringBuilder masked = new StringBuilder();
        for (String part : parts) {
            masked.append(maskString(part)).append(",");
        }
        return masked.substring(0, masked.length() - 1);
    }

    private static String maskEmailAddress(String strEmail) {
        String[] parts = strEmail.split("@");
        String strId = maskString(parts[0]);
        return strId + "@" + parts[1];
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
