package com.github.osworks.pangu.common.model.pagination;

import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页入参模型
 * @author xiongchun
 */
@Data
@Accessors(chain = true)
public class PageIn implements Serializable{

    private static final long serialVersionUID = -5756604230854510842L;
    
    /**
     * 每页显示条数，默认 10
     */
    private long pageSize = 10;

    /**
     * 当前页
     */
    private long pageCurrent = 1;
    
    /**
     * 是否进行 count 查询
     */
    private boolean searchCount = true;

}
