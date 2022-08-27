package com.zclibre.system.module.system.service.convert;

import com.zclibre.system.module.security.pojo.PostInfo;
import com.zclibre.system.module.system.entity.SysPost;
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
public class SysPostConvertImpl implements SysPostConvert {

    @Override
    public PostInfo sourceToTarget(SysPost arg0) {
        if ( arg0 == null ) {
            return null;
        }

        PostInfo postInfo = new PostInfo();

        postInfo.setId( arg0.getId() );

        return postInfo;
    }

    @Override
    public SysPost targetToSource(PostInfo arg0) {
        if ( arg0 == null ) {
            return null;
        }

        SysPost sysPost = new SysPost();

        sysPost.setId( arg0.getId() );

        return sysPost;
    }

    @Override
    public List<PostInfo> sourceToTarget(List<SysPost> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<PostInfo> list = new ArrayList<PostInfo>( arg0.size() );
        for ( SysPost sysPost : arg0 ) {
            list.add( sourceToTarget( sysPost ) );
        }

        return list;
    }

    @Override
    public List<SysPost> targetToSource(List<PostInfo> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<SysPost> list = new ArrayList<SysPost>( arg0.size() );
        for ( PostInfo postInfo : arg0 ) {
            list.add( targetToSource( postInfo ) );
        }

        return list;
    }

    @Override
    public List<PostInfo> sourceToTarget(Stream<SysPost> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        return arg0.map( sysPost -> sourceToTarget( sysPost ) )
        .collect( Collectors.toCollection( ArrayList<PostInfo>::new ) );
    }

    @Override
    public List<SysPost> targetToSource(Stream<PostInfo> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        return arg0.map( postInfo -> targetToSource( postInfo ) )
        .collect( Collectors.toCollection( ArrayList<SysPost>::new ) );
    }
}
