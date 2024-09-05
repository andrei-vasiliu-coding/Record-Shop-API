package com.northcoders.recordShop.model;

public enum Genre {
    POP("Pop"),
    ROCK("Rock"),
    RANDB("R&B"),
    HIPHOP("Hip-hop"),
    FOLK("Folk"),
    ELECTRONIC("Electronic"),
    METAL("Metal"),
    CLASSICALMUSIC("Classical music"),
    LATINMUSIC("Latin music"),
    KPOP("K-pop");

    final String genreDescriptor;

    Genre(String descriptor) {
        this.genreDescriptor = descriptor;
    }
}
