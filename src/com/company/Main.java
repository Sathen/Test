package com.company;

import java.util.*;

public class Main {

    static int[] Ag1 = {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0};
    static int[] Ag2 = {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1};
    static int[] Ag3 = {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1};


    static List<Antibody> antibodyList = new ArrayList<Antibody>();
    static List<Antibody> antibodiesCloneList = new ArrayList<Antibody>();
    static Random random = new Random();



    private static Comparator<Antibody> sortbyaffinity = new Comparator<Antibody>() {
        @Override
        public int compare(Antibody o1, Antibody o2) {
            if (o1.getAffinity() > o2.getAffinity()) return 1;
            if (o1.getAffinity() < o2.getAffinity()) return -1;
            return 0;
        }
    };


    public static void main(String[] args) {


        antibodyList.add(new Antibody("Ab1"));
        antibodyList.add(new Antibody("Ab2"));
        antibodyList.add(new Antibody("Ab3"));
        antibodyList.add(new Antibody("Ab4"));
        antibodyList.add(new Antibody("Ab5"));
        antibodyList.add(new Antibody("Ab6"));


        for (Antibody a : antibodyList) {
            affinity(Ag1, a);
        }
        // select by affinity
        Collections.sort(antibodyList, sortbyaffinity);


        //count of copy and make clone
        for (int i = 0; i < 6; i++) {
            int N = 6 / (i + 1);
            antibodyList.get(i).setCountofclone(N);
            makeClone(antibodyList.get(i));
        }
        mutationClonePopulation();
        //affinity clone to Ag
        for (Antibody a : antibodiesCloneList) {
            affinity(Ag1, a);
        }
        //Select
        Collections.sort(antibodiesCloneList
                , sortbyaffinity);

        for (int i = 0; i < 6; i++) {
            if(antibodyList.get(i).getAffinity() > antibodiesCloneList.get(0).getAffinity())
                antibodyList.add(i,antibodiesCloneList.get(0));
        }



    }

    private static void mutationClonePopulation(){
        for(Antibody a : antibodiesCloneList){
            a.setpMutation((a.getAffinity()/6));
            int index = 0;
            int [] array = new int [12];
            array = a.getValue();
            for(int i = 0; i < 12*a.getpMutation();i++){
                index = random.nextInt(12);
                if(array[index]==0)
                    array[index]=1;
                else array[index]=0;
            }
            a.setValue(array);
        }


    }

    private static void makeClone(Antibody antibody){
        for(int i = 0; i < antibody.getCountofclone(); i++){
            antibodiesCloneList.add(new Antibody(antibody));
        }
    }


    private static void affinity(int[] antigen, Antibody ab) {
        int valueofaffinity = 0;
        int[] array = ab.getValue();
        for (int i = 0; i < 12; i++) {
            if (antigen[i] != array[i]) {
                valueofaffinity++;
            }
        }
        ab.setAffinity(valueofaffinity);
    }
}
