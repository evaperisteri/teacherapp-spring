package gr.aueb.cf.teacherApp.core.exceptions;

public class EntityAlreadyExistsException extends EntityGenericException {
    private static String DEFAULT_CODE= "AlreadyExists";

    public EntityAlreadyExistsException(String code, String message) {
        super(code + DEFAULT_CODE, message);

    }
}
