package com.encode.exception;

/**
 * Created by Madhusmita on 14/03/18.
 */
public class EncodeException extends Exception {

    private String messageKey;

    public EncodeException(){
        super();
    }

    public EncodeException(final String messageKey){
        super(messageKey);
        this.messageKey = messageKey;
    }
    public EncodeException(final String messageKey, final Throwable throwable) {
        super(messageKey, throwable);
        this.messageKey = messageKey;
    }
    public String getMessageKey() {
        return messageKey;
    }

    public void setMessageKey(String messageKey) {
        this.messageKey = messageKey;
    }


}
