package com.codegym.song.service;


import com.codegym.song.dto.SongDTO;
import com.codegym.song.model.Song;

import java.util.List;

public interface ISongService {

    List<SongDTO> getAll();

    SongDTO findById(Integer id);

    void save(SongDTO songDTO);

    List<Song> findByName(String name);

    void remove(Integer id);
}
