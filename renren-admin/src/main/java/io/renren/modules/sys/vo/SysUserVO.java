package io.renren.modules.sys.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.renren.common.validator.group.AddGroup;
import io.renren.common.validator.group.RegisterGroup;
import io.renren.common.validator.group.UpdateGroup;
import io.renren.common.validator.group.UserInfoAddGroup;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author gaodp
 */
@Data
@ToString
public class SysUserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 公司名称
     */
    private String company;
    /**
     * 用户名
     */
    @NotBlank(message="用户名不能为空", groups = {RegisterGroup.class})
    @Pattern(regexp = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",message = "用户名输入不合法，请输入正确的手机号",groups = {RegisterGroup.class})
    private String username;
    /**
     * 密码
     */
    @NotBlank(message="密码不能为空", groups = {RegisterGroup.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    /**
     * 验证码
     */
    @NotBlank(message="验证码不能为空", groups = {RegisterGroup.class})
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String captcha;
    /**
     * 工号
     */
    private String jobNumber;
    /**
     * 身份证
     */
    private String identityCard;
    public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getIdentityCard() {
		return identityCard;
	}

	public void setIdentityCard(String identityCard) {
		this.identityCard = identityCard;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public List<Long> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<Long> roleIdList) {
		this.roleIdList = roleIdList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
     * 邮箱
     */
    private String email;
    /**
     * 审核状态，0-待审核，1-审核通过
     */
    private Integer audit;

    private List<Long> roleIdList;

}
