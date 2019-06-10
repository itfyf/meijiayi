package com.fyf.meijiayi.controller;

import com.fyf.meijiayi.common.ICodes;
import com.fyf.meijiayi.common.Ret;
import com.fyf.meijiayi.pojo.Bill;
import com.fyf.meijiayi.pojo.SmbmsProvider;
import com.fyf.meijiayi.pojo.User;
import com.fyf.meijiayi.service.BillService;
import com.fyf.meijiayi.service.SmbmsProviderSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private BillService billService;
    @Autowired
    private SmbmsProviderSerivce smbmsProviderSerivce;

    @RequestMapping(value = "/orderList", method = RequestMethod.GET)
    public String orderList(){
        return "orderlist";
    }

    @RequestMapping(value = "/orderAdd", method = RequestMethod.GET)
    public String orderAdd(){
        return "order_add";
    }

    @RequestMapping(value = "/orderDetail/{id}", method = RequestMethod.GET)
    public String orderDetail(@PathVariable("id") int id, HttpServletRequest request){
        Bill bill = billService.selectById(id);
        request.setAttribute("bill", bill);
        return "order_detail";
    }


    @RequestMapping(value = "/orderUpdate/{id}", method = RequestMethod.GET)
    public String orderUpdate(@PathVariable("id") int id, HttpServletRequest request){
        Bill bill = billService.selectById(id);
        request.setAttribute("bill", bill);
        return "order_update";
    }


    @RequestMapping(value = "/deleteOrder/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Ret deleteOrder(@PathVariable("id") int id){
        billService.delectById(id);
        return new Ret(true, ICodes.SUCCESS, 1);
    }


    /**
     * 查询所有的商品
     * @return
     */
    @RequestMapping(value = "/selectBillAll", method = RequestMethod.GET)
    @ResponseBody
    public Ret selectBillAll(){
        List<Bill> bills = billService.selectAllBill();
        return new Ret(true, ICodes.SUCCESS, bills);
    }

    /**
     * 查询供应商
     * @return
     */
    @RequestMapping(value = "/selectSmbmsProviderAll", method = RequestMethod.GET)
    @ResponseBody
    public Ret selectSmbmsProviderAll(){
        List<SmbmsProvider> smbmsProviders = smbmsProviderSerivce.selectAll();
        return new Ret(true, ICodes.SUCCESS, smbmsProviders);
    }

    /**
     * 添加
     * @param bill
     * @param request
     */
    @RequestMapping(value = "/saveBill", method = RequestMethod.POST)
    public void saveBill(Bill bill, HttpServletRequest request){
        bill.setCreationdate(new Date());
        bill.setProductdesc("测试");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        bill.setCreatedby(Integer.valueOf(user.getUsercode()));
        billService.saveBill(bill);
    }

    /**
     * 进货单查询
     * @param name
     * @param unit
     * @param payment
     * @return
     */
    @RequestMapping(value = "/quirePurchaseOrder", method = RequestMethod.GET)
    @ResponseBody
    public Ret quirePurchaseOrder(String name, String unit, String payment){
        if(name.equals("")){
            name = null;
        }
        if("--请选择--".equals(unit)){
            unit = null;
        }
        if("--请选择--".equals(payment)){
            payment = "未付款";
        }
        List<Bill> bills = billService.selectNameOrUnitOrPayment(name, unit, payment);
        if(bills.size() != 0){
            return new Ret(true,ICodes.SUCCESS,bills);
        }
        return new Ret(false, ICodes.FAILED, "查询为空");
    }
}
