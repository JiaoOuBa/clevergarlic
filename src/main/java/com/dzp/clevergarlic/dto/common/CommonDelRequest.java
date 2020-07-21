package com.dzp.clevergarlic.dto.common;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/7/21 16:20
 * @Desc
 */
public class CommonDelRequest {

    @ApiModelProperty("id集合")
    @NotEmpty(message = "id集合不能为空")
    private List<String> ids;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }
}
