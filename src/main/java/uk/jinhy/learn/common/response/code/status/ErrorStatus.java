package uk.jinhy.learn.common.response.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import uk.jinhy.learn.common.response.code.BaseErrorCode;
import uk.jinhy.learn.common.response.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 공통 오류
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 사용자 관련 오류
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "사용자가 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "MEMBER4002", "닉네임은 필수 입니다."),

    // 게시글 관련 오류
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND, "ARTICLE4001", "게시글이 없습니다."),

    // Temp 관련 오류
    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트"),

    // FoodType
    BAD_FOODTYPE_EXCEPTION(HttpStatus.BAD_REQUEST, "FOOD4001", "잘못된 FoodType입니다."),

    // Restaurant
    BAD_RESTAURANT_EXCEPTION(HttpStatus.BAD_REQUEST, "RESTAURANT4001", "잘못된 Restaurant입니다."),

    // Mission
    BAD_MISSION_EXCEPTION(HttpStatus.BAD_REQUEST, "RESTAURANT4001", "잘못된 Mission입니다."),
    BAD_MISSION_STATUS_EXCEPTION(HttpStatus.BAD_REQUEST, "RESTAURANT4002", "잘못된 Mission Status입니다."),

    // Page Number
    BAD_PAGE_NUMBER_EXCEPTION(HttpStatus.BAD_REQUEST, "PAGE4001", "잘못된 Page Number입니다.")
    ;
    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
