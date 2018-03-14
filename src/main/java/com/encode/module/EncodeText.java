package com.encode.module;

import com.encode.exception.EncodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Madhusmita on 14/03/18.
 * Class to encode a given text with offset.
 */
public class EncodeText {

    private static final Logger logger = LoggerFactory.getLogger(EncodeText.class);
    /*

     */
    public static String encode( int offset,String str) throws EncodeException {

        StringBuilder sb = new StringBuilder();
        char charMoveUpUpperCase = 'A';
        char charMoveUplowerCase = 'a';

        if (offset < 0){
            charMoveUpUpperCase = 'Z';
            charMoveUplowerCase = 'z';
        }
        for (char c : str.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c + offset - charMoveUpUpperCase) % 26 + charMoveUpUpperCase));
            } else if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c + offset - charMoveUplowerCase) % 26 + charMoveUplowerCase));
            } else {
                throw new EncodeException("Invalid character: " + c);
            }
        }
        logger.info("The endoded string : "+ sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        String encodeText = "ABCD";
        try {
            logger.info(encode(1,encodeText));
        } catch (EncodeException e) {
            logger.info(e.getMessage());
        }
    }

}
