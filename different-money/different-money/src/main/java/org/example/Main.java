package org.example;


import java.util.*;

/**
 * Question: can we get 5100 money units, having different money ?
 */
public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(5000, 2);
        map.put(2000, 2);
        map.put(1000, 2);
        map.put(500, 2);
        map.put(100, 2);
        map.put(50, 2);
        map.put(10, 2);

        int size = getSize(map);
        Money[] money = getMoney(size, map);
        Arrays.sort(money, (o1, o2) -> {
            if (o1.value() > o2.value()) {
                return -1;
            } else if (o1.value() < o2.value()) {
                return 1;
            } else return 0;
        });

        /*Question: can we get 5100 money units ?*/

        List<String> combinations = new ArrayList<>();
        int[] arr = new int[money.length];
        dfs(5100, arr, 0, money, combinations);
        combinations.forEach(s -> {
            System.out.println(s);
        });
    }


    private static void dfs(int sum, int[] arr, int index, Money[] money, List<String> combinations) {

        StringBuilder sb = new StringBuilder();
        int localSum = getLocalSum(arr, money, sb);
        if (localSum == sum) {
            combinations.add(sb.toString());
        }

        if (index == arr.length - 1) {
            return;
        }

        arr[index] = 0;
        dfs(sum, arr, index + 1, Arrays.copyOf(money, money.length), combinations);

        arr[index] = 1;
        Money[] newMoney = Arrays.copyOf(money, money.length);
        newMoney[index] = new Money(newMoney[index].value(), newMoney[index].count() - 1);
        dfs(sum, arr, index + 1, newMoney, combinations);
    }

    private static int getLocalSum(int[] arr, Money[] money, StringBuilder sb) {
        int localSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                localSum += money[i].value();
                sb.append(String.format("%d,", money[i].value()));
            }
        }
        return localSum;
    }

    private static Money[] getMoney(int size, HashMap<Integer, Integer> map) {
        Money[] money = new Money[size];
        var iterator = map.entrySet().iterator();
        int i = 0;
        while (iterator.hasNext()) {
            var entry = iterator.next();
            for (int j = 0; j < entry.getValue(); j++) {
                money[i] = new Money(entry.getKey(), 1);
                i++;
            }
        }
        return money;
    }

    private static int getSize(HashMap<Integer, Integer> map) {
        int size = 0;
        var iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            size += entry.getValue();
        }
        return size;
    }

}