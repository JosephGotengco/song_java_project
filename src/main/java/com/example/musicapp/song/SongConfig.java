package com.example.musicapp.song;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SongConfig {
  
  @Bean
  CommandLineRunner commandLineRunner(SongRepository repository) {
    return args -> {
      Song call = new Song(
        1L,
        "Call",
        "Yutaka Hirasaka",
        LocalDate.of(2000, Month.JANUARY, 5)
      );

      Song tokyo = new Song( 
        2L,
        "Tokyo",
        "Bocchi",
        LocalDate.of(1998, Month.JANUARY, 5)
      );

      repository.saveAll(List.of(call, tokyo));
    };
  }
}
