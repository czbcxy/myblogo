package me.zbl.fullstack.service.impl;

import me.zbl.fullstack.consts.SessionConstants;
import me.zbl.fullstack.entity.Addr;
import me.zbl.fullstack.entity.User;
import me.zbl.fullstack.entity.dto.form.UserLoginForm;
import me.zbl.fullstack.entity.dto.form.UserRegisterForm;
import me.zbl.fullstack.mapper.AddrMapper;
import me.zbl.fullstack.mapper.UserMapper;
import me.zbl.fullstack.service.api.IUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 用户信息操作业务实现类
 *
 * @author czbcxy
 */
@Service
public class UserServiceImpl implements IUserService {
    private static Map<String, String> map = null;

    @Autowired
    private UserMapper mMapper;
    @Autowired
    private AddrMapper addrMapper;

    @Override
    public User loginAuthentication(UserLoginForm loginForm) {
        List<User> userList = mMapper.select(new User().setUsername(loginForm.getUsername()).setPassword(DigestUtils.md5Hex(loginForm.getPassword())));
        if (null != userList && userList.size() == 1) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public boolean registerUsernameCheckExist(UserRegisterForm registerForm) {
        return mMapper.select(new User().setUsername(registerForm.getUsername())).size() > 0;
    }

    @Override
    public void insertUser(User user) {
        String pwdStr = user.getPassword();
        user.setPassword(DigestUtils.md5Hex(pwdStr));
        mMapper.insertSelective(user);
    }

    @Override
    public void joinSession(HttpServletRequest request, HttpServletResponse resp, User user) {
        HttpSession requestSession = request.getSession(true);
        requestSession.setAttribute(SessionConstants.SESSION_CURRENT_USER, user);
    }

    @Override
    public void destroySession(HttpServletRequest request) {
        HttpSession requestSession = request.getSession(true);
        requestSession.removeAttribute(SessionConstants.SESSION_CURRENT_USER);
    }

    @Override
    public void saveuserIp(Addr addr) {
        if (map == null||map.size()<=0) {
            List<Addr> addrs = addrMapper.selectAll();
            map = addrs.stream().collect(Collectors.toMap(Addr::getAddr, x -> x.getAddr(), (k1, k2) -> k1));
        }
        if (!map.containsValue(addr.getAddr())) {
            addrMapper.insert(addr);
        }
    }
}
