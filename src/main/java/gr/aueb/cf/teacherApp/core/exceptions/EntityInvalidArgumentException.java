package gr.aueb.cf.teacherApp.core.exceptions;

public class EntityInvalidArgumentException extends EntityGenericException {
    private static String DEFAULT_CODE= "InvalidArgument";

    public EntityInvalidArgumentException(String code, String message) {
        super(code + DEFAULT_CODE, message);

    }
}
