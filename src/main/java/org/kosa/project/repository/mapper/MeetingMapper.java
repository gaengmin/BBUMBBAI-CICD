package org.kosa.project.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.kosa.project.service.dto.MeetingDetailDto;
import org.kosa.project.service.dto.MeetingRegisterDto;
import org.kosa.project.service.dto.SearchCondition;

import java.util.List;

@Mapper
public interface MeetingMapper {
    void save(MeetingRegisterDto meetingDto);

    List<MeetingDetailDto> meetingList(@Param("condition") SearchCondition condition, @Param("pageSize") int pageSize);

    MeetingDetailDto detailMeeting(long meetingId);

    int countMeetings();

}
