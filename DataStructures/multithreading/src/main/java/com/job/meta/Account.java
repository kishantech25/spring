package com.job.meta;
record Account(int id, String name) {

    public void process() {

        System.out.println(
                Thread.currentThread().getName()
                        + " processing "
                        + name
        );
    }


}