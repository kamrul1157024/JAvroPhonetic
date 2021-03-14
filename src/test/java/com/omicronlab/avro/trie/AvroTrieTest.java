package com.omicronlab.avro.trie;

import com.omicronlab.avro.PhoneticLoader;
import com.omicronlab.avro.PhoneticXmlLoader;
import com.omicronlab.avro.phonetic.Pattern;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AvroTrieTest {

    PhoneticLoader phoneticLoader;
    AvroTrie avroTrie;
    List<Pattern> patterns;
    @BeforeAll
    public void init() throws Exception {
        phoneticLoader=new PhoneticXmlLoader();
        avroTrie=AvroTrie.getInstance();
        avroTrie.setPhoneticLoader(phoneticLoader);
        patterns=phoneticLoader.getData().getPatterns();
    }

    @Test
    public void trieTest() {
        avroTrie.insert("abc",10000);
        System.out.println("Testing");
        assertEquals(true,avroTrie.find("abc"));
    }

    @Test
    public void allPatternTest() throws Exception
    {

        for(int i=0;i<patterns.size();i++)
        {
            Pattern pattern= patterns.get(i);
            assertEquals(pattern.getReplace(),
                    patterns.get(avroTrie.getPatternPos(pattern.getFind())).getReplace());
        }
    }


}