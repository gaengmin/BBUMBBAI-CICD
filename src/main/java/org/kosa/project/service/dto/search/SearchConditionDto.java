package org.kosa.project.service.dto.search;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.kosa.project.service.Enum.Category;
import org.kosa.project.service.Enum.MeetingStatus;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SearchConditionDto {
    private String keyword;
    private Category category;
    private String searchType;
    private MeetingStatus meetingStatus;
}