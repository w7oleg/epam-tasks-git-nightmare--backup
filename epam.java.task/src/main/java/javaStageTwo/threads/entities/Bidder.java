package javaStageTwo.threads.entities;

import javaStageTwo.threads.containers.BidList;
import javaStageTwo.threads.containers.LotList;
import javaStageTwo.threads.services.Locking;
import javaStageTwo.threads.states.BidState;

import java.util.Objects;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Bidder extends Thread {
    private final long id;
    private Locking locking;

    public Bidder(long id) {
        this.id = id;
        this.locking = new Locking();
    }

    @Override
    public long getId() {
        return id;
    }

    public void lock(int lotsCount) {
        this.locking.setLocked(true);
        this.locking.setLotsCount(lotsCount);
    }

    public void makeBid(Lot lot) {
        int amount = new Random().nextInt(1000);
        BidList.add(lot, amount, this);
        System.out.println("Bidder №" + id + " made a bid on the lot " + lot.getName() + " in the amount of " + amount + " dollars");
    }

    public void changeBid(Lot lot) {
        if (BidList.isBidExist(this, lot)) {
            Bid bid = BidList.get(this, lot);
            int amountIncrease = new Random().nextInt(500);
            int newPrice = Objects.requireNonNull(bid).getPrice() + amountIncrease;
            bid.setPrice(newPrice);
            System.out.println("Bidder №" + id + " raised the bid on the lot " + lot.getName() + " to " + newPrice + " dollars");
        }

    }

    public void executePayment(Bid winnerBid) throws InterruptedException {
        Thread.sleep(3000);

        if (new Random().nextBoolean()) {
            winnerBid.setState(BidState.PAID);
            System.out.println("Bidder №" + id + " paid the lot " + winnerBid.getLot().getName());
        } else {
            System.out.println("Bidder №" + id + " did not pay the lot " + winnerBid.getLot().getName());
        }
    }

    @Override
    public void run() {
        try {
            for (Lot lot : LotList.getLots()) {
                Thread.sleep(1500);
                if (!locking.isLocked()) {
                    int randomNumberForMakeBid = new Random().nextInt(10);

                    Thread.sleep(randomNumberForMakeBid * 1000);
                    if (new Random().nextBoolean()) {
                        makeBid(lot);
                    } else {
                        System.out.println("Bidder №" + id + " ignored the lot " + lot.getName());
                    }

                    int randomNumberForChangeBid = new Random().nextInt(10);
                    for (int i = 0; i < new Random().nextInt(5); i++) {
                        Thread.sleep(randomNumberForChangeBid * 1000);
                        if (new Random().nextBoolean()) {
                            changeBid(lot);
                        } else {
                            System.out.println("Bidder №" + id + " ignored bid increase per lot " + lot.getName());
                        }
                    }
                } else {
                    System.out.println("Bidder №" + getId() + " is locked for " + locking.getLotsCount() + " lots.");
                    locking.reduceLotsCount();
                }
                lot.getBarrier().await();
            }
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bidder)) return false;
        Bidder bidder = (Bidder) o;
        return id == bidder.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
