package com.codegym.song.service.impl;

import com.codegym.song.dto.SongDTO;
import com.codegym.song.model.Song;
import com.codegym.song.repository.ISongRepository;
import com.codegym.song.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;

    @Override
    public List<SongDTO> getAll() {
       List<Song> songList = iSongRepository.findAll();
       List<SongDTO> songDTOList = null;
        for (Song song: songList) {
            songDTOList.add(new SongDTO(song.getId(),song.getName(),song.getSinger(),song.getKindOfMusic()));
        }
        return songDTOList;
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public List<Song> findByName(String name) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        iSongRepository.deleteById(id);
    }
}
