package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
import com.example.songr.models.SongDTO;
import com.example.songr.repositories.AlbumRepository;
import com.example.songr.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SongsController {

    @Autowired
    SongRepository songRepository;

    @Autowired
    AlbumRepository albumRepository;


    @GetMapping("/songs")
    public String getAllSongs(Model model){
        model.addAttribute("songs",songRepository.findAll());
        return "songs";
    }

    @GetMapping("/addSong")
    public String addSongForm(){
        return "addSong";
    }

    @PostMapping("/addSong")
    public RedirectView addSong(@ModelAttribute SongDTO songDto){
        Album album = albumRepository.findByTitle(songDto.getAlbumTitle());
        Song newSong = new Song(songDto.getTitle(), songDto.getLength(),songDto.getTrackNumber(),album);
        songRepository.save(newSong);
        return new RedirectView("/songs");
    }
}
