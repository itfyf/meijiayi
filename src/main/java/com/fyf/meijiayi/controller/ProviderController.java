package com.fyf.meijiayi.controller;

import com.fyf.meijiayi.common.ICodes;
import com.fyf.meijiayi.common.Ret;
import com.fyf.meijiayi.pojo.SmbmsProvider;
import com.fyf.meijiayi.pojo.User;
import com.fyf.meijiayi.service.SmbmsProviderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
public class ProviderController {

    @Autowired
    private SmbmsProviderSerivce smbmsProviderSerivce;

    @RequestMapping(value = "providerList", method = RequestMethod.GET)
    public String providerList(){
        return "provider_list";
    }

    @RequestMapping(value = "/selectAll", method = RequestMethod.GET)
    @ResponseBody
    public Ret selectAll(){
        List<SmbmsProvider> smbmsProviders = smbmsProviderSerivce.selectAll();
        return new Ret(true, ICodes.SUCCESS, smbmsProviders);
    }

    @RequestMapping(value = "/queryPro", method = RequestMethod.GET)
    @ResponseBody
    public Ret queryPro(String queryProCode, String queryProName){
        if("".equals(queryProCode)){
            queryProCode = null;
        }
        if("".equals(queryProName)){
            queryProName = null;
        }
        if("".equals(queryProCode) && "".equals(queryProName)){
            return new Ret(false, ICodes.FAILED, "不存在");
        }
        List<SmbmsProvider> smbmsProviders = smbmsProviderSerivce.queryPro(queryProCode, queryProName);
        if(smbmsProviders.size() != 0){
            return new Ret(true, ICodes.SUCCESS, smbmsProviders);
        }
        return new Ret(false, ICodes.FAILED, "不存在");
    }


    @RequestMapping(value = "/providerDetail/{id}", method = RequestMethod.GET)
    public String providerDetail(@PathVariable("id") int id, HttpServletRequest request){
        SmbmsProvider smbmsProvider = smbmsProviderSerivce.selectById(id);
        request.setAttribute("smbmsProvider", smbmsProvider);
        return "provider_detail";
    }

    @RequestMapping(value = "/providerUpdate/{id}", method = RequestMethod.GET)
    public String providerUpdate(@PathVariable("id") int id, HttpServletRequest request){
        SmbmsProvider smbmsProvider = smbmsProviderSerivce.selectById(id);
        request.setAttribute("smbmsProvider", smbmsProvider);
        return "provider_update";
    }

    @RequestMapping(value = "/updatePro", method = RequestMethod.POST)
    @ResponseBody
    public Ret updatePro(@RequestBody SmbmsProvider smbmsProvider, HttpServletRequest request){
        smbmsProviderSerivce.updata(smbmsProvider);
        return new Ret(true, ICodes.SUCCESS, 1);
    }

    @RequestMapping(value = "/deletePro/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Ret deletePro(@PathVariable("id") int id){
        smbmsProviderSerivce.delete(id);
        return new Ret(true, ICodes.SUCCESS, 1);
    }

    @RequestMapping(value = "/providerAdd", method = RequestMethod.GET)
    public String providerAdd(){
        return "provider_add";
    }

    @RequestMapping(value = "/addPro", method = RequestMethod.POST)
    @ResponseBody
    public Ret addPro(@RequestBody SmbmsProvider smbmsProvider, HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        smbmsProvider.setId(new Random().nextInt());
        smbmsProvider.setCreatedby(user.getId());
        smbmsProvider.setCreationdate(new Date());
        smbmsProviderSerivce.addPro(smbmsProvider);
        return new Ret(true, ICodes.SUCCESS, 1);
    }

    @RequestMapping(value = "/isProCode/{code}", method = RequestMethod.GET)
    @ResponseBody
    public Ret isProCode(@PathVariable("code") String code){
        List<SmbmsProvider> proCode = smbmsProviderSerivce.isProCode(code);
        if(proCode.size() == 0){
            return new Ret(true, ICodes.SUCCESS, proCode);
        }
        return new Ret(false, ICodes.FAILED, "编码已经存在");

    }

    @RequestMapping(value = "/isProName/{name}", method = RequestMethod.GET)
    @ResponseBody
    public Ret isProName(@PathVariable("name") String name){
        List<SmbmsProvider> proName = smbmsProviderSerivce.isProName(name);
        if(proName.size() == 0){
            return new Ret(true, ICodes.SUCCESS, proName);
        }
        return new Ret(false, ICodes.FAILED, "名字已经存在");
    }
}
