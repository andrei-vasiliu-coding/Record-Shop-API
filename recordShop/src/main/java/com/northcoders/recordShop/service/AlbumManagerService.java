package com.northcoders.recordShop.service;

import com.northcoders.recordShop.model.Album;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public interface AlbumManagerService {

    List<Album> getAllAlbums(String genre);
    ResponseEntity<Album> getAlbumById(Long id);
    ResponseEntity<ArrayList<Album>> getAlbumDescriptionByName(String title);
    Album insertAlbum(Album album);
    ResponseEntity<Album> updateAlbumById(Long id, Album album);
    ResponseEntity<String> deleteAlbumById(Long id);
    ResponseEntity<ArrayList<Album>> findAlbumsByGenre(String genre);
    ResponseEntity<ArrayList<Album>> findAlbumsByArtist(String artist);
    ResponseEntity<ArrayList<Album>> findAlbumsByReleaseYear(Integer year);

}
