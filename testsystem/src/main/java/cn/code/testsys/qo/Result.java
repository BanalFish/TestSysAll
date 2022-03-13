package cn.code.testsys.qo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data  //getter和setter函数
@AllArgsConstructor //全参构造
@NoArgsConstructor   //无参构造
@Accessors(chain = true)//可以链式操作，默认是false
@ApiModel(value = "返回结果模型")
public class Result<T>{
    @ApiModelProperty(value="状态码",required = true)
    private int code; //状态码
    @ApiModelProperty(value="信息",required = true)
    private String message;  //信息
    @ApiModelProperty(value="数据",required = true)
    private T data;  //数据
}
