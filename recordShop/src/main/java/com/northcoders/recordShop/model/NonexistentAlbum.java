package com.northcoders.recordShop.model;

public class NonexistentAlbum {
    public static Album getNonexistentAlbum() {
        return Album.builder().id(-1L).title("Album not found").build();
    }
}
