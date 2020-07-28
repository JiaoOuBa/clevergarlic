package com.dzp.clevergarlic.dto.admin.authDTO.response.permission;

import com.dzp.clevergarlic.dto.admin.authDTO.response.permission.CheckTokenData;
import com.dzp.clevergarlic.dto.common.CommonResponse;
import com.dzp.clevergarlic.entity.BaseHeader;

import java.util.Collection;
import java.util.Map;

/**
 * 校验token响应信息
 * @Auther ck
 * @Date 2020/7/27 14:48
 * @Desc
 */
public class CheckTokenResponse extends CommonResponse implements BaseHeader {

    private Map<String, Collection<String>> header;

    private CheckTokenData data;

    public CheckTokenData getData() {
        return data;
    }

    public void setData(CheckTokenData data) {
        this.data = data;
    }

    @Override
    public Map<String, Collection<String>> getHeader() {
        return header;
    }

    @Override
    public void setHeader(Map<String, Collection<String>> header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "CheckTokenResponse{" +
                "header=" + header +
                ", data=" + data +
                '}';
    }
}
