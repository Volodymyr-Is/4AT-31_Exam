package aqa_exam.task16;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class TrelloCreateCardResModel {
    @JsonProperty("id")
    private String id;

    @JsonProperty("badges")
    private Map<String, Object> badges;

    @JsonProperty("checkItemStates")
    private List<Object> checkItemStates;

    @JsonProperty("closed")
    private boolean closed;

    @JsonProperty("dueComplete")
    private boolean dueComplete;

    @JsonProperty("dateLastActivity")
    private String dateLastActivity;

    @JsonProperty("desc")
    private String desc;

    @JsonProperty("descData")
    private Map<String, Object> descData;

    @JsonProperty("due")
    private String due;

    @JsonProperty("dueReminder")
    private String dueReminder;

    @JsonProperty("email")
    private String email;

    @JsonProperty("idBoard")
    private String boardId;

    @JsonProperty("idChecklists")
    private List<Object> checklistIds;

    @JsonProperty("idList")
    private String listId;

    @JsonProperty("idMembers")
    private List<Object> memberIds;

    @JsonProperty("idMembersVoted")
    private List<Object> membersVotedIds;

    @JsonProperty("idShort")
    private int shortId;

    @JsonProperty("idAttachmentCover")
    private String attachmentCoverId;

    @JsonProperty("labels")
    private List<Object> labels;

    @JsonProperty("idLabels")
    private List<Object> labelIds;

    @JsonProperty("manualCoverAttachment")
    private boolean manualCoverAttachment;

    @JsonProperty("name")
    private String name;

    @JsonProperty("nodeId")
    private String nodeId;

    @JsonProperty("pinned")
    private boolean pinned;

    @JsonProperty("pos")
    private double position;

    @JsonProperty("shortLink")
    private String shortLink;

    @JsonProperty("shortUrl")
    private String shortUrl;

    @JsonProperty("start")
    private String start;

    @JsonProperty("subscribed")
    private boolean subscribed;

    @JsonProperty("url")
    private String url;

    @JsonProperty("cover")
    private Map<String, Object> cover;

    @JsonProperty("isTemplate")
    private boolean isTemplate;

    @JsonProperty("cardRole")
    private String cardRole;

    @JsonProperty("mirrorSourceId")
    private String mirrorSourceId;

    @JsonProperty("attachments")
    private List<Object> attachments;

    @JsonProperty("stickers")
    private List<Object> stickers;

    @JsonProperty("limits")
    private Map<String, Object> limits;
}
