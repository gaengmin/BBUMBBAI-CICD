package org.kosa.project.repository;

import lombok.RequiredArgsConstructor;
import org.kosa.project.service.dto.search.Page;
import org.kosa.project.service.dto.search.Pageable;
import org.kosa.project.repository.mapper.MeetingMapper;
import org.kosa.project.service.dto.RoomPermissionDto;
import org.kosa.project.service.dto.meeting.MeetingDetailDto;
import org.kosa.project.service.dto.meeting.MeetingRegisterDto;
import org.kosa.project.service.dto.meeting.MeetingSummaryDto;
import org.kosa.project.service.dto.search.SearchConditionDto;
import org.kosa.project.service.dto.user.UserMeetingCheckDto;
import org.springframework.stereotype.Repository;
import org.kosa.project.service.dto.user.UserMeetingDto;

@Repository
@RequiredArgsConstructor
public class MeetingRepository {
    private final MeetingMapper meetingMapper;

    public void save(MeetingRegisterDto meetingDto) {
        meetingMapper.save(meetingDto);
    }

    public long selectLastInsertId(long userId) {
        return meetingMapper.selectLastInsertId(userId);
    }

    public Page<MeetingSummaryDto> meetingList(SearchConditionDto searchConditionDto, Pageable pageable) {
        return meetingMapper.meetingList(searchConditionDto, pageable);
    }
    /*모임참여관련 */

    public void userMeetingSave(UserMeetingCheckDto userMeetingDto) {
        meetingMapper.userMeetingSave(userMeetingDto);
    }

    public String getUserMeetingCheck(long userId, long meetingId) {

        return meetingMapper.getUserMeetingCheck(userId, meetingId);
    }

    /**상세 게시물 DTO + USER_MEETING DTO 통합*/
    public MeetingDetailDto meetingDetails(long meetingId) {
        return meetingMapper.meetingDetails(meetingId);
    }

    /*모임참석 눌렀을시 현재원 수 업데이트*/


    public void meetingUpdatePresentStatus(long meetingId){
        meetingMapper.meetingUpdatePresentStatus(meetingId);
    }

    /*관리자가 Wait를 허용했을 떄*/
    public void userMeetingUpdate(UserMeetingCheckDto userMeetingCheckDto){
        meetingMapper.userMeetingUpdate(userMeetingCheckDto);
    }

    /*모임나가기*/
    public void exitMeeting(UserMeetingCheckDto userMeetingDto) {
        meetingMapper.exitMeeting(userMeetingDto);
    }

    public UserMeetingDto findUserMeetingByUserIdAndMeetingId(Long meetingId, Long userId) {
        return meetingMapper.findUserMeetingByUserIdAndMeetingId(meetingId, userId);
    }

    public RoomPermissionDto findRoomWithAllChatListByMeetingAndUser(Long meetingId, Long userId) {
        return meetingMapper.findRoomWithAllChatListByMeetingAndUser(meetingId, userId);
    }

    public void createMeetingRoom(long meetingId) {
        meetingMapper.createMeetingRoom(meetingId);
    }

    public void updateMeetingEndTime() {
        meetingMapper.updateMeetingEndTime();
    }
}
