package com.zclibre.system.module.system.service.convert;

import com.zclibre.system.module.security.pojo.DeptInfo;
import com.zclibre.system.module.system.entity.SysDept;
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
public class SysDeptConvertImpl implements SysDeptConvert {

    @Override
    public DeptInfo sourceToTarget(SysDept arg0) {
        if ( arg0 == null ) {
            return null;
        }

        DeptInfo deptInfo = new DeptInfo();

        deptInfo.setId( arg0.getId() );

        return deptInfo;
    }

    @Override
    public SysDept targetToSource(DeptInfo arg0) {
        if ( arg0 == null ) {
            return null;
        }

        SysDept sysDept = new SysDept();

        sysDept.setId( arg0.getId() );

        return sysDept;
    }

    @Override
    public List<DeptInfo> sourceToTarget(List<SysDept> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<DeptInfo> list = new ArrayList<DeptInfo>( arg0.size() );
        for ( SysDept sysDept : arg0 ) {
            list.add( sourceToTarget( sysDept ) );
        }

        return list;
    }

    @Override
    public List<SysDept> targetToSource(List<DeptInfo> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<SysDept> list = new ArrayList<SysDept>( arg0.size() );
        for ( DeptInfo deptInfo : arg0 ) {
            list.add( targetToSource( deptInfo ) );
        }

        return list;
    }

    @Override
    public List<DeptInfo> sourceToTarget(Stream<SysDept> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        return arg0.map( sysDept -> sourceToTarget( sysDept ) )
        .collect( Collectors.toCollection( ArrayList<DeptInfo>::new ) );
    }

    @Override
    public List<SysDept> targetToSource(Stream<DeptInfo> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        return arg0.map( deptInfo -> targetToSource( deptInfo ) )
        .collect( Collectors.toCollection( ArrayList<SysDept>::new ) );
    }
}
