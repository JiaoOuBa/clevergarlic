package com.dzp.clevergarlic.web.admin;

import com.dzp.clevergarlic.dto.common.user.LoginRequest;
import com.dzp.clevergarlic.dto.common.user.User;
import com.dzp.clevergarlic.enums.ExceptionMsg;
import com.dzp.clevergarlic.result.Result;
import com.dzp.clevergarlic.result.ResultVo;
import com.dzp.clevergarlic.util.AESUtil;
import com.dzp.clevergarlic.util.Md5Util;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


/**
 * 登陆
 * @Auther ck
 * @Date 2020/7/9 16:43
 * @Desc
 */

@Api(value = "login", description = "后台登陆")
@Controller
public class LoginController {

    @Value("${cg.aes.key}")
    private String AES_KEY;

    @Autowired
    AESUtil aesUtil;

    @GetMapping("/login")
    public ModelAndView login12() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        return modelAndView;
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultVo authLogin(String username, String password) {

        /*String decrypt = Md5Util.str2MD5(password);*/
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 获取Subject对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            return Result.success();
        } catch (UnknownAccountException e) {
            return Result.error(ExceptionMsg.FAILED,e.getMessage());
        } catch (IncorrectCredentialsException e) {
            return Result.error(ExceptionMsg.FAILED,e.getMessage());
        } catch (LockedAccountException e) {
            return Result.error(ExceptionMsg.FAILED,e.getMessage());
        } catch (AuthenticationException e) {
            return Result.error(ExceptionMsg.FAILED,"认证失败！");
        }
    }

    @RequestMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        // 登录成后，即可通过Subject获取登录的用户信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("user", user);
        return "index";
    }
}
