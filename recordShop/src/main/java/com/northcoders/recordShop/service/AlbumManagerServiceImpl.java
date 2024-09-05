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
import java.util.Optional;

@Service
public class AlbumManagerServiceImpl implements AlbumManagerService {

    @Autowired
    AlbumManagerRepository albumManagerRepository;

    @Override
    public List<Album> getAllAlbums(String genre) {
        ArrayList<Album> albums = new ArrayList<>();
        albumManagerRepository.findAll().forEach(albums::add);

        return albums;
    }

    @Override
    public Album insertAlbum(Album album) {
        return albumManagerRepository.save(album);
    }

    @Override
    public ResponseEntity<Album> findAlbumById(Long id) {
        Optional<Album> album = albumManagerRepository.findById(id);

        if (album.isEmpty()) {
            return new ResponseEntity<>(NonexistentAlbum.getNonexistentAlbum(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(album.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Album> updateAlbumById(Long id, Album album) {

        if (albumManagerRepository.existsById(id)) {
            albumManagerRepository.deleteById(id);
            insertAlbum(album);

            return new ResponseEntity<>(album, HttpStatus.OK);
        }

        return new ResponseEntity<>(NonexistentAlbum.getNonexistentAlbum(), HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<String> deleteAlbumById(Long id) {

        if (albumManagerRepository.existsById(id)){
            albumManagerRepository.deleteById(id);
            return new ResponseEntity<>("Album deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("The album with the specified ID does not exist.", HttpStatus.UNPROCESSABLE_ENTITY);
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
                return new ResponseEntity<>(new ArrayList<>() {{add(NonexistentAlbum.getNonexistentAlbum());}}, HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<>(new ArrayList<>() {{add(NonexistentAlbum.getNonexistentAlbum());}}, HttpStatus.NOT_FOUND);
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
            return new ResponseEntity<>(new ArrayList<>() {{add(NonexistentAlbum.getNonexistentAlbum());}}, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> getAlbumDescriptionByName(String title) {

        for (Album album : albumManagerRepository.findAll()) {
            if (album.getTitle().equals(title)) {
                return new ResponseEntity<>(album.getDescription(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("Album not found", HttpStatus.NOT_FOUND);
    }

}
