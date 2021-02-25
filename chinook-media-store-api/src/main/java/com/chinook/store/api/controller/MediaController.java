package com.chinook.store.api.controller;

import com.chinook.store.api.model.ArtistModel;
import com.chinook.store.api.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private ArtistRepository artistRepository;

    @GetMapping("/all-artists")
    public Iterable<ArtistModel> allArtists() {
        return artistRepository.findAll();
    }

    @PostMapping("/save-artists")
    public void saveArtist(ArtistModel artist) {
        artistRepository.save(artist);
    }

    @GetMapping("/find-artist/{id}")
    public ArtistModel findArtist(@PathVariable Integer id) {
        return artistRepository.findById(id).orElseThrow(() -> new RuntimeException("Artist id not found"));
    }

    @GetMapping("/find-artist-by-name/{name}")
    public Iterable<ArtistModel> findArtist(@PathVariable String name) {
        return artistRepository.findByNameStartsWith(name);
    }

    public void setArtistRepository(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }
}
