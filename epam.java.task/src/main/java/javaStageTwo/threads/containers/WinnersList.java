package javaStageTwo.threads.containers;

import javaStageTwo.threads.entities.Bid;
import javaStageTwo.threads.states.BidState;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinnersList {

    private static Map<Date, Bid> winnerBids = new HashMap<>();

    public static void add(Bid bid) {
        winnerBids.put(new Date(), bid);
    }

    public static Map<Date, Bid> getWinnerBids() {
        return winnerBids;
    }

    public static List<Bid> getAwaitingPaymentBidsOlderThan(Date timeLimit) {
        return winnerBids.entrySet().stream().filter(entry ->
                (entry.getValue().getState() == BidState.AWAITING_PAYMENT) && (entry.getKey().before(timeLimit))).
                map(Map.Entry::getValue).collect(Collectors.toList());
    }
}
