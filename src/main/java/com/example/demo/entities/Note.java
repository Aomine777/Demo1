package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Note {
    @Id
    private Long id;
    private String title;
    private String content;
}
