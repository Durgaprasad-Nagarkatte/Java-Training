package com.java.exceptions;

public class APIParser {
    public static int parseSendResponseCode(String response, String data, String partner) throws APIFormatChangeException {
        int responseCode = -1;
        try {
            String startTag = "<code>";
            String endTag = "</code>";
            if (response.contains(startTag)) {
                int beginIndex = response.indexOf(startTag) + startTag.length();
                int endIndex = response.indexOf(endTag);
                System.out.println("code: " + response.substring(beginIndex, endIndex));
                responseCode = Integer.parseInt(response.substring(beginIndex, endIndex));
            }
        } catch (NumberFormatException e) {
            // Exception translation throw chaining
            // In case if the throwable constructor is not present
            APIFormatChangeException e1 = new APIFormatChangeException(response, data, partner);
            e1.initCause(e);
            throw e1;
            //throw new APIFormatChangeException(response , data , partner , e);
        }

        return responseCode;
    }
}
