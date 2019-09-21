package entity;

import lombok.*;

/**
 * 用于控制器类返回结果
 * @author jerry
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Result {
    /**
     * 是否成功
     */
    @NonNull
    private boolean flag;
    /**
     * 返回码
     */
    @NonNull
    private Integer code;
    /**
     * 返回信息
     */
    @NonNull
    private String message;
    /**
     * 返回数据
     */
    private Object data;

}
