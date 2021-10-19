package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AlbumsController {

    @Autowired
    AlbumRepository albumRepository;

//    @GetMapping("/albums")
//    public String getAlbums(Model model){
//        Album album1 = new Album("What's Going On", "Marvin Gaye's",10, (int) 350, "http://media.oscarmini.com/wp-content/uploads/2014/08/05044727/michaeljackson_coverart.jpg");
//        Album album2 = new Album("Blue", "Joni Mitchell", 4, (int) 407, "https://d1csarkz8obe9u.cloudfront.net/posterpreviews/artistic-album-cover-design-template-d12ef0296af80b58363dc0deef077ecc_screen.jpg?ts=1561488440");
//        Album album3 = new Album("Purple Rain","Prince and the Revolution", 7, (int) 550,"https://upload.wikimedia.org/wikipedia/en/3/32/Dua_Lipa_Swan_Song.png");
//        List<Album> albums = new ArrayList<>() ;
//        albums.add(album1);
//        albums.add(album2);
//        albums.add(album3);
//        albumRepository.save(album1);
//        albumRepository.save(album2);
//        albumRepository.save(album3);
//        model.addAttribute("albums",albums);
//        return "albums";
//    }

    @GetMapping("/albums")
    public String getAllAlbums(Model model){
//        List<Album> albums = albumRepository.findAll();
        model.addAttribute("albums",albumRepository.findAll());
        return "albums";
    }

    @GetMapping("/addAlbum")
    public String addAlbumForm(){
        return "addAlbum";
    }

    @PostMapping("/addAlbum")
    public RedirectView addAlbum(@ModelAttribute Album album) {
        System.out.println(album);
        albumRepository.save(album);
        return new RedirectView("/albums");
    }
}
