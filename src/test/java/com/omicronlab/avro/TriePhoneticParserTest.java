package com.omicronlab.avro;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TriePhoneticParserTest {

    TriePhoneticParser avro;

    @Before
    public void init()
    {
        avro=TriePhoneticParser.getInstance();
        avro.setLoader(new PhoneticXmlLoader());
    }

    // Test Functions
    @Test
    public void testSentances() {
        //Goal: Test Sentence conversion
        long startTime = System.nanoTime();
        assertEquals(
                "আমি বাংলায় গান গাই",
                avro.parse("ami banglay gan gai")
        );
        assertEquals(
                "আমাদের ভালোবাসা হয়ে গেল ঘাস, খেয়ে গেল গরু আর দিয়ে গেল বাঁশ",
                avro.parse("amader valObasa hoye gel ghas, kheye gel goru ar diye gelo ba^sh")
        );
        avro.parse(LargeText.text);
        long stopTime = System.nanoTime();
        long executionTime=(stopTime - startTime);
        System.out.println(executionTime/Math.pow(10,9)+"seconds");
    }

    @Test
    public void testRandomChars() {
        //Goal: Test punctuation and other Unicode character (including Bangla)
        assertEquals("!", avro.parse("!"));
    }
}