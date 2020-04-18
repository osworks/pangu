package com.github.pangu.toolbox.util.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
public class TeacherVO extends Teacher implements Serializable{

    private static final long serialVersionUID = 3093868866760498089L;
    
    private String gradeDesc;
    
}
