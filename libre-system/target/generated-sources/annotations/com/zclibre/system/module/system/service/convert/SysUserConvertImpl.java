package com.zclibre.system.module.system.service.convert;

import com.zclibre.system.module.system.entity.SysUser;
import com.zclibre.system.module.system.vo.UserVO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-26T19:36:15+0800",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
public class SysUserConvertImpl implements SysUserConvert {

    @Override
    public UserVO sourceToTarget(SysUser arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UserVO userVO = new UserVO();

        userVO.setId( arg0.getId() );
        userVO.setDeptId( arg0.getDeptId() );
        userVO.setUsername( arg0.getUsername() );
        userVO.setNickName( arg0.getNickName() );
        userVO.setEmail( arg0.getEmail() );
        userVO.setPhone( arg0.getPhone() );
        userVO.setGender( arg0.getGender() );
        userVO.setAvatar( arg0.getAvatar() );
        userVO.setIsAdmin( arg0.getIsAdmin() );
        userVO.setEnabled( arg0.getEnabled() );
        userVO.setLocked( arg0.getLocked() );
        userVO.setGmtCreateName( arg0.getGmtCreateName() );
        userVO.setGmtCreate( arg0.getGmtCreate() );
        userVO.setGmtModifiedName( arg0.getGmtModifiedName() );
        userVO.setGmtModified( arg0.getGmtModified() );

        return userVO;
    }

    @Override
    public SysUser targetToSource(UserVO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        SysUser sysUser = new SysUser();

        sysUser.setId( arg0.getId() );
        sysUser.setGmtCreate( arg0.getGmtCreate() );
        sysUser.setGmtModified( arg0.getGmtModified() );
        sysUser.setGmtCreateName( arg0.getGmtCreateName() );
        sysUser.setGmtModifiedName( arg0.getGmtModifiedName() );
        sysUser.setUsername( arg0.getUsername() );
        sysUser.setDeptId( arg0.getDeptId() );
        sysUser.setNickName( arg0.getNickName() );
        sysUser.setAvatar( arg0.getAvatar() );
        sysUser.setPhone( arg0.getPhone() );
        sysUser.setEmail( arg0.getEmail() );
        sysUser.setGender( arg0.getGender() );
        sysUser.setIsAdmin( arg0.getIsAdmin() );
        sysUser.setEnabled( arg0.getEnabled() );
        sysUser.setLocked( arg0.getLocked() );

        return sysUser;
    }

    @Override
    public List<UserVO> sourceToTarget(List<SysUser> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<UserVO> list = new ArrayList<UserVO>( arg0.size() );
        for ( SysUser sysUser : arg0 ) {
            list.add( sourceToTarget( sysUser ) );
        }

        return list;
    }

    @Override
    public List<SysUser> targetToSource(List<UserVO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<SysUser> list = new ArrayList<SysUser>( arg0.size() );
        for ( UserVO userVO : arg0 ) {
            list.add( targetToSource( userVO ) );
        }

        return list;
    }

    @Override
    public List<UserVO> sourceToTarget(Stream<SysUser> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        return arg0.map( sysUser -> sourceToTarget( sysUser ) )
        .collect( Collectors.toCollection( ArrayList<UserVO>::new ) );
    }

    @Override
    public List<SysUser> targetToSource(Stream<UserVO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        return arg0.map( userVO -> targetToSource( userVO ) )
        .collect( Collectors.toCollection( ArrayList<SysUser>::new ) );
    }
}
