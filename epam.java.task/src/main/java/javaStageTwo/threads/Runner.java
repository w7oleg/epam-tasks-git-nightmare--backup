package javaStageTwo.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
//        Auction auction = new Auction();
//        auction.registerAuction(10);
//        auction.startAuction(1, "Rolls-Royce", 1500);
//        auction.startAuction(2, "Mercedes", 500);
//        auction.startAuction(3, "Ford", 100);
        List list=new ArrayList<>();
        list.add("Hello");
        list.add("world");
        list.add("world");
        List str= (List) list.stream().filter(x-> x.equals("world")).collect(Collectors.toList());
        System.out.println(str);
    }
}
