package com.gxa.p2p.common.controller;

import com.gxa.p2p.common.domain.Logininfo;
import com.gxa.p2p.common.domain.Systemdictionaryitem;
import com.gxa.p2p.common.domain.Userinfo;
import com.gxa.p2p.common.mapper.UserinfoMapper;
import com.gxa.p2p.common.service.ISystemDictionaryItemService;
import com.gxa.p2p.common.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Autowired
    private ISystemDictionaryItemService iSystemDictionaryItemService;

    @RequestMapping("userInfo")
    public String UserInfo(Model model){
        Logininfo loginInfo = UserContext.getLoginInfo();
        model.addAttribute("logininfo",loginInfo);
        Userinfo userinfo=userinfoMapper.selectById(loginInfo.getId());
        model.addAttribute("userinfo",userinfo);
        List<Systemdictionaryitem> list=iSystemDictionaryItemService.listByParentSn("educationBackground");
        model.addAttribute("educationBackgrounds",list);
        model.addAttribute("incomeGrades",iSystemDictionaryItemService.listByParentSn("incomeGrade"));
        model.addAttribute("marriages",iSystemDictionaryItemService.listByParentSn("marriage"));
        model.addAttribute("kidCounts",iSystemDictionaryItemService.listByParentSn("kidCount"));
        model.addAttribute("houseConditions",iSystemDictionaryItemService.listByParentSn("houseCondition"));
        return "userInfo";
    }
}