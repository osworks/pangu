package com.github.pangu.common.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student implements Serializable{
	
	private static final long serialVersionUID = -3305941882832738017L;
	
	private Long id;
	private String name;
	private Integer age;
	private Date birthday;
	private BigDecimal total;
	private Integer isBoy;
	private String remark;
	
}
