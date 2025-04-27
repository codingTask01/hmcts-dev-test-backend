package uk.gov.hmcts.reform.dev.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import uk.gov.hmcts.reform.dev.models.Task;
import uk.gov.hmcts.reform.dev.repositories.TaskRepository;

import java.time.LocalDate;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    TaskRepository taskRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Task task1 = new Task(
            "Finish project proposal",
            "Complete the draft for the client project proposal and review it.",
            LocalDate.of(2025, 5, 15)
        );

        Task task2 = new Task(
            "Prepare for sprint demo",
            "Create slides and organize the demo environment for the upcoming sprint review.",
            LocalDate.of(2025, 5, 18)
        );

        taskRepository.save(task1);
        taskRepository.save(task2);



    }
}
