package com.northcoders.recordShop.service;

import com.northcoders.recordShop.model.Album;
import com.northcoders.recordShop.model.Genre;
import com.northcoders.recordShop.model.NonexistentAlbum;
import com.northcoders.recordShop.repository.AlbumManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
            Genre genreEnum;

            try {
                genreEnum = Enum.valueOf(Genre.class, genre);
                ArrayList<Album> albumsOfGenre = new ArrayList<>();

                for (Album album: albumManagerRepository.findAll()) {
                    if (album.getGenre() == genreEnum)
                        albumsOfGenre.add(album);
                }

                return new ResponseEntity<>(albumsOfGenre, HttpStatus.OK);

            } catch (IllegalArgumentException | NullPointerException e) {
                return new ResponseEntity<>(new ArrayList<>() {{add(NonexistentAlbum.get());}}, HttpStatus.NOT_FOUND);
            }
        }

    @Override
    public ResponseEntity<ArrayList<Album>> findAlbumsByArtist(String artist) {

        try {
            ArrayList<Album> albumsOfArtist = new ArrayList<>();

            for (Album album: albumManagerRepository.findAll()) {
                if (album.getArtist().equals(artist))
                    albumsOfArtist.add(album);
            }

            return new ResponseEntity<>(albumsOfArtist, HttpStatus.OK);

        } catch (IllegalArgumentException | NullPointerException e) {
            return new ResponseEntity<>(new ArrayList<>() {{add(NonexistentAlbum.get());}}, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<ArrayList<Album>> findAlbumsByReleaseYear(Integer year) {

        try {
            ArrayList<Album> albumsOfYear = new ArrayList<>();

            for (Album album: albumManagerRepository.findAll()) {
                if (album.getReleaseYear().equals(year))
                    albumsOfYear.add(album);
            }

            return new ResponseEntity<>(albumsOfYear, HttpStatus.OK);

        } catch (IllegalArgumentException | NullPointerException e) {
            return new ResponseEntity<>(new ArrayList<>() {{add(NonexistentAlbum.get());}}, HttpStatus.NOT_FOUND);
        }
    }

}
