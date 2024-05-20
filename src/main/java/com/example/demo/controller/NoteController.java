package com.example.demo.controller;

import com.example.demo.entities.Note;
import com.example.demo.services.NoteCrudServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteCrudServiceImpl noteCrudService;

    public NoteController(NoteCrudServiceImpl noteCrudService) {
        this.noteCrudService = noteCrudService;
    }
    @GetMapping("/list")
    public String list(Model model){
        model.addAttribute("notes", noteCrudService.listAll());
        return "note-list";
    }
    @PostMapping("/delete")
    public String delete (@RequestParam Long id){
        noteCrudService.deleteById(id);
        return "redirect:/note/list";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam Long id, Model model){
        Note note = noteCrudService.getById(id);
        model.addAttribute("note", note);
        return "note-edit";
    }

    @PostMapping("/update")
    public String update(Note note){
        noteCrudService.update(note);
        return "redirect:/note/list";
    }
}
