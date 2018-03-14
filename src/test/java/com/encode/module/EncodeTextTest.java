package com.encode.module;

import com.encode.exception.EncodeException;
import junit.framework.TestCase;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Madhusmita on 14/03/18.
 */
public class EncodeTextTest extends TestCase {
    final private static Logger logger = LoggerFactory.getLogger(EncodeTextTest.class);

    @Test
    /*
    Test method for offset positive and negetive within range +26  to -26
     */
    public void testEncodeAlphabets(){
        try {
            Assert.assertEquals("BCDE",EncodeText.encode(1,"ABCD")); // offset 1 and all uppercase
            Assert.assertEquals("ZABC",EncodeText.encode(-1,"ABCD")); // offset -1 and all uppercase
            Assert.assertEquals("ZRcpCEyY",EncodeText.encode(-1,"ASdqDFzZ")); // offset -1 and mix uppercase,lowercase
            Assert.assertEquals("BTerEGaA",EncodeText.encode(1,"ASdqDFzZ")); // offset 1 and mix uppercase,lowercase

            Assert.assertEquals("CDEF",EncodeText.encode(2,"ABCD")); // offset 2 and all uppercase
            Assert.assertEquals("YZAB",EncodeText.encode(-2,"ABCD")); // offset -2 and all uppercase
            Assert.assertEquals("YQboBDxX",EncodeText.encode(-2,"ASdqDFzZ")); // offset -2 and mix uppercase,lowercase
            Assert.assertEquals("CUfsFHbB",EncodeText.encode(2,"ASdqDFzZ")); // offset 2 and mix uppercase,lowercase

            Assert.assertEquals("ABCD",EncodeText.encode(26,"ABCD")); // offset 26 and all uppercase
            Assert.assertEquals("ABCD",EncodeText.encode(-26,"ABCD")); // offset -26 and all uppercase
            Assert.assertEquals("ASdqDFzZ",EncodeText.encode(-26,"ASdqDFzZ")); // offset -26 and mix uppercase,lowercase
            Assert.assertEquals("ASdqDFzZ",EncodeText.encode(26,"ASdqDFzZ")); // offset 26 and mix uppercase,lowercase

            Assert.assertEquals("ZABC",EncodeText.encode(25,"ABCD")); // offset 25 and all uppercase
            Assert.assertEquals("BCDE",EncodeText.encode(-25,"ABCD")); // offset -25 and all uppercase
            Assert.assertEquals("BTerEGaA",EncodeText.encode(-25,"ASdqDFzZ")); // offset -25 and mix uppercase,lowercase
            Assert.assertEquals("ZRcpCEyY",EncodeText.encode(25,"ASdqDFzZ")); // offset 25 and mix uppercase,lowercase

            Assert.assertEquals("WXYZ",EncodeText.encode(100,"ABCD")); // offset 25 and all uppercase
            Assert.assertEquals("EFGH",EncodeText.encode(-100,"ABCD")); // offset -25 and all uppercase
            Assert.assertEquals("EWhuHJdD",EncodeText.encode(-100,"ASdqDFzZ")); // offset -25 and mix uppercase,lowercase
            Assert.assertEquals("WOzmZBvV",EncodeText.encode(100,"ASdqDFzZ")); // offset 25 and mix uppercase,lowercase
        } catch (EncodeException e) {
            logger.info(e.getMessage());
        }
    }

    @Test
    public void testEncodeAlphaNumericString(){
        try {
           EncodeText.encode(1,"AB1CD");
        } catch (EncodeException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testEncodeStringWithSpace(){
        try {
            EncodeText.encode(1,"AB CD");
        } catch (EncodeException e) {
            Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testEncodeStringWithSpecialChar(){
        try {
            EncodeText.encode(1,"AB#CD");
        } catch (EncodeException e) {
            Assert.fail(e.getMessage());
        }
    }
}
