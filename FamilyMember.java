package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FamilyMember {
    String name;
    List<FamilyMember> children;
    List<FamilyMember> parents;

    static Set<FamilyMember> allMembers = new HashSet<>();

    public FamilyMember(String name) {
        this.name = name;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        allMembers.add(this);
    }


    public static void main(String[] args){
        FamilyMember vasya = new FamilyMember("Vasya");
        FamilyMember lena = new FamilyMember("Lena");
        FamilyMember petya = new FamilyMember("Petya");
        FamilyMember vova = new FamilyMember("Vova");
        FamilyMember motya = new FamilyMember("Motya");
        FamilyMember kuzma = new FamilyMember("Kuzma");
        FamilyMember stepan = new FamilyMember("Stepan");

        vasya.addChild(petya);
        vasya.addParent(vova);
        vasya.addChild(motya);
        vasya.addChild(stepan);
        vova.addChild(lena);
        motya.addChild(kuzma);

        vova.findRelatives("Vova");
        vova.findRelatives("Lena");
        vova.printTree();

    }

    public void addChild(FamilyMember child){

    this.children.add(child);
    child.parents.add(this);

    }

    public void addParent(FamilyMember parent){

    this.parents.add(parent);
    parent.children.add(this);

    }


    public FamilyMember findMemberByName(String name){
        return findByNameRecursive(this, name, new HashSet<>());}

    private FamilyMember findByNameRecursive(FamilyMember startingPointMember, String name, Set<FamilyMember> checked) {
        if (startingPointMember == null || checked.contains(startingPointMember)) {
            return null;
        }
        checked.add(startingPointMember);

        if (startingPointMember.name.equals(name)){
            return startingPointMember;
        } else {
            for (FamilyMember child : startingPointMember.children) {
                FamilyMember found = findByNameRecursive(child, name, checked);
                if (found != null) {
                    return found;
                }
            }
            for(FamilyMember parent : startingPointMember.parents) {
                FamilyMember found = findByNameRecursive(parent, name, checked);
                if (found != null) {
                    return found;
                }
            }

        }
        return null;
        }

    public Set<String> findRelatives(String name){
        Set<String>relatives = new HashSet<>();
        FamilyMember personForSearchingRelatives = findMemberByName(name);
        if (personForSearchingRelatives == null){
            System.out.println("Нет человека с именем " + name);
            return relatives;
        }
        findRelativesRecursive(personForSearchingRelatives, relatives, new HashSet<>());
        relatives.remove(personForSearchingRelatives.name);
        System.out.println(relatives);
        return relatives;

    }

    private void findRelativesRecursive(FamilyMember personForSearchingRelatives, Set<String> relatives, Set<FamilyMember>checked) {
        for(FamilyMember parent: personForSearchingRelatives.parents){
            if(parent.name != null && !checked.contains(parent)){
                relatives.add(parent.name);
                checked.add(parent);
                findRelativesRecursive(parent, relatives, checked);
            }
        }
        for(FamilyMember child:personForSearchingRelatives.children){
            if(child.name !=null && !checked.contains(child)){
                relatives.add(child.name);
                checked.add(child);
                findRelativesRecursive(child, relatives, checked);
            }
        }
    }

    public Set<FamilyMember> findRoot(){
        Set<FamilyMember>roots = new HashSet<>();
        for(FamilyMember member: allMembers){
            if(member.parents.isEmpty()){
                roots.add(member);

            }
        }
        return roots;
    }

    public void printTree() {
        Set<FamilyMember> rootsForTree = this.findRoot();
        for (FamilyMember root : rootsForTree) {
            System.out.println(root.name);
            printTreeRecursive(root, " ");
        }

    }
     private void printTreeRecursive(FamilyMember member, String otstup){
        for (FamilyMember child: member.children){
            System.out.println(otstup + child.name);
            printTreeRecursive(child, otstup + "  ");
        }

     }




}






