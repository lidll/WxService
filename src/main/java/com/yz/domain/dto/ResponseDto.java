package com.yz.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
public class ResponseDto<T> {
    /*  *
     * @author zj
     *状态码
     */
    private int code = 200;

    /**
     * 提示信息
     */
    private String msg = "";
    /**
     * 在分页时,记录数据总数
     */
    private Integer total = null;
    /**
     * 泛型对象
     */
    private T obj;
    /**
     * 列表多个对象
     */
    private List<T> rows = new ArrayList<>();

    /**
     * 单个对象
     */
    private Object result;


    public ResponseDto(int code, String msg, Object result){
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public static ResponseDto success() {
        ResponseDto httpResponseDto = new ResponseDto();
        httpResponseDto.setCode(200);
        httpResponseDto.setMsg("操作成功");
        return httpResponseDto;
    }

    public static ResponseDto success(String msg) {
        ResponseDto httpResponseDto = new ResponseDto();
        httpResponseDto.setCode(200);
        httpResponseDto.setMsg(msg);
        return httpResponseDto;
    }

    public static ResponseDto error(int code, String errmsg) {
        ResponseDto httpResponseDto = new ResponseDto();
        httpResponseDto.setCode(code);
        httpResponseDto.setMsg(errmsg);
        return httpResponseDto;
    }

    public static ResponseDto error(String errmsg) {
        ResponseDto httpResponseDto = new ResponseDto();
        httpResponseDto.setCode(500);
        httpResponseDto.setMsg(errmsg);
        return httpResponseDto;
    }

    public static ResponseDto construct(List rows,int total) {
        ResponseDto httpResponseDto = new ResponseDto();
        httpResponseDto.setRows(rows);
        httpResponseDto.setTotal(total);
        return httpResponseDto;
    }
}
