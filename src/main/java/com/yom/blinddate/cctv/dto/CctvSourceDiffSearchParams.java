package com.yom.blinddate.cctv.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isEmpty;

@Getter
@Setter
public class CctvSourceDiffSearchParams {
    private Character resultType;
    private Character changeType;
    private String updId;
    private String cctvId;
    private Date startDate;
    private Date endDate;
    private String sourceId;
    private Integer srcCctvId;
}
/*
create index idx_cctv_source_diff_old_geom
    on tb_cctv_source_diff using gist (old_geom);

create index idx_cctv_source_diff_new_geom
    on tb_cctv_source_diff using gist (new_geom);
 */