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

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        return albumManagerService.findAlbumById(id);
    }

    @PutMapping("/albums/{idToUpdate}")
    public ResponseEntity<Album> updateAlbumById(@PathVariable Long idToUpdate, @RequestBody Album album) {
        return albumManagerService.updateAlbumById(idToUpdate, album);
    }

    @DeleteMapping("/albums/{idToDelete}")
    public ResponseEntity<String> deleteAlbumById(@PathVariable Long idToDelete) {
        return albumManagerService.deleteAlbumById(idToDelete);
    }

}
