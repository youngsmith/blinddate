package com.yom.blinddate.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringExclude;

@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public abstract class Feature {
  @Id
  @GeneratedValue
  private Long id;

  @Id
  @Column(name = "snapshot_id")
  private Long snapshotId;
}
