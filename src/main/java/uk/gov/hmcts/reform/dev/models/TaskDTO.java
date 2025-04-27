package uk.gov.hmcts.reform.dev.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskDTO {

    private String title;
    private String description;
    private Status status;
    private LocalDate dueDate;
}
