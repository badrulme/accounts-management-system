package com.nahalit.nahalapimanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rl_item_size")
  @SequenceGenerator(sequenceName = "s_rl_item_size", allocationSize = 1, name = "rl_item_size")
  private Long studentId;
  private String studentName;
  @NotNull
//  @Column(name = "department_id")
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "department_id")
  private Department department;
}
