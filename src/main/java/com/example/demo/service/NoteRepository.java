package com.example.demo.service;


import com.example.demo.entity.Note;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    Note findByTitle(String title);

    Note findById(long id);

    void deleteById(long id);

    Note save(@NonNull Note note);

    List<Note> findAll();


}
