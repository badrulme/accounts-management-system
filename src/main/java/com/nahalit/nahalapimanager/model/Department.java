package com.nahalit.nahalapimanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
//@Getter
//@Setter
@NoArgsConstructor
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item_facing")
  @SequenceGenerator(sequenceName = "s_rl_facing", allocationSize = 1, name = "rl_item_facing")
  private Long departmentId;
  @Transient
  private String departmentName;

  public Long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(Long departmentId) {
    this.departmentId = departmentId;
  }
  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }
}
