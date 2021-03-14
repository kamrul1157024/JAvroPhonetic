package com.omicronlab.avro;


import org.junit.jupiter.api.Test;

public class PhoneticXmlLoaderTest  {

    @Test
    public void testGetData() throws Exception {
        PhoneticLoader phoneticLoader=new PhoneticXmlLoader();
        phoneticLoader
                .getData()
                .getPatterns()
                .forEach(System.out::println);
    }
}