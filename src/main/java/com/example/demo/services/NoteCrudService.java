package com.example.demo.services;

import com.example.demo.entities.Note;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NoteCrudService{
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);
}
