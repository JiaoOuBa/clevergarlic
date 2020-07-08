package com.dzp.clevergarlic.dto.common;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**执行sql-实体类
 * @Auther ck
 * @Date 2020/7/3 17:52
 * @Desc
 */
public class ExecuteSqlRequest implements Serializable {

    @ApiModelProperty("sql集合")
    private List<String> executeSqlList;

    public List<String> getExecuteSqlList() {
        return executeSqlList;
    }

    public void setExecuteSqlList(List<String> executeSqlList) {
        this.executeSqlList = executeSqlList;
    }
}
