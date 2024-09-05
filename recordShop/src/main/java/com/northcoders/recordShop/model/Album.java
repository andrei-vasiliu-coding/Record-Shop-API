package com.northcoders.recordShop.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Album {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_seq")
    @SequenceGenerator(name = "album_seq", allocationSize = 1)
    Long id;

    @Column
    String title;

    @Column
    String artist;

    @Column
    Genre genre;

    @Column
    Integer releaseYear;

    @Column
    String description;

}
