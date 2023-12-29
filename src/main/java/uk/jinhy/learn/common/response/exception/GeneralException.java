package uk.jinhy.learn.common.response.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import uk.jinhy.learn.common.response.code.BaseErrorCode;
import uk.jinhy.learn.common.response.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
