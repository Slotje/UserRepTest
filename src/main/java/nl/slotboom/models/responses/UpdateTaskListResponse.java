package nl.slotboom.models.responses;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import nl.slotboom.models.TaskLists;
import nl.slotboom.models.User;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class UpdateTaskListResponse {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("username")
    private String username;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("updatedAt")
    private Date updatedAt;

    public static UpdateTaskListResponse from(TaskLists taskLists, User user) {
        return UpdateTaskListResponse.builder()
                .id(taskLists.getId())
                .name(taskLists.getName())
                .description(taskLists.getDescription())
                .username(user.getUsername())
                .updatedAt(taskLists.getUpdatedAt())
                .build();
    }
}


