package com.javafree.cloud.admin.restapi;

import com.javafree.cloud.admin.entity.Tenant;
import com.javafree.cloud.admin.entity.User;
import com.javafree.cloud.admin.service.TenantService;
import com.javafree.cloud.common.api.PageResult;
import com.javafree.cloud.common.api.RestApiParamBody;
import com.javafree.cloud.common.api.RestApiResponse;
import com.javafree.cloud.common.utils.JsonUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @version V1.0
 * @Description:租户管理相关接口
 * @Author gwz  gwz126@126.com
 * @Date 2022/4/22 15:31
 */
@Slf4j
@RestController
@Api(value = "租户管理相关接口", tags = {"租户管理相关接口"})
@RequestMapping("/tenant")
public class TenantRestApi {
    @Autowired
    TenantService tenantService ;

    @ApiOperation(value = "删除租户", notes = "删除租户")
    @DeleteMapping("/deleteTenant")
    public RestApiResponse deleteTenant(@RequestParam(name = "Tenantid", required = true) String tenantid){
        tenantService.deleteTenant(tenantid);
        log.info("成功删除租户信息，租户ID={}",tenantid);
        return  RestApiResponse.OK("成功删除租户信息!");
    }

    @ApiOperation(value = "批量删除租户信息", notes = "租户ids用逗号(,)分隔")
    @DeleteMapping("/deleteTenantByIds")
    public RestApiResponse deleteTenantByIds(@RequestParam(name = "ids", required = true) String ids){
        tenantService.deleteTenantByIds(Arrays.asList(ids.split(",")));
        log.info("成功批量删除租户信息，租户IDS={}",ids);
        return  RestApiResponse.OK("成功批量删除租户信息!");
    }

    @ApiOperation(value = "获得租户信息")
    @GetMapping("/getTenantById")
    public RestApiResponse<Tenant> getTenantById(@RequestParam("id") String id){
        Tenant orgTenant=tenantService.getTenantById(id);
        if (null==orgTenant) {
            log.info("未找到租户信息，租户ID={}",id);
            return  RestApiResponse.WARNING("未找到租户信息！", HttpStatus.NO_CONTENT);
        }
        log.info("找到租户信息，租户对象为:{}", JsonUtils.getJsonStringFromObject(orgTenant));
        return  RestApiResponse.OK(orgTenant);
    }

    @ApiOperation(value = "查询租户信息列表,多条件关系为and", notes = "查询租户信息列表,多条件关系为and")
    @PostMapping("/findTenantsByTenant")
    public RestApiResponse<PageResult<Tenant>> findTenantsByTenant(@RequestBody RestApiParamBody<Tenant> apiParam) {

        PageResult<Tenant>  tenantPage=tenantService.findTenantsByTenant(apiParam.getDataParam(),apiParam.getPageParam());
        if (null==tenantPage || tenantPage.getTotalElements()<1) {
            log.info("未找到租户信息,传入参数为:{}",JsonUtils.getJsonStringFromObject(apiParam.getDataParam()));
            return  RestApiResponse.WARNING("未找到租户信息!", HttpStatus.NO_CONTENT);
        }
        log.info("找到租户信息列表，传入参数为:{}", JsonUtils.getJsonStringFromObject(apiParam));
        return  RestApiResponse.OK(tenantPage);
    }

}