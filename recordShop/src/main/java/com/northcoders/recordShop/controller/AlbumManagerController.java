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
    }

    @PostMapping
    public ResponseEntity<Album> addAlbum(@RequestBody Album album) {
        Album newAlbum = albumManagerService.insertAlbum(album);
        return ResponseEntity.ok(newAlbum); //another way of writing the ResponseEntity
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable Long id) {
        return albumManagerService.findAlbumById(id);
    }

}
