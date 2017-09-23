package com.mazinger.ishoddy.domain.managers.entities.common;

/**
 * Created by davidcavajimenez on 21/9/17.
 */

public class ErrorData
{
    private String errorCode;

    public String getErrorCode() { return this.errorCode; }

    public void setErrorCode(String errorCode) { this.errorCode = errorCode; }

    private String errorTitle;

    public String getErrorTitle() { return this.errorTitle; }

    public void setErrorTitle(String errorTitle) { this.errorTitle = errorTitle; }

    private String errorText;

    public String getErrorText() { return this.errorText; }

    public void setErrorText(String errorText) { this.errorText = errorText; }

    private String errorFlag;

    public String getErrorFlag() { return this.errorFlag; }

    public void setErrorFlag(String errorFlag) { this.errorFlag = errorFlag; }

    private String errorType;

    public String getErrorType() { return this.errorType; }

    public void setErrorType(String errorType) { this.errorType = errorType; }
}
