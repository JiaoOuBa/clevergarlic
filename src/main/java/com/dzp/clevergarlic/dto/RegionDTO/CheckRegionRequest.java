package com.dzp.clevergarlic.dto.RegionDTO;

import lombok.Data;

/**
 * @Auther ck
 * @Date 2020/8/18 17:26
 * @Desc
 */
@Data
public class CheckRegionRequest {

    private String province;
    private String city;
    private String area;
}
