package com.panji.security;

import com.panji.domain.SysUser;
import com.panji.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PikachuUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return sysUserService.findByUserName(username).map(sysUser -> {
            PikachuUser pikachuUser = new PikachuUser();
            pikachuUser.setSysUserId(sysUser.getId());
            pikachuUser.setUsername(sysUser.getUsername());
            pikachuUser.setPassword(sysUser.getPassword());
            //            AuthorityUtils.commaSeparatedStringToAuthorityList()
            //            pikachuUser.setAuthorities(new Collection<GrantedAuthority>());
            pikachuUser.setIsEnabled(sysUser.getIsEnbaled());
            pikachuUser.setIsAccountNonExpired(false);
            pikachuUser.setIsAccountNonLocked(false);
            pikachuUser.setIsCredentialsNonExpired(false);
            return pikachuUser;
        }).orElseThrow(() -> new UsernameNotFoundException("用户不存在"));
    }

    //save new user
    public UserDetails save(PikachuUser user) {
        SysUser sysUser = new SysUser();
        user.setUsername(user.getUsername());
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        sysUserService.save(sysUser);
        return loadUserByUsername(user.getUsername());
    }

}
