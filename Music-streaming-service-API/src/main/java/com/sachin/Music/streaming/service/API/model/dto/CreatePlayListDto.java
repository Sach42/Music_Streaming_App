package com.sachin.Music.streaming.service.API.model.dto;

import com.sachin.Music.streaming.service.API.model.PlayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlayListDto {
    AuthenticationInputDto authInfo;
    PlayList playList;
}
