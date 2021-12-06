package com.yom.blinddate.cctv.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_cctv_source_diff")
public class CctvSourceDiff {
    @Id
    @Column(name = "gid")
    private Integer id;

    /*
        TODO : 아래 값 추출 방법
        road_name == road
        road_cate
        mesh_id
     */
    @Column(name = "source_id")
    private String sourceId;
    @Column(name = "src_cctv_id")
    private Integer srcCctvId;
    @Column(name = "old_road")
    private String oldRoad;
    @Column(name = "old_longitude")
    private String oldLongitude;
    @Column(name = "old_latitude")
    private String oldLatitude;
    @Column(name = "old_geom")
    private String oldGeom;
    @Column(name = "old_change_type")
    private Character oldChangeType;
    @Column(name = "old_change_date")
    private Date oldChangeDate;
    @Column(name = "old_offer")
    private String oldOffer;
    @Column(name = "old_location")
    private String oldLocation;
    @Column(name = "old_direction")
    private String oldDirection;
    @Column(name = "new_road")
    private String newRoad;
    @Column(name = "new_longitude")
    private String newLongitude;
    @Column(name = "new_latitude")
    private String newLatitude;
    @Column(name = "new_geom")
    private String newGeom;
    @Column(name = "new_change_type")
    private Character newChangeType;
    @Column(name = "new_change_date")
    private Date newChangeDate;
    @Column(name = "new_offer")
    private String newOffer;
    @Column(name = "new_location")
    private String newLocation;
    @Column(name = "new_direction")
    private String newDirection;
    @Column(name = "diff_dist")
    private Double diffDist;    // TODO : 데이터 타입 string 으로 할 지 고민해보기
    @Column(name = "cctv_id")
    private String cctvId;      // TODO : 나중에 n:1 연관관계로 설정 필요
    @Column(name = "change_type")
    private Character changeType;
    @Column(name = "change_desc")
    private String changeDesc;
    @Column(name = "result_type")
    private Character resultType;
    @Column(name = "comment")
    private String comment;

    @CreatedBy
    @Column(name = "reg_id")
    private String regId;
    @CreatedDate
    @Column(name = "reg_dtm")
    private Date regDtm;
    @LastModifiedBy
    @Column(name = "upd_id")
    private String updId;
    @LastModifiedDate
    @Column(name = "upd_dtm")
    private Date updDtm;
}
