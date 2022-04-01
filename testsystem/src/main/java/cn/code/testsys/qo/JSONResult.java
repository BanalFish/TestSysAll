package cn.code.testsys.qo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@Accessors(chain = true)//可以链式操作，默认是false
@ApiModel(value="返回登录结果")
public class JSONResult{

	@ApiModelProperty(value="状态",required = true)
	private boolean success = true;
	@ApiModelProperty(value="信息",required = true)
	private String msg = "成功";
	@ApiModelProperty(value="用户信息和权限",required = true)
	private Object result;

	public JSONResult(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public void mark(String msg) {
		this.success = false;
		this.msg = msg;
	}
}
