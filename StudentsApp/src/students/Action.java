package students;
 // Представляет собой вариант операции
import java.util.Objects;
import java.util.stream.Stream;

public enum Action {
    EXIT(0, false),
    CREATE(1, true),
    UPDATE(2, true),
    DELETE(3, true),
    STATS_BY_COURSE(4, false),
    SEARCH(6, true),
    ERROR(-1, false);
    private Integer code;
    private boolean reqiureAdditionalData;

    Action(Integer code, boolean reqiureAdditionalData) {
        this.code = code;
        this.reqiureAdditionalData = reqiureAdditionalData;
    }

    public Integer getCode() {
        return code;
    }

    public boolean isReqiureAdditionalData() {
        return reqiureAdditionalData;
    }

    public static Action fromCode(Integer code) {
        Action res = Stream.of(Action.values()).filter(action -> Objects.equals(action.getCode(), code))
                .findFirst()
                .orElseGet(() -> {
                    System.out.println("Неизвестный код действия " + code);
                    return Action.ERROR;
                });
        return res;
    }
}
