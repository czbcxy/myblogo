package me.zbl.fullstack.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BaseUtils {

    public static List<Integer> getRandem(Integer i) {
        ArrayList<Integer> li = new ArrayList<>();
        Random random = new Random();
        while (true){
            int i1 = random.nextInt(i);
            if (li.contains(i1))
                continue;
            li.add(i1);
            if (li.size()==3 || li.size()>=i)
                break;
        }
//        Collections.sort(li);
        return li;
    }
    public static List<Integer> getRandem2(Integer i) {
        ArrayList<Integer> li = new ArrayList<>();
        Random random = new Random();
        while (true){
            int i1 = random.nextInt(i);
            if (li.contains(i1))
                continue;
            li.add(i1);
            if (li.size()>=i)
                break;
        }
        return li;
    }

    public static void main(String[] args) {
        List<Integer> randem = getRandem(10);
        randem.forEach(x-> System.out.println(x));
    }
}
