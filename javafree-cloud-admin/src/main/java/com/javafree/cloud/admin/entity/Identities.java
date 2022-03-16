package com.javafree.cloud.admin.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * @Description:    用户身份信息表，是机构、用户、角色关联表
 * @Database:   表名为 sys_org_identities
 */

@Entity
@Table(name ="sys_org_identities")
@ApiModel(value = " Identities对象 ", description = "用户身份信息表，是机构/用户/角色关联表")
public class Identities  implements Serializable{

	private static final Long serialVersionUID = 1825925195949390460L;

	/**
	 * 主键id
	 */
	@ApiModelProperty("主键id")
  	@Id
	@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
	@GeneratedValue(generator = "jpa-uuid")
	@Column(name = "id",length = 32)
	private String id;

	/**
	 * 机构部门ID
	 */
	@ApiModelProperty("机构部门ID")
  	@Column(name = "dept_id")
	private String dept_id;

	/**
	 * 用户ID
	 */
	@ApiModelProperty("用户ID")
  	@Column(name = "user_id")
	private String user_id;

	/**
	 * 角色ID
	 */
	@ApiModelProperty("角色ID")
  	@Column(name = "role_id")
	private String role_id;

	/**
	 * 关联名称，由(用户名：机构名：角色名,用：分隔)组成
	 */
	@ApiModelProperty("关联名称，由(用户名：机构名：角色名,用：分隔)组成")
  	@Column(name = "name")
	private String name;

	/**
	 * 排序
	 */
	@ApiModelProperty("排序")
  	@Column(name = "rel_order")
	private Integer rel_order;

	/**
	 * 描述
	 */
	@ApiModelProperty("描述")
  	@Column(name = "description")
	private String description;

	/**
	 * 创建人
	 */
	@ApiModelProperty("创建人")
  	@Column(name = "create_by")
	private String create_by;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
  	@Column(name = "create_time")
	private Date create_time;

	/**
	 * 更新人
	 */
	@ApiModelProperty("更新人")
  	@Column(name = "update_by")
	private String update_by;

	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
  	@Column(name = "update_time")
	private Date update_time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDept_id() {
		return dept_id;
	}

	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRel_order() {
		return rel_order;
	}

	public void setRel_order(Integer rel_order) {
		this.rel_order = rel_order;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCreate_by() {
		return create_by;
	}

	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}

}