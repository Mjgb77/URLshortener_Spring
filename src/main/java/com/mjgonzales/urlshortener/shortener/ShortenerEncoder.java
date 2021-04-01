package com.mjgonzales.urlshortener.shortener;

import java.util.HashMap;

public class ShortenerEncoder {
    private final String ALPHABET;
    private final int ALPHABET_SZ;
    private final HashMap<Character, Integer> posByToken;

    public ShortenerEncoder(String alphabet) {
        ALPHABET = alphabet;
        ALPHABET_SZ = alphabet.length();
        posByToken = new HashMap<>();
        for (int i = 0; i < ALPHABET_SZ; i++) {
            posByToken.put(ALPHABET.charAt(i), i);
        }
    }

    String idToShortURL(int n) {
        if (n < 0) return null;
        StringBuilder shortURL = new StringBuilder();
        if (n == 0) return String.valueOf(ALPHABET.charAt(0));
        while (n > 0) {
            shortURL.append(ALPHABET.charAt(n % ALPHABET_SZ));
            n /= ALPHABET_SZ;
        }
        return shortURL.reverse().toString();
    }


    int shortURLtoID(String shortURL) {
        int id = 0;
        for (char c : shortURL.toCharArray()) {
            if (posByToken.containsKey(c)) {
                id = id * ALPHABET_SZ + posByToken.get(c);
            }
        }
        return id;
    }

}
