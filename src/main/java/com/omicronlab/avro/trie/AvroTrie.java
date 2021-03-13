package com.omicronlab.avro.trie;


import com.omicronlab.avro.PhoneticLoader;
import com.omicronlab.avro.phonetic.Pattern;
import com.omicronlab.avro.phonetic.Rule;

import java.util.List;

public class AvroTrie {

    private TrieNode head;

    private void init(PhoneticLoader phoneticLoader) throws Exception {

        List<Pattern> patterns=phoneticLoader
                .getData()
                .getPatterns();

        for(int i=0;i<patterns.size();i++)
        {
            insert(patterns.get(i).getFind(),i);
        }

    }

    public AvroTrie(PhoneticLoader phoneticLoader) throws Exception {
        head=new TrieNode();
        init(phoneticLoader);
    }

    public void insert(String word, int patternPos)
    {
        TrieNode current=head;

        for (int i=0;i<word.length();i++)
        {
            char currentChar=word.charAt(i);
            if(current.getNextNode(currentChar)!=null)
            {
                current=current.getNextNode(currentChar);
            }
            else
            {
                TrieNode trieNode=new TrieNode(currentChar);
                current.setNextNode(currentChar,trieNode);
                current=trieNode;
            }
        }
        current.setEndPoint(true);
        current.setPatternPos(patternPos);
    }

    public boolean find(String word)
    {
        TrieNode current=head;

        for(int i=0;i<word.length();i++)
        {
            char currentChar=word.charAt(i);
            if(current.getNextNode(currentChar)==null) return false;

            current=current.getNextNode(currentChar);
        }
        return current.getEndPoint();
    }

    public int getPatternPos(String find)
    {
        TrieNode current=head;
        int lastMatchPattern=-1;
        for(int i=0;i<find.length();i++)
        {
            char currentChar=find.charAt(i);
            if(current.getNextNode(currentChar)!=null) {
                current = current.getNextNode(currentChar);
                lastMatchPattern=current.getPatternPos();
            }
            else
                return lastMatchPattern;
        }
        return lastMatchPattern;
    }


}
