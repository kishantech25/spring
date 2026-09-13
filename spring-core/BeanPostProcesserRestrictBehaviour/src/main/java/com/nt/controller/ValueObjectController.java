package com.nt.controller;

import com.nt.accesser.ProjectAccessor;
import com.nt.vo.ProjectVo;

public abstract class ValueObjectController {
    public void getValue(int projectId,String projectName,String title,String status){
        ProjectVo project=new ProjectVo();
        project.setProjectId(projectId);
        project.setProjectName(projectName);
        project.setTitle(title);
        project.setStatus(status);

        project.setCreateBy("Kishan");
        project.setLastModifiedBy("Pallavi");

        ProjectAccessor.insert(project);
    }
    public abstract ProjectVo getProjectVO();


}
