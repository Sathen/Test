package com.company;

import java.util.Random;


public class Antibody {

    private String name;
    private int[] value;
    private int affinity;
    private int countofclone;
    private int pMutation;


    public Antibody(String name) {
        Random r = new Random();
        this.name = name;
        this.value = new int[12];
        for (int i = 0; i < 12; i++) {
            this.value[i] = r.nextInt(2);
        }
        affinity = 0;
        countofclone = 0;
        pMutation = 0;
    }

    public Antibody(Antibody ab){
        Random r = new Random();
        this.name = ab.getName()+"_clone_"+r.nextInt();
        this.value = ab.getValue();
        this.affinity = ab.getAffinity();
        this.countofclone = ab.getCountofclone();
        this.pMutation = ab.getpMutation();

    }

    public int getpMutation() {
        return pMutation;
    }

    public void setpMutation(int pMutation) {
        this.pMutation = pMutation;
    }
    public int getCountofclone() {
        return countofclone;
    }

    public void setCountofclone(int countofclone) {
        this.countofclone = countofclone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getValue() {
        return value;
    }

    public void setValue(int[] value) {
        this.value = value;
    }

    public int getAffinity() {
        return affinity;
    }

    public void setAffinity(int affinity) {
        this.affinity = affinity;
    }
}

