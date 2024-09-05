package com.northcoders.recordShop.service;

import com.northcoders.recordShop.model.Album;
import com.northcoders.recordShop.repository.AlbumManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumManagerServiceImpl implements AlbumManagerService {

    @Autowired
    AlbumManagerRepository albumManagerRepository;

    @Override
    public List<Album> getAllAlbums(String genre) {
        return List.of();
    }

    @Override
    public ResponseEntity<Album> getAlbumById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ArrayList<Album>> getAlbumDescriptionByName(String title) {
        return null;
    }

    @Override
    public Album insertAlbum(Album album) {
        return null;
    }

    @Override
    public ResponseEntity<Album> updateAlbumById(Long id, Album album) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteAlbumById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<ArrayList<Album>> findAlbumsByGenre(String genre) {
        return null;
    }

    @Override
    public ResponseEntity<ArrayList<Album>> findAlbumsByArtist(String artist) {
        return null;
    }

    @Override
    public ResponseEntity<ArrayList<Album>> findAlbumsByReleaseYear(Integer year) {
        return null;
    }

}
