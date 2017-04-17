
package com.yyq.holiday.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Dscription:
 * @Created: yyq
 * @Date: 2017/1/22 14:58
 * @version: 1.0.0.0
 */
public class ApplicationException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = -1965485273396810186L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationException.class);

    private Integer errorId;

    public ApplicationException(String message) {
        super(message);

    }

    public Integer getErrorId() {
        return errorId;
    }

    public void setErrorId(Integer errorId) {
        this.errorId = errorId;
    }
}
