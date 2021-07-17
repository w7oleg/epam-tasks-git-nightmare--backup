package javaStageTwo.threads.services;

import javaStageTwo.threads.containers.WinnersList;
import javaStageTwo.threads.entities.Bid;
import javaStageTwo.threads.entities.Bidder;
import javaStageTwo.threads.states.BidState;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PaymentController extends Thread {
    public final int timeToPay = 3000;
    public final int lotsCountForLock = 2;

    @Override
    public void run() {
        try {
            if (this.isDaemon()) {
                while (true) {
                    Thread.sleep(1000);
                    Calendar calendar = new GregorianCalendar();
                    calendar.add(Calendar.MILLISECOND, -timeToPay);
                    Date timeLimit = calendar.getTime();
                    for (Bid bid : WinnersList.getAwaitingPaymentBidsOlderThan(timeLimit)) {
                        Bidder bidder = bid.getBidder();
                        bidder.lock(lotsCountForLock);
                        System.out.println("Bidder №" + bidder.getId() + " is locked.");
                        bid.setState(BidState.NEW);
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
