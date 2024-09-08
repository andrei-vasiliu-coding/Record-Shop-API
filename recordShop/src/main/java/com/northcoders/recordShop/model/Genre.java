package com.northcoders.recordShop.model;

import com.fasterxml.jackson.annotation.JsonValue;

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

    //Instructs Jackson to use the genreDescriptor field when serializing the enum to JSON.
    @JsonValue
    public String getGenreDescriptor() {
        return genreDescriptor;
    }

}
