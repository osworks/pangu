package com.github.pangu.toolbox.util.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Teacher implements Serializable{
	
	private static final long serialVersionUID = 5123928028877184228L;
	
	private Long id;
	private String name;
	private Integer age;
	private Date birthday;
	private Integer grade;
	
}
