package com.ds.record;
// Record Inside Interface
@FunctionalInterface
public interface Company {

    public record DomainName(int domainId,String domainName){}

    public void print();
}
