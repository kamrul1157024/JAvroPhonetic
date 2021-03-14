package com.omicronlab.avro.autocorrect;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutoCorrectLoaderTest {

    @Test
    void getJsonDictTest() {
        AutoCorrectLoader autoCorrectLoader= new AutoCorrectLoader();
        JSONObject jsonDict= autoCorrectLoader.getJsonDict();
        assertEquals("poScim`bongo",jsonDict.get("poScimbongo"));
    }
}