package com.example.musicapp.song;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SongService {

	private final SongRepository songRepository;

	@Autowired
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

  public List<Song> getSongs() {
		return songRepository.findAll();
	}

	public void addNewSong(Song song) {
		Optional<Song> songOptional = songRepository
			.findSongByTitle(song.getTitle());
		if (songOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		songRepository.save(song);
	}

	public void deleteSong(Long songId) {
		boolean exists = songRepository.existsById(songId);
		if (!exists) {
			throw new IllegalStateException("song with id " + songId + " does not exist");
		}
		songRepository.deleteById(songId);
	}

	@Transactional
	public void updateSong(Long songId, String title) {
		Song song = songRepository.findById(songId).orElseThrow(() -> new IllegalStateException("song with id " + songId + " does not exist"));
		song.setTitle(title);
	}
}