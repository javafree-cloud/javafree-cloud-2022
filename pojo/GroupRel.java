package com.javafree.cloud.admin.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import java.util.Date;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
/**
 * @Description:    群组与成员关联表
 * @Database:   table name is sys_org_group_rel
 */

@Entity
@DynamicInsert
@DynamicUpdate
@Table(name ="sys_org_group_rel")
@Schema(name = " GroupRel POJO ", description = "群组与成员关联表")
public class GroupRel  implements Serializable{

	private static final Long serialVersionUID = 8229502113165775777L;

	/**
	 * 主键id
	 */
	@ApiModelProperty("主键id")
  	@Id
	@GenericGenerator(name = "javafree_uuid", strategy = "com.javafree.cloud.common.id.JavaFreeUUIDGenerator")
	@GeneratedValue(generator = "javafree_uuid")
	@Column(name = "id",length = 22)
	private String id;

	/**
	 * 群组ID
	 */
	@ApiModelProperty("群组ID")
  	@Column(name = "group_id")
	private String groupId;

	/**
	 * 群组关联对象ID
	 */
	@ApiModelProperty("群组关联对象ID")
  	@Column(name = "obj_id")
	private String objId;

	/**
	 * 群组关联对象类型，1.机构部门(DEPT),2.用户(USER),3.角色(ROLE)
	 */
	@ApiModelProperty("群组关联对象类型，1.机构部门(DEPT),2.用户(USER),3.角色(ROLE)")
  	@Column(name = "obj_type")
	private String objType;

	/**
	 * 组名称
	 */
	@ApiModelProperty("组名称")
  	@Column(name = "group_name")
	private String groupName;

	/**
	 * 排序
	 */
	@ApiModelProperty("排序")
  	@Column(name = "rel_order")
	private Integer relOrder;

	/**
	 * 成员对象名称
	 */
	@ApiModelProperty("成员对象名称")
  	@Column(name = "obj_name")
	private String objName;

	/**
	 * 创建人
	 */
	@ApiModelProperty("创建人")
  	@Column(name = "create_by")
	private String createBy;

	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
  	@Column(name = "create_time")
  	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;

	/**
	 * 更新人
	 */
	@ApiModelProperty("更新人")
  	@Column(name = "update_by")
	private String updateBy;

	/**
	 * 更新时间
	 */
	@ApiModelProperty("更新时间")
  	@Column(name = "update_time")
  	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getRelOrder() {
		return relOrder;
	}

	public void setRelOrder(Integer relOrder) {
		this.relOrder = relOrder;
	}

	public String getObjName() {
		return objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}
