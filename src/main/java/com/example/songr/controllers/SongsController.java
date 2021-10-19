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

import javax.transaction.Transactional;
import java.util.List;

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

    @GetMapping("/albumInfo/{id}")
    public String singleAlbum(@PathVariable ("id") Long id, Model model){
        Album album = albumRepository.findById(id).get();
        model.addAttribute( "album",album);
        List<Song> songs = album.getSongs();
        model.addAttribute("songs",songs);
        return "albumInfo";
    }

//    @PostMapping("/addSong/{albumId}")
//    public RedirectView addSongId(@PathVariable String albumId, @ModelAttribute Song song){
//        Album album = albumRepository.findById(Long.parseLong(albumId)).orElseThrow();
//        Song newSong = new Song(song.getTitle(), song.getLength(),song.getTrackNumber());
//        song.setAlbum(album);
//        songRe pository.save(newSong);
//        return new RedirectView("/songs");
//    }
//    @GetMapping("/addSong/{id}")
//    public String getAllSongsId(@PathVariable ("id") String id, Model model){
//        model.addAttribute("album",albumRepository.findById(Long.parseLong(id)).orElseThrow());
//        return "addSongId";
//    }
}
