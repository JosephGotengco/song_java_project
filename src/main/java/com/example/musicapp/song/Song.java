package com.example.musicapp.song;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Song {
  @Id
  @SequenceGenerator(
    name = "song_sequence",
    sequenceName = "song_sequence",
    allocationSize = 1
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "song_sequence"
  )
  private Long id;
  private String title;
  private String author;
  private LocalDate releaseDate;

  public Song(String title, String author, LocalDate releaseDate) {
    this.title = title;
    this.author = author;
    this.releaseDate = releaseDate;
  }

  public Song() {
  }

  public Song(Long id, String title, String author, LocalDate releaseDate) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.releaseDate = releaseDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public LocalDate getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(LocalDate releaseDate) {
    this.releaseDate = releaseDate;
  }
  @Override
  public String toString() {
    return "Song [releaseDate=" + releaseDate + ", author=" + author + ", id=" + id + ", title=" + title + "]";
  }

}
