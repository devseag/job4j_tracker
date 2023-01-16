package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng){
        return "Unknown word " + eng;
    }

    public static void main(String[] args) {
        DummyDic dummyDic = new DummyDic();
        dummyDic.engToRus("tst");
    }
}
