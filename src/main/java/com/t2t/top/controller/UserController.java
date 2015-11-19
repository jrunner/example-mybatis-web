package com.t2t.top.controller;

import com.t2t.top.constant.OperCodeConstants;
import com.t2t.top.model.dto.ResponseDto;
import com.t2t.top.model.dto.UserDto;
import com.t2t.top.exception.BizException;
import com.t2t.top.model.po.User;
import com.t2t.top.service.UserService;
import com.t2t.top.util.GsonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author yangpengfei
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @RequestMapping("/ping")
    @ResponseBody
    public String ping() {
        return GsonUtils.toJson(ResponseDto.bulidSuccessResult().setResult("1"));
    }

    @RequestMapping("/query")
    @ResponseBody
    public ResponseDto query(UserDto dto) throws BizException {
        List<User> list = userService.query(dto);
        return ResponseDto.bulidSuccessResult().setResult(list);
    }

    @RequestMapping("/update")
    public String update(UserDto dto) throws BizException {
        ResponseDto responseDto = ResponseDto.bulidSuccess(Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            userService.add(dto);
        } catch (BizException e) {
            responseDto = ResponseDto.bulidFailResult().setResult(e.getMessage());
            getRequest().setAttribute("dto", responseDto);
            return "common/error";
        }
        return "redirect:/jsp/user/list.jsp";
    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseDto del(UserDto dto) throws BizException {
        ResponseDto responseDto = ResponseDto.bulidSuccess(Thread.currentThread().getStackTrace()[1].getMethodName());
        try {
            userService.delete(dto);
        } catch (BizException e) {
            return ResponseDto.bulidFailResult().setResult(e.getMessage());
        }
        return responseDto.setResult(OperCodeConstants.USER_DEL_SECCESS);
    }


}
