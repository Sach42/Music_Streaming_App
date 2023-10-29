package com.sachin.Music.streaming.service.API.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,scope = PlayList.class,property = "playListId")
public class PlayList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer playListId;

    private String playListName;

    private LocalDateTime creationDate;

    @OneToMany
    @JoinColumn(name = "fk_song_id")
    private List<Song> songs;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User userId;
}
