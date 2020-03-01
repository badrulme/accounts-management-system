package com.nahalit.nahalapimanager.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class SaLookup extends Audit{
  @Id
  private Long lookupNo;
  @NotNull
  private String lookupName;
  private String descr;
  private Long canChange;
  private Long ssCreator;
  private Long ssModifier;
}
