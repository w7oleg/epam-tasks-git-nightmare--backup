package javaStageTwo.threads.containers;

import javaStageTwo.threads.entities.Bidder;

import java.util.ArrayList;
import java.util.List;

public class BidderList {
    private ArrayList<Bidder> bidders;

    public BidderList(int count) {
        bidders = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            bidders.add(new Bidder(i));
        }
    }

    public List<Bidder> getBidders() {
        return bidders;
    }
}
