package com.northcoders.recordShop.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.recordShop.model.Album;
import com.northcoders.recordShop.model.Genre;
import com.northcoders.recordShop.service.AlbumManagerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
@SpringBootTest
class AlbumManagerControllerTest {

    @Mock
    private AlbumManagerServiceImpl mockAlbumManagerServiceImpl;

    @InjectMocks
    private AlbumManagerController albumManagerController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        mockMvcController = MockMvcBuilders.standaloneSetup(albumManagerController).build();
        mapper = new ObjectMapper();
    }

    @Test
    public void testGetAllAlbums() throws Exception {

        List<Album> albums = new ArrayList<>();
        albums.add(Album.builder().id(1L).title("Future Nostalgia").
                artist("Dua Lipa").genre(Genre.POP).releaseYear(2020).
                description("An amazing pop album that saved me through the pandemic!!").build());
        albums.add(Album.builder().id(2L).title("Materia Prisma").
                artist("Marco Mengoni").genre(Genre.POP).releaseYear(2023).
                description("Such a talented singer, took over the stage at Eurovision").build());
        albums.add(Album.builder().id(3L).title("Un Verano Sin Ti").
                artist("Bad Bunny").genre(Genre.LATINMUSIC).releaseYear(2022).
                description("Latin-American music perfect for parties!").build());
        albums.add(Album.builder().id(4L).artist("Charli XCX").genre(Genre.POP).build());
        albums.add(Album.builder().artist("Myhoyo").genre(Genre.CLASSICALMUSIC).build());

        when(mockAlbumManagerServiceImpl.getAllAlbums()).thenReturn(albums);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/recordShop/albums"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Future Nostalgia"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].genre").value("Pop"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].releaseYear").value(2023))
                .andExpect(MockMvcResultMatchers.jsonPath("$[10].id").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].artist").value("Charli XCX"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].title").doesNotExist())
                .andExpect(MockMvcResultMatchers.jsonPath("$[4].id").doesNotExist()); //No real database operation happens in a mocked service, so there is no automatic ID generation.
    }

    @Test
    public void testAddAlbum() throws Exception {

        Album album = new Album(6L, "Radical Optimism", "Dua Lipa", Genre.POP,
                2024, "A beautiful, calm summer album.");

        when(mockAlbumManagerServiceImpl.insertAlbum(album)).thenReturn(album);

        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/recordShop/albums")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(album)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(mockAlbumManagerServiceImpl, times(1)).insertAlbum(album);
    }

    @Test
    public void testGetAlbumById() throws Exception {
        //Arrange
        Long albumId = 1L;
        Album album = new Album(albumId, "Radical Optimism", "Dua Lipa", Genre.POP,
                2024, "A beautiful, calm summer album.");

        when(mockAlbumManagerServiceImpl.findAlbumById(albumId))
                .thenReturn(new ResponseEntity<>(album, HttpStatus.OK));

        //Act and Assert
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/recordShop/albums/{id}", albumId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(albumId))
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Radical Optimism"));

        verify(mockAlbumManagerServiceImpl, times(1)).findAlbumById(albumId);
    }

    @Test
    public void testGetAlbumByIdNotFound() throws Exception {
        // Arrange
        Long albumId = 999L; // ID that doesn't exist
        when(mockAlbumManagerServiceImpl.findAlbumById(albumId)).thenReturn(new ResponseEntity<>(HttpStatus.NOT_FOUND));

        // Act and Assert
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/recordShop/albums/{id}", albumId))
                .andExpect(MockMvcResultMatchers.status().isNotFound());

        verify(mockAlbumManagerServiceImpl, times(1)).findAlbumById(albumId);
    }

}