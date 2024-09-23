package org.example;


import java.util.*;

/**
 * Question: can we get 5100 money units, having different money ?
 */
public class Main {

    private static final int value5000 = 5000;
    private static final int value2000 = 2000;
    private static final int value1000 = 1000;
    private static final int value500 = 500;
    private static final int value100 = 100;
    private static final int value50 = 50;
    private static int sum = 0;

    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(5000, 3);
        map.put(2000, 3);
        map.put(1000, 3);
        map.put(500, 3);
        map.put(100, 3);
        map.put(50, 3);
        map.put(10, 3);

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

//        List<String> combinations = new ArrayList<>();
//        int[] arr = new int[money.length];
//        collectCombinationsDfs(5100, arr, 0, money, combinations);
//        combinations.forEach(s -> {
//            System.out.println(s);
//        });

        System.out.printf("can give money ? %s %n", canGiveMoney(map, 5100) ? "yes" : "no");
    }

    private static boolean canGiveMoney(HashMap<Integer, Integer> map, int amount) {

        while (true) {
            calcSum(value5000, amount, map);
            if (sum == amount) {
                return true;
            }
            calcSum(value2000, amount, map);
            if (sum == amount) {
                return true;
            }
            calcSum(value1000, amount, map);
            if (sum == amount) {
                return true;
            }
            calcSum(value500, amount, map);
            if (sum == amount) {
                return true;
            }
            calcSum(value100, amount, map);
            if (sum == amount) {
                return true;
            }
            calcSum(value50, amount, map);
            if (sum == amount) {
                return true;
            }


            if (amount - sum < value50) {
                return false;
            }

            if (map.get(value5000) == 0 && map.get(value2000) == 0 && map.get(value1000) == 0 && map.get(value500) == 0 && map.get(value100) == 0) {
                return false;
            }
        }
    }

    private static void calcSum(int value, int amount, HashMap<Integer, Integer> map) {

        int count = map.get(value);
        map.put(value, count - 1);
        int rest = amount - sum;

        if (count > 0 && (rest / value) >= 1 || rest == value) {
            sum += value;
        }

    }


    private static void collectCombinationsDfs(int sum, int[] arr, int index, Money[] money, List<String> combinations) {

        StringBuilder sb = new StringBuilder();
        int localSum = getLocalSum(arr, money, sb);
        if (localSum == sum) {
            combinations.add(sb.toString());
        }

        if (index == arr.length - 1) {
            return;
        }

        arr[index] = 0;
        collectCombinationsDfs(sum, arr, index + 1, Arrays.copyOf(money, money.length), combinations);

        arr[index] = 1;
        Money[] newMoney = Arrays.copyOf(money, money.length);
        newMoney[index] = new Money(newMoney[index].value(), newMoney[index].count() - 1);
        collectCombinationsDfs(sum, arr, index + 1, newMoney, combinations);
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