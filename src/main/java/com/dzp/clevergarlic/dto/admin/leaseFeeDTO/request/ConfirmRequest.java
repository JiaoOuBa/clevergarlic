package com.dzp.clevergarlic.dto.admin.leaseFeeDTO.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Auther ck
 * @Date 2020/8/3 9:38
 * @Desc
 */

@Data
public class ConfirmRequest {

    @ApiModelProperty("类型：1确认，2反确认")
    @NotNull(message = "操作类型不能为空")
    private Integer type;

    @ApiModelProperty("租金参数id集合")
    @NotEmpty(message = "id必传")
    private List<String> leaseIds;
}
