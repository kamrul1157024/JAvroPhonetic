package com.omicronlab.avro.autocorrect.trie;

import com.omicronlab.avro.autocorrect.AutoCorrectLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AutoCorrectTrieTest {

    AutoCorrectTrie trie;

    @BeforeAll
    void setUp() throws Exception {
        trie=AutoCorrectTrie.getInstance();
        AutoCorrectLoader autoCorrectLoader=new AutoCorrectLoader();
        trie.setAutoCorrectLoader(autoCorrectLoader);
    }

    @Test
    void checkInstance()
    {
        assertEquals(AutoCorrectTrie.class,trie.getClass());
    }

    @Test
    void shouldNotBeCloneable()
    {
        assertThrows(Exception.class,()->trie.clone());
    }

    @Test
    void trieReplacementChecking()
    {
        assertEquals("erOplen",trie.getReplacement("aeroplane"));
    }

}