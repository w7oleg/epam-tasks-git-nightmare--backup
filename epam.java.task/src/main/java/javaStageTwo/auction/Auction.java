package javaStageTwo.auction;

import javaStageTwo.auction.console.Printer;
import javaStageTwo.auction.exceptions.OnlyOneParticipantException;
import javaStageTwo.auction.models.lots.Lot;
import javaStageTwo.auction.models.participants.Participant;

import java.util.*;
import java.util.concurrent.CyclicBarrier;

public class Auction {
    List<Participant> participants = new ArrayList<>();
    public CyclicBarrier roundAuction;
    BarrierAction barrierAction = new BarrierAction(participants);

    public void addParticipant(Participant p) {
        participants.add(p);
    }

    public void registerAuction(int participantsCount) {
        roundAuction = new CyclicBarrier(participantsCount, barrierAction);

        for (int i = 0; i < participantsCount; i++) {
            addParticipant(new Participant(i, 5000, 0, false, new ArrayList<>(), roundAuction));
        }
    }

    public void startRoundAuction() {
        int sizeParticipantInRound = (int) participants.stream().filter(f -> !f.getRefused()).count();
        roundAuction = new CyclicBarrier(sizeParticipantInRound, barrierAction);
        participants.stream().filter(f -> !f.getRefused()).forEach(x -> x.setBarrier(roundAuction));
        participants.stream().filter(f -> !f.getRefused()).forEach(x -> new Thread(x).start());
    }

    public void startAuction(int id, String lotName, int currentPrice) {
        participants.forEach(x -> x.addLot(new Lot(id, lotName, currentPrice)));
        participants.forEach(z -> z.setCurrentIdLot(id));
        checkFee();
        try {
            setStateBeforeNewLot();
            while (participants.stream().filter(x -> !x.getRefused()).count() > 1) {
                new Printer().printLotName(lotName, currentPrice);

                startRoundAuction();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                setCurrentLotWithHighBet(id);
                setCurrentBetAllParticipants(id);
            }
        } catch (OnlyOneParticipantException e) {
            System.err.println(lotName + " " + e.getMessage());
        }
    }

    private void setCurrentLotWithHighBet(int id) {
        Lot currentLotWithHighPrice = participants.stream().flatMap(l -> l.getLots().
                stream()).filter(f -> f.getId() == id).max(Comparator.comparing(Lot::getCurrentPrice)).
                orElseThrow(NullPointerException::new);
        participants.stream().filter(l -> {
            return l.getLots().stream().anyMatch(h -> h.equals(currentLotWithHighPrice));
        }).forEach(s -> s.setHighPrice(true));
        participants.stream().filter(l -> {
            return l.getLots().stream().noneMatch(h -> h.equals(currentLotWithHighPrice));
        }).forEach(s -> s.setHighPrice(false));
    }

    private void setCurrentBetAllParticipants(int id) {
        int currentBet = participants.stream().flatMap(x -> x.getLots().
                stream()).filter(f -> f.getId() == id).max(Comparator.comparing(Lot::getCurrentPrice)).
                orElseThrow(NullPointerException::new).getCurrentPrice();
        participants.forEach(x -> {
            x.getLots().stream().filter(f -> f.getId() == id).forEach(z -> z.setCurrentPrice(currentBet));
        });
    }

    private void checkFee() {
        participants.forEach(fee -> {
            if (fee.getFee() > 0) {
                fee.setFee(fee.getFee() - 1);
            }
        });
    }

    private void setStateBeforeNewLot() throws OnlyOneParticipantException {
        long countParticipantWithFee = participants.stream().filter(f -> f.getFee() > 0).count();
        if (((long) participants.size() - countParticipantWithFee) < 2) {
            throw new OnlyOneParticipantException("There is only one participant");
        }
        for (Participant participant : participants) {
            if (participant.getFee() > 0) {
                participant.setRefused(true);
            } else {
                participant.setRefused(false);
            }
            participant.setHighPrice(false);
        }
    }
}
