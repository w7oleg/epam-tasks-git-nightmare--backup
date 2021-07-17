package javaStageTwo.threads.services;

import javaStageTwo.threads.containers.BidList;
import javaStageTwo.threads.containers.LotList;
import javaStageTwo.threads.containers.WinnersList;
import javaStageTwo.threads.entities.Bid;
import javaStageTwo.threads.entities.Lot;
import javaStageTwo.threads.states.BidState;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class WinnerDefiner {

    public static void define(long lotID) throws InterruptedException {
        Lot lot = LotList.searchByID(lotID);
        List<Bid> bidsWithLot = BidList.getBidsByLot(lot);
        if (!bidsWithLot.isEmpty()) {
            Bid winnerBid = Collections.max(BidList.getBidsByLot(lot), Comparator.comparingInt(Bid::getPrice));
            winnerBid.setState(BidState.AWAITING_PAYMENT);
            WinnersList.add(winnerBid);
            System.out.println("Lot " + Objects.requireNonNull(lot).getName() + " goes to the bidder №" + winnerBid.getBidder().getId());
            winnerBid.getBidder().executePayment(winnerBid);

        } else {
            System.out.println("Lot " + Objects.requireNonNull(lot).getName() + " is not passed to any of the bidders");
        }
    }
}
