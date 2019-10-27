package com.heylhh.pmp.server.controller;

import com.google.common.collect.Maps;
import com.heylhh.pmp.common.response.BaseResponse;
import com.heylhh.pmp.common.response.StatusCode;
import com.heylhh.pmp.model.entity.SysUserEntity;
import com.heylhh.pmp.server.service.SysUserService;
import com.heylhh.pmp.server.shiro.ShiroUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author heylhh
 * @PackageName: PermissonManagementPlatform
 * @ClassName: SysUserController
 * @Description: 用户管理controller
 * @data：2019/10/27 22:30
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController{

    @Autowired
    private SysUserService sysUserService;

    //获取当前登录用户的详情
    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public BaseResponse currInfo(){
        BaseResponse response=new BaseResponse(StatusCode.Success);
        Map<String,Object> resMap= Maps.newHashMap();
        try {
            resMap.put("user",getUser());

        }catch (Exception e){
            return new BaseResponse(StatusCode.Fail);
        }
        response.setData(resMap);
        return response;
    }

    //修改登录密码
    @RequestMapping("/password")
    //@LogAnnotation("修改登录密码")
    public BaseResponse updatePassword(String password,String newPassword){
        if (StringUtils.isBlank(password) || StringUtils.isBlank(newPassword)){
            return new BaseResponse(StatusCode.PasswordCanNotBlank);
        }
        BaseResponse response=new BaseResponse(StatusCode.Success);

        try {
            //真正的处理逻辑：先校验旧密码输入是否正确，再更新新的密码
            SysUserEntity entity=getUser();
            final String salt=entity.getSalt();

            String oldPsd= ShiroUtil.sha256(password,salt);
            if (!entity.getPassword().equals(oldPsd)){
                return new BaseResponse(StatusCode.OldPasswordNotMatch);
            }
            String newPsd=ShiroUtil.sha256(newPassword,salt);

            //执行更新密码的逻辑
            log.info("~~~~旧密码正确，开始更新新的密码~~~~");

            sysUserService.updatePassword(entity.getUserId(),oldPsd,newPsd);
        }catch (Exception e){
            response=new BaseResponse(StatusCode.UpdatePasswordFail);
        }

        return response;
    }

}
