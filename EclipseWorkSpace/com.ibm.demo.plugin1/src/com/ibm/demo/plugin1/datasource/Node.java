package com.ibm.demo.plugin1.datasource;

import java.util.ArrayList;
import java.util.List;

public class Node {

    String name ;

    Node parent ;

    List<Node> children = new ArrayList<Node>(10);

   

    Node() {}

   

    Node(Node parent) {

       this .setParent(parent);

    }

 

    public String getName() {

       return name ;

    }

 

    public void setName(String name) {

       this . name = name;

    }

 

    public Node getParent() {

       return parent ;

    }

 

    public void setParent(Node parent) {

       this . parent = parent;

    }

   

    public void addChild(Node child) {

       child.setParent( this );

       children .add(child);

    }

   

    public void removeChild(Node child) {

       children .remove(child);

    }

   

    public List<Node> getChildren() {

       return children ;

    }

}