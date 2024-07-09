package org.kosa.project.repository;

import lombok.RequiredArgsConstructor;
import org.kosa.project.repository.mapper.MeetingMapper;
import org.kosa.project.service.dto.MeetingDetailDto;
import org.kosa.project.service.dto.MeetingRegisterDto;
import org.kosa.project.service.dto.UserMeetingCheckDto;
import org.kosa.project.service.dto.UserMeetingDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MeetingRepository {
    private final MeetingMapper meetingMapper;

    public void save(MeetingRegisterDto meetingDto) {
        meetingMapper.save(meetingDto);
    }

    public long selectLastInsertId(long userId){

        return meetingMapper.selectLastInsertId(userId);
    }
    public List<MeetingDetailDto> meetingList(int page, int pageSize) {
        return meetingMapper.meetingList(page, pageSize);
    }


    public int countMeetings() {
        return meetingMapper.countMeetings();
    }

    /*모임참여관련 */

    public void userMeetingSave(UserMeetingCheckDto userMeetingDto) {

        meetingMapper.userMeetingSave(userMeetingDto);
    }

    public String getUserMeetingCheck(long userId, long meetingId) {

        return meetingMapper.getUserMeetingCheck(userId, meetingId);
    }

    public MeetingDetailDto meetingDetails(long meetingId) {
        return meetingMapper.meetingDetails(meetingId);
    }

    /*모임참석 눌렀을시 현재원 수 업데이트*/
    public void meetingUpdatePresentCount(long meetingId){

        meetingMapper.meetingUpdatePresentCount(meetingId);
    }
    /*모임나가기*/
    public void exitMeeting(UserMeetingCheckDto userMeetingDto){
        meetingMapper.exitMeeting(userMeetingDto);
    }
}
