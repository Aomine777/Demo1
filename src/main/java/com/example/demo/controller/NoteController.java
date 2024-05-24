package com.example.demo.controller;


import com.example.demo.dto.AddNoteRequest;
import com.example.demo.dto.UpdateRequest;
import com.example.demo.entity.Note;
import com.example.demo.service.NoteService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@Slf4j
public class NoteController {

    @Autowired
    NoteService noteService;

    @GetMapping
    public List<Note> getAllNotes() {
        return noteService.listAll();
    }

    @PostMapping
    public Note addNote(@Valid @RequestBody AddNoteRequest addNoteRequest) {
        Note newNote = new Note(null, addNoteRequest.getTitle(), addNoteRequest.getContent());
        noteService.add(newNote);

        return newNote;
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteService.getById(id);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable Long id, @Valid @RequestBody UpdateRequest updateNoteRequest) {
        Note note = new Note(id, updateNoteRequest.getTitle(), updateNoteRequest.getContent());
        noteService.update(note);
        return note;
    }


    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteService.deleteById(id);
    }
}