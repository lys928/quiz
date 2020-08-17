package com.lys;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Pattern;

public class SentenceUtils {
    /**
     * 查询符合字典元素的句子
     *
     * @param dictionary
     * @param sentence
     * @return
     */
    public static List<String> findSentence(Dictionary dictionary, Sentence sentence) {
        String content = Optional.ofNullable(sentence).map(u -> u.getContent()).orElse("");
        List<String> elements = Optional.ofNullable(dictionary).map(u -> u.getElements()).orElse(new ArrayList<>());
        HashSet<String> wordDict = new HashSet<>(elements);
        List<String>[] dp = new ArrayList[content.length() + 1];
        List<String> initial = new ArrayList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= content.length(); i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(content.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + content.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[content.length()];
    }

    /**
     * 是否为英文字符串
     *
     * @param str
     * @return
     */
    public static boolean isEngString(String str) {
        Pattern pattern = Pattern.compile("[a-zA-Z]*");
        return pattern.matcher(str).matches();
    }

    /**
     * 键盘输入字典元素
     *
     * @return
     */
    public static List<String> inputDictionary() {
        //	键盘录入数据
        Scanner s = new Scanner(System.in);
        List<String> dictionary = new ArrayList<>();
        //	、使用while进行循环，如果输入为end结束循环
        System.out.println("请输入英文字符串的字典元素: ");
        while (true) {
            String str = s.nextLine();

            if (StringUtils.isEmpty(str)) {
                System.out.println("请输入非空的英文字符串:");
                continue;
            }

            if (str.equals("end")) {
                break;
            }
            //去出空格
            String replace = str.replace(" ", "");
            if (!SentenceUtils.isEngString(replace)) {
                System.out.println("请输入英文字符串:");
                continue;
            }
                dictionary.add(str);
        }
        return dictionary;
    }

    /**
     * 用户输入的字典查询有效句子
     * @param sentence
     * @return
     */
    public static List<String> findSentenceByInputDic(Sentence sentence) {
        if (sentence == null) {
            throw new NullPointerException("句子对象不能为空");
        }
        //	键盘录入数据
        List<String> dictionaryList = SentenceUtils.inputDictionary();
        //替换成用户输入的字典
        Dictionary dictionary = new Dictionary(dictionaryList, dictionaryList.size());
        return findSentence(dictionary, sentence);
    }


    /**
     * 用合并户输入的字典查询有效句子
     * @param sentence
     * @return
     */
    public static List<String> findSentenceByMergeDictionary(Dictionary dictionary, Sentence sentence) {
        if (dictionary == null) {
            throw new NullPointerException("句子对象不能为空");
        }

        if (sentence == null) {
            throw new NullPointerException("字典对象不能为空");
        }
        //	键盘录入数据
        List<String> dictionaryList = SentenceUtils.inputDictionary();
        //合并成用户输入的字典
        List<String> elements = dictionary.getElements();
        elements.addAll(dictionaryList);
        return findSentence(dictionary, sentence);
    }


}
