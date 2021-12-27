package com.codegym.song.service;


import com.codegym.song.dto.SongDTO;
import com.codegym.song.model.Song;

import java.util.List;

public interface ISongService {

    List<SongDTO> getAll();
    Song findById(Integer id);

    void save(Song song);

    List<Song> findByName(String name);

    void remove(Integer id);
}
