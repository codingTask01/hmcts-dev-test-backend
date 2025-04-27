package uk.gov.hmcts.reform.dev.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "due_date")
    private LocalDate dueDate;

    public Task(String title, String description, LocalDate dueDate) {

        this.title = title;
        this.description = description;
        this.status = Status.NOT_STARTED;
        this.dueDate = dueDate;

    }

}
