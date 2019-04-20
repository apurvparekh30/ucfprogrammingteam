import java.util.*;
import java.io.*;

class Collection {

    static Set<ArrayList<Integer>> set = new HashSet<>();
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        set.add(list);
        System.out.println(set.contains(list));
    }
}