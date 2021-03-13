package com.omicronlab.avro;

import junit.framework.TestCase;

public class PhoneticXmlLoaderTest extends TestCase {

    public void testGetData() throws Exception {
        PhoneticLoader phoneticLoader=new PhoneticXmlLoader();
        phoneticLoader
                .getData()
                .getPatterns()
                .forEach(System.out::println);
    }
}