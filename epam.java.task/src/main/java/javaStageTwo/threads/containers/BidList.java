package javaStageTwo.threads.containers;

import javaStageTwo.threads.entities.Bid;
import javaStageTwo.threads.entities.Bidder;
import javaStageTwo.threads.entities.Lot;
import javaStageTwo.threads.states.BidState;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BidList {
    private static ArrayList<Bid> bids = new ArrayList<>();
    private static long counter = 0;

    public static List<Bid> getBids() {
        return bids;
    }

    public static List<Bid> getBidsByBidder(Bidder bidder) {
        return bids.stream().filter(bid -> bid.getBidder().equals(bidder)).collect(Collectors.toList());
    }

    public static List<Bid> getBidsByLot(Lot lot) {
        return bids.stream().filter(bid -> bid.getLot().equals(lot)).collect(Collectors.toList());
    }

    public static void add(Lot lot, int price, Bidder bidder) {
        bids.add(new Bid(counter, price, lot, bidder, BidState.NEW));
        counter++;
    }

    public static Bid get(long id) {
        Optional<Bid> optionalBid = bids.stream().filter(bid -> bid.getId() == id).findAny();
        return optionalBid.orElse(null);
    }

    public static boolean isBidExist(Bidder bidder, Lot lot) {
        return getBidsByBidder(bidder).stream().anyMatch(bid -> bid.getLot().equals(lot));
    }

    public static Bid get(Bidder bidder, Lot lot) {
        Optional<Bid> optionalBid = getBidsByBidder(bidder).stream().filter(bid -> bid.getLot().equals(lot)).findAny();
        return optionalBid.orElse(null);
    }
}
