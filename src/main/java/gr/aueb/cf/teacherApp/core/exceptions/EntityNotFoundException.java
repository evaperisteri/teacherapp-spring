package gr.aueb.cf.teacherApp.core.exceptions;

public class EntityNotFoundException extends EntityGenericException {
    private static String DEFAULT_CODE= "NotFound";

    public EntityNotFoundException(String code, String message) {
        super(code + DEFAULT_CODE, message);

    }
}
