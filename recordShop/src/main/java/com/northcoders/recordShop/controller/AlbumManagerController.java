package com.northcoders.recordShop.controller;

import com.northcoders.recordShop.model.Album;
import com.northcoders.recordShop.repository.AlbumManagerRepository;
import com.northcoders.recordShop.service.AlbumManagerService;
import com.northcoders.recordShop.service.AlbumManagerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/recordShop")
public class AlbumManagerController {

    @Autowired
    AlbumManagerService albumManagerService;
    //dependency injection, Spring injects AlbumManagerServiceImpl because it is marked with @Service
    //you are actually calling the methods implemented in AlbumManagerServiceImpl

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAllAlbums() {
        return new ResponseEntity<>(albumManagerService.getAllAlbums(), HttpStatus.OK);
        //return ResponseEntity.ok(albumManagerService.getAllAlbums()); another way of writing it
    }

    @PostMapping("/albums")
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album newAlbum = albumManagerService.insertAlbum(album);
        return new ResponseEntity<>(newAlbum, HttpStatus.CREATED);
    }

    @GetMapping("/albums/id/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        return albumManagerService.findAlbumById(id);
    }

    @PutMapping("/albums/id/{idToUpdate}")
    public ResponseEntity<Album> updateAlbumById(@PathVariable Long idToUpdate, @RequestBody Album album) {
        return albumManagerService.updateAlbumById(idToUpdate, album);
    }

    @DeleteMapping("/albums/id/{idToDelete}")
    public ResponseEntity<String> deleteAlbumById(@PathVariable Long idToDelete) {
        return albumManagerService.deleteAlbumById(idToDelete);
    }

    @GetMapping("/albums/genre/{genre}") //{genre} must be written all uppercase.
    public ResponseEntity<ArrayList<Album>> findAlbumsByGenre(@PathVariable String genre) {
        return albumManagerService.findAlbumsByGenre(genre);
    }

    @GetMapping("/albums/artist/{artist}") //%20 between names.
    public ResponseEntity<ArrayList<Album>> findAlbumsByArtist(@PathVariable String artist) {
        return albumManagerService.findAlbumsByArtist(artist);
    }

    @GetMapping("/albums/releaseYear/{releaseYear}")
    public ResponseEntity<ArrayList<Album>> findAlbumsByReleaseYear(@PathVariable Integer releaseYear) {
        return albumManagerService.findAlbumsByReleaseYear(releaseYear);
    }

    @GetMapping("/albums/title/{title}")
    public ResponseEntity<String> getAlbumDescriptionByName(@PathVariable String title) {
        return albumManagerService.getAlbumDescriptionByName(title);
    }

    // http://localhost:8080/actuator/health to check the status of the app.
}
