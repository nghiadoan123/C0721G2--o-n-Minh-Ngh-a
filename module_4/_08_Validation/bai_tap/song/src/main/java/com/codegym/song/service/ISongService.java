package com.codegym.song.service;


import com.codegym.song.dto.SongDTO;
import com.codegym.song.model.Song;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface ISongService {

    List<SongDTO> getAll();

    SongDTO findById(Integer id);

    void save(SongDTO songDTO);

    List<Song> findByName(String name);

    void remove(Integer id);

    Page<Song> findAll(PageRequest of);
}
