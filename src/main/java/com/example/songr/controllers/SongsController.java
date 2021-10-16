package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Song;
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

    @GetMapping("/allSongs")
    public String getAllSongs(Model model){
        model.addAttribute("song", new Song());
        model.addAttribute("songs",songRepository.findAll());
        model.addAttribute("albums",albumRepository.findAll());
        return "allSongs";
    }

    @PostMapping("/addSong")
    public RedirectView addSong( @ModelAttribute Song song){
        System.out.println(song.getAlbum().getSongs());
        songRepository.save(song);
        return new RedirectView("/allSongs");
    }
}
