package com.sachin.Music.streaming.service.API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = Song.class,property = "songId")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer songId;
    private String songName;
    @Enumerated(value = EnumType.STRING)
    private Genre songGenre;

    private LocalDateTime songLaunchDate;

    @JoinColumn(name = "admin_id")
    @ManyToOne
    private  Admin admin;

    @ManyToOne
    @JoinColumn(name = "fk_playlist_id")
    private PlayList playlist;
}
