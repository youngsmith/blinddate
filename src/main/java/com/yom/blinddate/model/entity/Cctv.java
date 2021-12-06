package com.yom.blinddate.model.entity;

import com.yom.blinddate.model.FeatureId;
import com.yom.blinddate.model.FeatureIdGenerator;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Entity
@IdClass(FeatureId.class)
@Table(name = "cctv")
public class Cctv extends Feature {
  @Id
  @GenericGenerator(
      name = "cctvIdGenerator",
      strategy = FeatureIdGenerator.STRATEGY,
      parameters = {
          @Parameter(name = FeatureIdGenerator.FEATURE_TYPE, value = "CCTV")
      }
  ) // 생성할 것인지 아니면 그냥 업데이트만 할 것인지
  @GeneratedValue(generator = "cctvIdGenerator")
  private Long id;
  @Column(name = "mesh_id")
  private Long meshId;
  @Column(name = "road_cate")
  private String roadCate;
  private String offer;
}
