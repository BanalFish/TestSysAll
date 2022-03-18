package cn.code.testsys.qo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ApiModel(value = "返回双结果模型")
public class DoubResult<V> extends Result{
    @ApiModelProperty(value="副数据",required = true)
    private V dataSec;
}
