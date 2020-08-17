package com.lys;

import java.util.List;

/**
 * 实体:字典
 */
public class Dictionary {
    /*
     *字典元素
     */
    public List<String> elements;

    /*
     *字典元素个数
     */
    public Integer number;



    public Dictionary() {
    }

    public Dictionary(List<String> elements, Integer number) {
        this.elements = elements;
        this.number = number;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Dictionary{" +
                "elements=" + elements +
                ", number=" + number +
                '}';
    }
}
