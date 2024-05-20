package com.example.demo.services;


import com.example.demo.entities.Note;
import com.example.demo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
@Service
public class NoteCrudServiceImpl implements NoteCrudService {
    @Autowired
    private NoteRepository noteRepository;

    public Note save(Note note) {
        return noteRepository.save(note);
    }
    private Map<Long, Note> notes = new HashMap<>();
    @Override
    public List<Note> listAll() {
        return new ArrayList<>(notes.values());
    }

    @Override
    public Note add(Note note) {
        note.setId(new Random().nextLong());
        notes.put(note.getId(), note);
        return note;
    }

    @Override
    public void deleteById(long id) {
        if(notes.containsKey(id)){
            notes.remove(id);
        } else {
            throw new RuntimeException("Note not found");
        }
    }

    @Override
    public void update(Note note) {
        if(notes.containsKey(note.getId())){
            notes.put(note.getId(), note);
        } else {
            throw new RuntimeException("Note not found");
        }
    }

    @Override
    public Note getById(long id) {
        if(notes.containsKey(id)){
            return notes.get(id);
        } else{
            throw new RuntimeException("Note not found");
        }
    }
}
