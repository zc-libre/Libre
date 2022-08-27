package com.zclibre.system.module.system.service.convert;

import com.zclibre.system.module.security.pojo.RoleInfo;
import com.zclibre.system.module.system.entity.SysRole;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-08-26T22:59:41+0800",
    comments = "version: 1.5.0.RC1, compiler: javac, environment: Java 11.0.13 (Oracle Corporation)"
)
@Component
public class SysRoleConvertImpl implements SysRoleConvert {

    @Override
    public RoleInfo sourceToTarget(SysRole arg0) {
        if ( arg0 == null ) {
            return null;
        }

        RoleInfo roleInfo = new RoleInfo();

        roleInfo.setId( arg0.getId() );
        roleInfo.setTitle( arg0.getTitle() );

        return roleInfo;
    }

    @Override
    public SysRole targetToSource(RoleInfo arg0) {
        if ( arg0 == null ) {
            return null;
        }

        SysRole sysRole = new SysRole();

        sysRole.setId( arg0.getId() );
        sysRole.setTitle( arg0.getTitle() );

        return sysRole;
    }

    @Override
    public List<RoleInfo> sourceToTarget(List<SysRole> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<RoleInfo> list = new ArrayList<RoleInfo>( arg0.size() );
        for ( SysRole sysRole : arg0 ) {
            list.add( sourceToTarget( sysRole ) );
        }

        return list;
    }

    @Override
    public List<SysRole> targetToSource(List<RoleInfo> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<SysRole> list = new ArrayList<SysRole>( arg0.size() );
        for ( RoleInfo roleInfo : arg0 ) {
            list.add( targetToSource( roleInfo ) );
        }

        return list;
    }

    @Override
    public List<RoleInfo> sourceToTarget(Stream<SysRole> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        return arg0.map( sysRole -> sourceToTarget( sysRole ) )
        .collect( Collectors.toCollection( ArrayList<RoleInfo>::new ) );
    }

    @Override
    public List<SysRole> targetToSource(Stream<RoleInfo> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        return arg0.map( roleInfo -> targetToSource( roleInfo ) )
        .collect( Collectors.toCollection( ArrayList<SysRole>::new ) );
    }
}
