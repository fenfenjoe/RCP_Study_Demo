package com.ibm.demo.plugin1.datasource;

public class RootNode extends Node {

    private static RootNode root = null ;

   

    private RootNode() {}

   

    public static synchronized RootNode getRootNode() {

       if ( root == null ) {

           root = new RootNode();

           root .setParent( null );

          

           root .initRootNode();

       }

      

       return root ;

    }

   

    private void initRootNode() {

       Node user;

       Node sample1,sample2;

       Node expr1,expr2;

       Node proc1,proc2;

      

       user = new Node();

       user.setName( "Zhang" );

       root .addChild(user);

      

       user = new Node();

       user.setName( "Yang" );

       sample1 = new Node();

       sample1.setName( "Node1" );

       sample2 = new Node();

       sample2.setName( "Node2" );

       user.addChild(sample1);

       user.addChild(sample2);

      

       expr1 = new Node();

       expr1.setName( "Exp1" );

       expr2 = new Node();

       expr1.setName( "Exp2" );

      

       sample2.addChild(expr1);

       sample2.addChild(expr2);

      

       proc1 = new Node();

       proc2 = new Node();

       proc1.setName( "Proc1" );

       proc2.setName( "Proc2" );

      

       expr2.addChild(proc1);

       expr2.addChild(proc2);

 

       root .addChild(user);

      

       user = new Node();

       user.setName( "Wang" );

       root .addChild(user);    

    }

}
