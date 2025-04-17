package ru.parfenov.collectionsgenerics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {

    @Test
    void whenSort() {
        List<String> competitors = new ArrayList<>();
        competitors.add("Ivan 5");
        competitors.add("Petr 3");
        competitors.add("Alex 10");
        competitors.add("Petr 8");
        competitors.add("Ivan 6");
        competitors.add("Alex 5");
        competitors.add("Ivan 1");
        competitors.add("Petr 5");
        competitors.add("Alex 1");
        WorkOne workOne = new WorkOne();
        Assertions.assertEquals("Petr", workOne.sort(competitors));
    }
}