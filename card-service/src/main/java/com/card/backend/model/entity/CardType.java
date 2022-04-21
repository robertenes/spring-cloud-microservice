package com.card.backend.model.entity;

import java.util.Arrays;
import java.util.Optional;

public enum CardType {
    DEBITCARD("Bank Card"),
    CREDITCARD("Credit Card");

    private String label;

    CardType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public String toString() {
        return label;
    }

    public static Integer getIndexByName(String label) {
        Optional<CardType> cardType = Arrays.asList(CardType.values()).stream()
                .filter(item -> item.label.equalsIgnoreCase(label))
                .findFirst();

        return cardType.isPresent() ? cardType.get().ordinal() : null;
    }

    public static CardType getCardTypeByString(String label) {
        Optional<CardType> cardType = Arrays.asList(CardType.values()).stream()
                .filter(item -> item.label.equalsIgnoreCase(label))
                .findFirst();
        return cardType.isPresent() ? cardType.get() : null;
    }


}
