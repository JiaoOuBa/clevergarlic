package com.dzp.clevergarlic.dto.admin.budgetPlanDTO.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * @Auther ck
 * @Date 2020/8/5 10:50
 * @Desc
 */

@Data
@Builder
public class BuildingListResponse {

    @ApiModelProperty("楼宇id")
    private String buildingId;

    @ApiModelProperty("楼宇名称")
    private String buildingName;

    @ApiModelProperty("类型id")
    private Integer typeId;

    @ApiModelProperty("房屋类型")
    private String buildingType;


}
