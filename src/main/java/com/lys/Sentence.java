package com.lys;

/**
 * 实体:句子
 */
public class Sentence {
    /*
     *句子内容
     */
    public String content;

    /*
     *句子长度
     */
    public Integer length;


    public Sentence() {
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "content='" + content + '\'' +
                ", length=" + length +
                '}';
    }
}
