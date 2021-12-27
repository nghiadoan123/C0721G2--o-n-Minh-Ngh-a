package com.codegym.song.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class SongDTO {

    private Integer id;

    @NotBlank(message = "Ten bai hat khong chua cac ky tu dac biet, toi da 800 ky tu" )
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,800}$",message = "Ten bai hat khong chua cac ky tu dac biet, toi da 800 ky tu")
    private String name;

    @NotBlank(message = "Ten bai hat khong chua cac ky tu dac biet, toi da 800 ky tu" )
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,300}$",message = "Ten Ca sy khong chua cac ky tu dac biet, toi da 300 ky tu")
    private String singer;

    @NotBlank(message = "Ten bai hat khong chua cac ky tu dac biet, toi da 800 ky tu" )
    @Pattern(regexp = "^[a-zA-Z0-9 ,]{1,1000}$",message = "Ten the loai khong chua cac ky tu dac biet, toi da 1000 ky tu")
    private String kindOfMusic;

    public SongDTO() {
    }

    public SongDTO(Integer id, String name, String singer, String kindOfMusic) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }
}
