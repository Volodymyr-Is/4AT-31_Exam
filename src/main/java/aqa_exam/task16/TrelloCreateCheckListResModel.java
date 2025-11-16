package aqa_exam.task16;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@Setter
@Getter
public class TrelloCreateCheckListResModel {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("idBoard")
    private String boardId;

    @JsonProperty("pos")
    private Double position;

    @JsonProperty("type")
    private String type;

    @JsonProperty("datasource")
    private Map<String, Object> datasource;

    @JsonProperty("limits")
    private Map<String, Object> limits;

    @JsonProperty("closed")
    private boolean closed;

    @JsonProperty("color")
    private String color;
}
