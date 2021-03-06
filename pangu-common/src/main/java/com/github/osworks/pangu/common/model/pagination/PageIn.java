package com.github.osworks.pangu.common.model.pagination;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页入参模型
 * @author xiongchun
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "PageIn", description = "分页入参")
public class PageIn implements Serializable{

    private static final long serialVersionUID = -5756604230854510842L;
    
    @ApiModelProperty(value = "每页显示条数，默认 10")
    private long pageSize = 10;

    @ApiModelProperty(value = "当前页")
    private long pageCurrent = 1;
    
    @ApiModelProperty(value = "是否进行 count 查询")
    private boolean searchCount = true;

}
