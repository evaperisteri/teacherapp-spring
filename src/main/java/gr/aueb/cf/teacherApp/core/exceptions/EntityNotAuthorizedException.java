package gr.aueb.cf.teacherApp.core.exceptions;

public class EntityNotAuthorizedException extends EntityGenericException {
    private static String DEFAULT_CODE= "NotAuthorized";

    public EntityNotAuthorizedException(String code, String message) {
        super(code + DEFAULT_CODE, message);

    }
}
