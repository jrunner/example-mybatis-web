package com.t2t.top.controller;

import com.t2t.top.constant.OperCodeConstants;
import com.t2t.top.exception.BizException;
import com.t2t.top.model.dto.ResponseDto;
import com.t2t.top.model.dto.UserDto;
import com.t2t.top.model.dto.UserSayDto;
import com.t2t.top.model.po.User;
import com.t2t.top.service.UserSayService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yangpengfei
 */
@Controller
@RequestMapping("/say")
public class UserSayController extends BaseController {

    private static Logger logger = Logger.getLogger(UserSayController.class);
    @Autowired
    private UserSayService userSayService;

    @RequestMapping("/query")
    @ResponseBody
    public ResponseDto query(UserSayDto dto) throws BizException {
        List<User> list = userSayService.query(dto);
        return ResponseDto.bulidSuccessResult().setResult(list);
    }

    @RequestMapping("/update")
    public String update(UserSayDto dto) throws BizException {
        ResponseDto responseDto = ResponseDto.bulidSuccess(Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            userSayService.add(dto);
        } catch (BizException e) {
            responseDto = ResponseDto.bulidFailResult().setResult(e.getMessage());
            getRequest().setAttribute("dto", responseDto);
            return "common/error";
        }
        return "redirect:/jsp/say/list.jsp";
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseDto del(UserSayDto dto) throws BizException {
        ResponseDto responseDto = ResponseDto.bulidSuccess(Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            userSayService.delete(dto);
        } catch (BizException e) {
            return ResponseDto.bulidFailResult().setResult(e.getMessage());
        }
        return responseDto.setResult(OperCodeConstants.SAY_DEL_SECCESS);
    }


}
