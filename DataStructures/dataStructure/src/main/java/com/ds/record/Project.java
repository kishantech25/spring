package com.ds.record;
//Nested Loop
public record Project(int projectId,ProjectDetail detail) {
}
record  ProjectDetail(String name,int duration,long cost){}
