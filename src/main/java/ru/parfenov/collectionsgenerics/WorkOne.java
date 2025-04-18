package ru.parfenov.collectionsgenerics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Написать метод, который на вход получает массив (или список) строк в формате “имя_игрока количество_очков”.
 * Требуется вывести на экран имя победителя. Победителем считается тот,
 * кто набрал больше всех очков и сделал это раньше остальных (у нескольких игроков может быть одинаковое количество очков).
 * Порядок начисления очков определяется порядком следования элементов в массиве.
 */

public class WorkOne {
    public static void showWinner(List<String> competitors) {
        WorkOne workOne = new WorkOne();
        workOne.sort(competitors);
    }

    public String sort(List<String> competitors) {
        Map<String, Pair> mapResultList = new HashMap<>();
        for (int i = 0; i < competitors.size(); i++) {
            String[] nameArray = competitors.get(i).split(" ");
            int finalI = i;
            mapResultList.merge(nameArray[0], new Pair(Integer.parseInt(nameArray[1]), 0), (a, b) -> {
                b.number += a.number;
                b.serial = finalI;
                return b;
            });
        }
        return mapResultList.entrySet()
                .stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
}

class Pair implements Comparable<Pair> {
    int number;
    long serial;

    public Pair(int number, long serial) {
        this.number = number;
        this.serial = serial;
    }

    @Override
    public int compareTo(Pair o) {
        int result = this.number - o.number;
        if (result == 0) {
            result = (int) (o.serial - this.serial );
        }
        return result;
    }
}