package com.lys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class SentenceUtilsTest {
    Dictionary dictionary;
    Sentence sentence;
    String testIsEngString ;
    @Before
    public void setUp() throws Exception {
        //初始化字典
        dictionary=new Dictionary();
        List<String> dictionaryList = new ArrayList<>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile", "ice", "cream", "man go","mango"));
        dictionary.setElements(dictionaryList);
        dictionary.setNumber(dictionary.getElements().size());
        //初始化句子
        sentence=new Sentence();
        sentence.setContent("ilikeicecreamandmango");
        sentence.setLength(sentence.getContent().length());
        //

    }

    @After
    public void tearDown() throws Exception {
        dictionary=null;
        sentence=null;
    }

    //测试有效的句子情况 解决#Stage 1需求
    @Test(timeout = 100000)
    public void findSentence() {
        List<String> sentenceList = SentenceUtils.findSentence(dictionary, sentence);
        sentenceList.forEach(System.out::println);
    }

    //测试键盘输入字典的方法
    @Test
    public void inputDictionary() {
        List<String> strings = SentenceUtils.inputDictionary();
        strings.forEach(System.out::println);
    }

    //测试字符串的正则表达式
    @Test
    public void isEngString() {
        testIsEngString="testIsEngString";
        assertTrue(SentenceUtils.isEngString(testIsEngString));;
    }

    //测试字符串的正则表达式 解决#Stage 2需求
    @Test
    public void testFindSentenceByInputDic() {
        List<String> sentenceByInputDic = SentenceUtils.findSentenceByInputDic(sentence);
        sentenceByInputDic.forEach(System.out::println);
    }

    //用合并户输入的字典查询有效句子 解决#Stage 2需求
    @Test
    public void testFindSentenceByMergeDictionary() {
        List<String> sentenceByInputDic = SentenceUtils.findSentenceByMergeDictionary(dictionary,sentence);
        sentenceByInputDic.forEach(System.out::println);
    }

    //测试空指针异常
    @Test(expected = NullPointerException.class)
    public void isEngStringByException() {
        assertTrue(SentenceUtils.isEngString(null));;
    }








    @Test(expected = NullPointerException.class)
    public void testFindSentenceByInputDicByException() {
        SentenceUtils.findSentenceByInputDic(null);;
    }

    @Test(expected = NullPointerException.class)
    public void testFindSentenceByMergeDictionaryByException() {
       SentenceUtils.findSentenceByMergeDictionary(null,null);;
    }
}
