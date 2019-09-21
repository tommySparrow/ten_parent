package entity;

import lombok.Data;

import java.util.List;

/**
 * 分页结果类
 * @author jerry
 */
@Data
public class PageResult<T> {
    private Long total;
    private List<T> rows;
}
